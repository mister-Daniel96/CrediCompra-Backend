package pe.edu.upc.aaw.credicomprabackend.dtos;


import pe.edu.upc.aaw.credicomprabackend.entities.Credito;

import javax.persistence.*;
import java.time.LocalDate;

public class PagoDTO {

    private Long idPago;

    private Double amountPago;

    private LocalDate dateRecorded;
    private LocalDate dateExpiration;
    private Boolean enablePago;

    private Credito credito;

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Double getAmountPago() {
        return amountPago;
    }

    public void setAmountPago(Double amountPago) {
        this.amountPago = amountPago;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Boolean getEnablePago() {
        return enablePago;
    }

    public void setEnablePago(Boolean enablePago) {
        this.enablePago = enablePago;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }
}
