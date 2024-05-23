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
    @Column(name = "datePagoVencimiento")
    private LocalDate datePagoVencimiento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Pago() {
    }

    public Pago(Long idPago, Double amountPago, LocalDate datePagoVencimiento, Usuario usuario) {
        this.idPago = idPago;
        this.amountPago = amountPago;
        this.datePagoVencimiento = datePagoVencimiento;
        this.usuario = usuario;
    }

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

    public LocalDate getDatePagoVencimiento() {
        return datePagoVencimiento;
    }

    public void setDatePagoVencimiento(LocalDate datePagoVencimiento) {
        this.datePagoVencimiento = datePagoVencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
