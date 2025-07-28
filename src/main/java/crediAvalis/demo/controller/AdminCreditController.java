package crediAvalis.demo.controller;

import crediAvalis.demo.dto.auth.DtoResponseWithData;
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
    public ResponseEntity<DtoResponseWithData> approveCreditApplication(@RequestParam Integer idCreditApplication, @RequestParam Integer idUser){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Credit Approved",HttpStatus.OK.value(),creditService.approveCreditApplication(idCreditApplication,idUser)
        ));
    }

    @PutMapping("/reject")
    public ResponseEntity<DtoResponseWithData> rejectCreditApplication(@RequestParam Integer idCreditApplication){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Credit Approved",HttpStatus.OK.value(),creditService.rejectCreditApplication(idCreditApplication)
        ));
    }

}
