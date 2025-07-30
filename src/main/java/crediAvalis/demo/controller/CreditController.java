package crediAvalis.demo.controller;

import crediAvalis.demo.dto.auth.DtoResponseWithoutData;
import crediAvalis.demo.dto.auth.DtoResponseWithData;
import crediAvalis.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/getAllCreditsApplication")
    public ResponseEntity<DtoResponseWithData> getCreditsApplication(){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Get credits application",HttpStatus.OK.value(),creditService.getCreditsApplication()
        ));
    }

    @GetMapping("/getAllCredits")
    public ResponseEntity<DtoResponseWithData> getCredits(){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Credits obtained",HttpStatus.OK.value(),creditService.getCredits()
        ));
    }

    @GetMapping("/getSpecificCredit")
    public ResponseEntity<DtoResponseWithData> getSpecificCredit(@RequestParam Integer idApplicationCredit){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained credits application",HttpStatus.OK.value(),creditService.getSpecificCredit(idApplicationCredit)
        ));
    }

    @PostMapping
    public ResponseEntity<DtoResponseWithData> createCreditApplication(@RequestParam Integer idCredit,@RequestParam Integer idUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(new DtoResponseWithData(
                "Created application credit",HttpStatus.CREATED.value(),creditService.createCreditApplication(idCredit,idUser)
        ));
    }

    @PutMapping()
    public ResponseEntity<DtoResponseWithoutData> cancelCreditApplication(@RequestParam Integer idCreditApplication){
        creditService.cancelCreditApplication(idCreditApplication);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithoutData(
                "Canceled application credit",HttpStatus.OK.value()
        ));
    }


}
