package crediAvalis.demo.controller;

import crediAvalis.demo.dto.auth.DtoResponseWithData;
import crediAvalis.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<DtoResponseWithData> getPayments(@RequestParam Integer idCreditObtained){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Payments obtained",HttpStatus.OK.value(),paymentService.getPayments(idCreditObtained)
        ));
    }

    @PostMapping
    public ResponseEntity<DtoResponseWithData> pay(@RequestParam Integer idCreditObtained){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Payment made",HttpStatus.OK.value(),paymentService.pay(idCreditObtained)
        ));
    }
}