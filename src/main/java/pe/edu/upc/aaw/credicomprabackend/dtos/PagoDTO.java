package pe.edu.upc.aaw.credicomprabackend.dtos;


import pe.edu.upc.aaw.credicomprabackend.entities.Credito;
import java.time.LocalDate;

public class PagoDTO {
    private Long idPago;
    private Credito credito;
    private Double amountPago;
    private LocalDate datePago;
    private Boolean enablePago;

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public Double getAmountPago() {
        return amountPago;
    }

    public void setAmountPago(Double amountPago) {
        this.amountPago = amountPago;
    }

    public LocalDate getDatePago() {
        return datePago;
    }

    public void setDatePago(LocalDate datePago) {
        this.datePago = datePago;
    }

    public Boolean getEnablePago() {
        return enablePago;
    }

    public void setEnablePago(Boolean enablePago) {
        this.enablePago = enablePago;
    }
}
