package pe.edu.upc.aaw.credicomprabackend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Pago")

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "idCredito")
    private Credito credito;
    @Column(name = "amountPago")
    private Double amountPago;
    @Column(name = "datePago")
    private LocalDate datePago;
    @Column(name = "enablePago")
    private Boolean enablePago;

    public Pago() {
    }

    public Pago(Long idPago, Credito credito, Double amountPago, LocalDate datePago) {
        this.idPago = idPago;
        this.credito = credito;
        this.amountPago = amountPago;
        this.datePago = datePago;
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

    public LocalDate getDatePago() {
        return datePago;
    }

    public void setDatePago(LocalDate datePago) {
        this.datePago = datePago;
    }
}