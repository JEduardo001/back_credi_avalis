package crediAvalis.demo.controller;

import crediAvalis.demo.dto.auth.DtoResponseWithData;
import crediAvalis.demo.dto.auth.DtoResponseWithoutData;
import crediAvalis.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/credits")
public class AdminCreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/pending")
    public ResponseEntity<DtoResponseWithData> getCreditApplicationsPending(){
       return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
               "Obteined credits application pending",HttpStatus.OK.value(),creditService.getCreditsApplicationPending()
       ));
    }

    @PutMapping("/approve")
    public ResponseEntity<DtoResponseWithoutData> approveCreditApplication(@RequestParam Integer idCreditApplication, @RequestParam Integer idUser){
        creditService.approveCreditApplication(idCreditApplication,idUser);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithoutData(
                "Credit Approved",HttpStatus.OK.value()
        ));
    }

    @PutMapping("/reject")
    public ResponseEntity<DtoResponseWithoutData> rejectCreditApplication(@RequestParam Integer idCreditApplication){
        creditService.rejectCreditApplication(idCreditApplication);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithoutData(
                "Credit Approved",HttpStatus.OK.value()
        ));
    }

}
