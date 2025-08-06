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

    @GetMapping("/getUserCreditsApplicationFiltered")
    public ResponseEntity<DtoResponseWithData> getUserCreditsApplicationFiltered(@RequestParam Integer idUser, @RequestParam String filter) {
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained filtered user credits application", HttpStatus.OK.value(), creditService.getUserCreditsApplicationFiltered(idUser,filter)
        ));
    }

    @GetMapping("/getCreditsApplicationFiltered")
    public ResponseEntity<DtoResponseWithData> getCreditsApplicationFiltered(@RequestParam String filter) {
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained filtered credits application", HttpStatus.OK.value(), creditService.getCreditsApplicationByFilter(filter)
        ));
    }

    @GetMapping("/getAllCreditsApplication")
    public ResponseEntity<DtoResponseWithData> getAllCreditsApplication(@RequestParam Integer pageNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained credits application", HttpStatus.OK.value(), creditService.getCreditsApplication(pageNumber)
        ));
    }

    @GetMapping("/totalCredits")
    public ResponseEntity<DtoResponseWithData> getTotalCredits() {
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained credits application", HttpStatus.OK.value(), creditService.getTotalCredits()
        ));
    }

    @GetMapping("/getTotalCreditsApplication")
    public ResponseEntity<DtoResponseWithData> getTotalCreditsApplication() {
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained total credits application", HttpStatus.OK.value(), creditService.getTotalCreditsApplication()
        ));
    }

    @GetMapping("/getAllCredits")
    public ResponseEntity<DtoResponseWithData> getCredits(@RequestParam Integer pageNumber){
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithData(
                "Obtained credits",HttpStatus.OK.value(),creditService.getCredits(pageNumber)
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
    public ResponseEntity<DtoResponseWithoutData> cancelCreditApplication(@RequestParam Integer idCreditApplication, @RequestParam Integer idUser){
        creditService.cancelCreditApplication(idCreditApplication,idUser);
        return ResponseEntity.status(HttpStatus.OK).body(new DtoResponseWithoutData(
                "Canceled application credit",HttpStatus.OK.value()
        ));
    }


}
