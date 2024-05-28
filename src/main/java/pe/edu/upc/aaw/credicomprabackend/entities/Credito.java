package pe.edu.upc.aaw.credicomprabackend.entities;

import javax.persistence.*;

@Entity
@Table(name="Credito")

public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredito;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private Double interestRate; //Ejm.: 24.5%
    private String rateTime; //Ejm.: Tasa nominal "ANUAL" "QUINCENAL" "MENSUAL"
    private String capitalization; //Esto es obvio :V
    private String currency; //Ejm.: Soles o dolares
    private String duration; //Duracion del prestamo Ejm.: anual
    private boolean rateType; //Ejm.: Tasa nominal o efectiva ESTE SERA COMO UN TRIGGER
    private double totalAmount; //El monto del credito total
    private double remainingAmount; //El monto que le falta pagar del total, seria la diferencia del monto total con la suma de todos los pagos

    public Credito() {
    }

    public Credito(Long idCredito, Usuario usuario, Double interestRate, String rateTime, String capitalization, String currency, String duration, boolean rateType, double totalAmount, double remainingAmount) {
        this.idCredito = idCredito;
        this.usuario = usuario;
        this.interestRate = interestRate;
        this.rateTime = rateTime;
        this.capitalization = capitalization;
        this.currency = currency;
        this.duration = duration;
        this.rateType = rateType;
        this.totalAmount = totalAmount;
        this.remainingAmount = remainingAmount;
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

    public String getRateTime() {
        return rateTime;
    }

    public void setRateTime(String rateTime) {
        this.rateTime = rateTime;
    }

    public String getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(String capitalization) {
        this.capitalization = capitalization;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isRateType() {
        return rateType;
    }

    public void setRateType(boolean rateType) {
        this.rateType = rateType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
}
