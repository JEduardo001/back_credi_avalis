package crediAvalis.demo.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import crediAvalis.demo.Exception.NotFoundCreditApplication;
import crediAvalis.demo.dto.credit.DtoCreditApplicationFilterResponse;
import crediAvalis.demo.dto.credit.DtoCreditApplicationResponse;
import crediAvalis.demo.entities.CreditApplication;
import crediAvalis.demo.entities.CreditEntity;
import crediAvalis.demo.entities.CreditsObtained;
import crediAvalis.demo.entities.UserEntity;
import crediAvalis.demo.enums.CreditApplicationStatus;
import crediAvalis.demo.projection.interfaceProjection.CreditApplicationInterfaceProjection;
import crediAvalis.demo.projection.interfaceProjection.UserInterfaceProjection;
import crediAvalis.demo.repository.CreditApplicationRepository;
import crediAvalis.demo.repository.CreditRepository;
import crediAvalis.demo.repository.CreditsObtainedRepository;
import crediAvalis.demo.repository.UserRepository;
import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private CreditsObtainedRepository creditsObtainedRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditApplicationRepository creditApplicationRepository;


    public List<CreditApplicationInterfaceProjection> getCreditsApplicationByFilter(String filter){
        return creditApplicationRepository.findAllProjectedByFilter(CreditApplicationStatus.valueOf(filter));
    }

    public Set<DtoCreditApplicationFilterResponse> getUserCreditsApplicationFiltered(Integer idUser, String filter){
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
        Set<CreditApplication> creditsApplication = user.getListCreditsApplication();
        Set<DtoCreditApplicationFilterResponse> filteredCredits = creditsApplication.stream().filter(credit -> credit.getStatus().equals(CreditApplicationStatus.valueOf(filter)))
                .map(credit -> new DtoCreditApplicationFilterResponse(
                        credit.getId(),
                        credit.getName(),
                        credit.getAmountRequested(),
                        credit.getMonthsToPay(),
                        credit.getInterestRate(),
                        credit.getStatus(),
                        credit.getCreatedAt(),
                        credit.getCredit(),
                        credit.getUser()
                )).collect(Collectors.toSet());

        return filteredCredits;
    }

    public Page<CreditApplicationInterfaceProjection> getCreditsApplication(@RequestParam Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 3);
        return creditApplicationRepository.findAllProjectedBy(pageable);
    }

    public CreditApplication getSpecificCredit(Integer idApplicationCredit){
        CreditApplication credit =  creditApplicationRepository.findById(idApplicationCredit)
                .orElseThrow(() -> new NotFoundCreditApplication());
        return credit;
    }

    public DtoCreditApplicationResponse createCreditApplication(Integer idCredit, Integer idUser){
        CreditEntity credit = creditRepository.findById(idCredit).orElseThrow(() -> new NoSuchElementException("Not found credit"));
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("Not user found"));

        CreditApplication creditApplicationCreated = creditApplicationRepository.save(new CreditApplication(
                credit.getAmountRequested(),
                credit.getName(),
                credit.getMonthsToPay(),
                credit.getInterestRate(),
                CreditApplicationStatus.PENDING,
                LocalDate.now(),
                user,
                credit
        ));

        credit.setCreditApplication(creditApplicationCreated);
        //update total credits application
        user.setCreditsApplication(user.getCreditsApplication() + 1);
       return new DtoCreditApplicationResponse(creditApplicationCreated.getId());
    }

    public Page<CreditApplicationInterfaceProjection> getCreditsApplicationPending(){
        Pageable page = PageRequest.of(0,20);
        return creditApplicationRepository.findAllByStatus(CreditApplicationStatus.PENDING,page);

    }

    public Long getTotalCreditsApplication(){
        return creditApplicationRepository.count();
    }

    public Long getTotalCredits(){
        return creditRepository.count();
    }

    public void approveCreditApplication(Integer idCreditApplication, Integer idUser){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.APPROVED);

        CreditApplication credit = creditApplicationRepository.save(creditApplication);
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
        System.out.println("usuairoo" + idUser);

        CreditsObtained creditsObtained = new CreditsObtained(
                credit.getAmountRequested(),
                credit.getName(),
                credit.getMonthsToPay(),
                credit.getInterestRate(),
                LocalDate.now(),
                credit.getCredit(),
                user

        );
        //update total credits application
        user.setCreditsApplication(user.getCreditApproved() + 1);
        user.setCreditsObtained(creditsObtained);

        creditsObtainedRepository.save(creditsObtained);
    }

    public void rejectCreditApplication(Integer idCreditApplication){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.REJECTED);
        creditApplicationRepository.save(creditApplication);
    }

    public Page<CreditEntity> getCredits(Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,3);
       return creditRepository.findAllBy(page);
    }

    public void cancelCreditApplication(Integer idCreditApplication,Integer idUser){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.CANCELED);
        creditApplicationRepository.save(creditApplication);
        //update total credits application
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setCreditsApplication(user.getCreditsApplication() - 1);
    }
}