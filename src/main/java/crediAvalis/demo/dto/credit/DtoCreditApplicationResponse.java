package crediAvalis.demo.dto.credit;

public class DtoCreditApplicationResponse {
    private Integer idCreditApplication;

    public DtoCreditApplicationResponse(Integer idCreditApplication){
        this.idCreditApplication = idCreditApplication;
    }

    public void setIdCreditApplication(Integer idCreditApplication) {
        this.idCreditApplication = idCreditApplication;
    }

    public Integer getIdCreditApplication() {
        return idCreditApplication;
    }
}
