package pe.edu.upc.aaw.credicomprabackend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Credito")

public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredito;
    @Column(name = "interestRate")
    private Double interestRate; //Ejm.: 24.5%
    @Column(name = "duration")
    private Long duration; //Duracion en meses
    @Column(name = "dateRecorded")
    private LocalDate dateRecorded; //La fecha que se registra el credito
    @Column(name = "dateExpiration")
    private LocalDate dateExpiration; //La fecha para pagar cuando sea unico
    @Column(name = "currentValue")
    private double currentValue; //ES EL VALOR DEL PRODUCTO O ALGO PARECIDO
    @Column(name = "remainingAmount") //ES PARA VER EL MONTO QUE FALTA PAGAR
    private double remainingAmount; //El monto que le falta pagar del total, seria la diferencia del monto total con la suma de todos los pagos
    @Column(name = "annuities") //VALIDAMOS SI ES ANUALIDAD O NO
    private Boolean annuities; //si es con anualidades se hace la operacion sino solo se saca el VF para el plazo dado
    @Column(name = "enableCredito")
    private Boolean enableCredito; //Para determinar si pago el credito
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    public Credito() {
    }

    public Credito(Long idCredito, Usuario usuario, Double interestRate, Long duration, LocalDate dateRecorded, double currentValue, double remainingAmount, Boolean annuities, Boolean enableCredito, LocalDate dateExpiration) {
        this.idCredito = idCredito;
        this.interestRate = interestRate;
        this.dateExpiration=dateExpiration;
        this.duration = duration;
        this.dateRecorded = dateRecorded;
        this.dateExpiration = dateExpiration;
        this.currentValue = currentValue;
        this.remainingAmount = remainingAmount;
        this.annuities = annuities;
        this.enableCredito = enableCredito;
        this.usuario = usuario;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Long getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Long idCredito) {
        this.idCredito = idCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Boolean getAnnuities() {
        return annuities;
    }

    public void setAnnuities(Boolean annuities) {
        this.annuities = annuities;
    }

    public Boolean getEnableCredito() {
        return enableCredito;
    }

    public void setEnableCredito(Boolean enableCredito) {
        this.enableCredito = enableCredito;
    }
}
