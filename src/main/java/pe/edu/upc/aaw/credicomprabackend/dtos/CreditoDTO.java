package pe.edu.upc.aaw.credicomprabackend.dtos;

import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

public class CreditoDTO {
    private Long idCredito;
    private Usuario usuario;
    private Double interestRate;
    private String rateTime;
    private String capitalization;
    private String currency;
    private String duration;
    private String rateType;
    private double totalAmount;
    private double remainingAmount;
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

    public String isRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
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

    public Boolean getEnableCredito() {
        return enableCredito;
    }

    public void setEnableCredito(Boolean enableCredito) {
        this.enableCredito = enableCredito;
    }
}
