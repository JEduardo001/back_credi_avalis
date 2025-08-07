package crediAvalis.demo.service;

import crediAvalis.demo.dto.payment.DtoPayment;
import crediAvalis.demo.entities.CreditsObtained;
import crediAvalis.demo.entities.Payment;
import crediAvalis.demo.enums.PaymentCreditObtainedStatus;
import crediAvalis.demo.projection.interfaceProjection.PaymentProjection;
import crediAvalis.demo.repository.CreditsObtainedRepository;
import crediAvalis.demo.repository.PaymentRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    public List<Payment> getPayments(Integer idCreditObtained){
        CreditsObtained creditsObtained = creditsObtainedRepository.findById(idCreditObtained).
                orElseThrow(() -> new NoSuchElementException("Not credit obtained found"));
        return creditsObtained.getPayments();
    }

    public DtoPayment pay(Integer idCreditObtained){
        CreditsObtained creditsObtained = creditsObtainedRepository.findById(idCreditObtained).
                orElseThrow(() -> new NoSuchElementException("Not credit obtained found"));
        //total amount to pay
        Double amountToPay = creditsObtained.getAmountToPay();
        //amount paid
        Double amountPaid = creditsObtained.getAmountPaid();
        Double newAmountPaid = amountPaid + amountToPay / 2;
        creditsObtained.setAmountPaid(newAmountPaid);

        if(newAmountPaid.equals(amountToPay)){
            creditsObtained.setCreditFinishedPaying(true);
        }
        Payment pay = new Payment(
                amountToPay / 2,
                LocalDate.now(),
                PaymentCreditObtainedStatus.PAID,
                creditsObtained
        );
        paymentRepository.save(pay);
        creditsObtained.setPayment(pay);

        DtoPayment dtoPayment = new DtoPayment(
                pay.getId(),
                creditsObtained.getCreditFinishedPaying(),
                pay.getAmountPaid(),
                pay.getPaymentDate(),
                pay.getStatus()
        );
        return dtoPayment;
    }
}