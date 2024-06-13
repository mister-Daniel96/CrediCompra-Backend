package pe.edu.upc.aaw.credicomprabackend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pago")

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(name = "amountPago")
    private Double amountPago;
    @Column(name = "dateRecorded")
    private LocalDate dateRecorded;
    @Column(name = "dateExpiration")
    private LocalDate dateExpiration;
    @Column(name = "enablePago")
    private Boolean enablePago;

    @ManyToOne
    @JoinColumn(name = "idCredito")
    private Credito credito;
    public Pago() {
    }

    public Pago(Long idPago, Credito credito, Double amountPago, LocalDate dateRecorded, LocalDate dateExpiration, Boolean enablePago) {
        this.idPago = idPago;
        this.credito = credito;
        this.amountPago = amountPago;
        this.dateRecorded = dateRecorded;
        this.dateExpiration = dateExpiration;
        this.enablePago = enablePago;
    }

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
}