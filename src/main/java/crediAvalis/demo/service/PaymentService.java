package crediAvalis.demo.service;

import crediAvalis.demo.entities.CreditsObtained;
import crediAvalis.demo.entities.Payment;
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

    public Payment pay(Integer idCreditObtained){
        CreditsObtained creditsObtained = creditsObtainedRepository.findById(idCreditObtained).
                orElseThrow(() -> new NoSuchElementException("Not credit obtained found"));

        Payment pay = new Payment(
                creditsObtained.getAmountPaid(),
                LocalDate.now(),
                creditsObtained
        );
        paymentRepository.save(pay);
        creditsObtained.setPayment(pay);
        return pay;
    }

}
