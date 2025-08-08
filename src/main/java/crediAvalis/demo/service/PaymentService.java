package crediAvalis.demo.service;

import crediAvalis.demo.dto.payment.DtoPayment;
import crediAvalis.demo.entities.CreditsObtainedEntity;
import crediAvalis.demo.entities.PaymentEntity;
import crediAvalis.demo.enums.PaymentCreditObtainedStatus;
import crediAvalis.demo.repository.CreditsObtainedRepository;
import crediAvalis.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CreditsObtainedRepository creditsObtainedRepository;

    public List<PaymentEntity> getPayments(Integer idCreditObtained){
        CreditsObtainedEntity creditsObtainedEntity = creditsObtainedRepository.findById(idCreditObtained).
                orElseThrow(() -> new NoSuchElementException("Not credit obtained found"));
        return creditsObtainedEntity.getPayments();
    }

    public DtoPayment pay(Integer idCreditObtained){
        CreditsObtainedEntity creditsObtainedEntity = creditsObtainedRepository.findById(idCreditObtained).
                orElseThrow(() -> new NoSuchElementException("Not credit obtained found"));
        //total amount to pay
        Double amountToPay = creditsObtainedEntity.getAmountToPay();
        //amount paid
        Double amountPaid = creditsObtainedEntity.getAmountPaid();
        Double newAmountPaid = amountPaid + amountToPay / 2;
        creditsObtainedEntity.setAmountPaid(newAmountPaid);

        if(newAmountPaid.equals(amountToPay)){
            creditsObtainedEntity.setCreditFinishedPaying(true);
        }
        PaymentEntity pay = new PaymentEntity(
                amountToPay / 2,
                LocalDate.now(),
                PaymentCreditObtainedStatus.PAID,
                creditsObtainedEntity
        );
        paymentRepository.save(pay);
        creditsObtainedEntity.setPayment(pay);

        DtoPayment dtoPayment = new DtoPayment(
                pay.getId(),
                creditsObtainedEntity.getCreditFinishedPaying(),
                pay.getAmountPaid(),
                pay.getPaymentDate(),
                pay.getStatus()
        );
        return dtoPayment;
    }
}