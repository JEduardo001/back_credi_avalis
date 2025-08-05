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

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
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


    public Page<CreditApplicationInterfaceProjection> getCreditsApplicationByFilter(String filter){
        Pageable pageable = PageRequest.of(0, 35);
        return creditApplicationRepository.findAllProjectedByFilter(CreditApplicationStatus.valueOf(filter),pageable);
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

    public Page<CreditApplicationInterfaceProjection> getCreditsApplication(){
        Pageable pageable = PageRequest.of(0, 35);
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

       return new DtoCreditApplicationResponse(creditApplicationCreated.getId());
    }

    public Page<CreditApplicationInterfaceProjection> getCreditsApplicationPending(){
        Pageable page = PageRequest.of(0,20);
        return creditApplicationRepository.findAllByStatus(CreditApplicationStatus.PENDING,page);

    }

    public void approveCreditApplication(Integer idCreditApplication, Integer idUser){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.APPROVED);

        CreditApplication credit = creditApplicationRepository.save(creditApplication);
        UserEntity user = userRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));


        CreditsObtained creditsObtained = new CreditsObtained(
                credit.getAmountRequested(),
                credit.getName(),
                credit.getMonthsToPay(),
                credit.getInterestRate(),
                LocalDate.now(),
                credit.getCredit(),
                user

        );

        creditsObtainedRepository.save(creditsObtained);
    }

    public void rejectCreditApplication(Integer idCreditApplication){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.REJECTED);
        creditApplicationRepository.save(creditApplication);
    }

    public List<CreditEntity> getCredits(){
       return creditRepository.findAll();
    }

    public void cancelCreditApplication(Integer idCreditApplication){
        CreditApplication creditApplication = creditApplicationRepository.findById(idCreditApplication)
                .orElseThrow(() -> new NotFoundCreditApplication());
        creditApplication.setStatus(CreditApplicationStatus.CANCELED);
        creditApplicationRepository.save(creditApplication);
    }
}