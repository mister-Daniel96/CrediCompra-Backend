package pe.edu.upc.aaw.credicomprabackend.dtos;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class CreditoDTO {

    private Long idCredito;
    private Double interestRate;
    private Long duration;
    private LocalDate dateRecorded;
    private LocalDate dateExpiration;
    private double currentValue;
    private double remainingAmount;
    private Boolean annuities;
    private Boolean enableCredito;
    private Long gracePeriod;
    private Usuario usuario;

    public Long getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Long gracePeriod) {
        this.gracePeriod = gracePeriod;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
