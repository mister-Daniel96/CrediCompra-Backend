package pe.edu.upc.aaw.credicomprabackend.dtos;
import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

import java.time.LocalDate;

public class CreditoDTO {
    private Long idCredito;
    private Usuario usuario;
    private Double interestRate;
    private String duration;
    private LocalDate dateRecorded;
    private double currentValue;
    private double remainingAmount;
    private Boolean annuities;
    private Boolean enableCredito;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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
