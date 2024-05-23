package pe.edu.upc.aaw.credicomprabackend.dtos;


import pe.edu.upc.aaw.credicomprabackend.entities.Usuario;

import java.time.LocalDate;

public class PagoDTO {
    private Long idPago;

    private Double amountPago;
    private LocalDate datePagoVencimiento;
    private Usuario usuario;

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
