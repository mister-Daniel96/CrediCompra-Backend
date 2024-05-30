package pe.edu.upc.aaw.credicomprabackend.dtos;

public class UsuarioDTO {


    private Long idUsuario;

    private String nameUsuario;

    private String passwordUsuario;

    private String emailUsuario;

    private Boolean enabledUsuario;

    private String streetUsuario;
    private Long ageUsuario;
    private Long dniUsuario;

    private Double creditUsuario;
    private Double creditUsuarioAvailable;
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Boolean getEnabledUsuario() {
        return enabledUsuario;
    }

    public void setEnabledUsuario(Boolean enabledUsuario) {
        this.enabledUsuario = enabledUsuario;
    }

    public String getStreetUsuario() {
        return streetUsuario;
    }

    public void setStreetUsuario(String streetUsuario) {
        this.streetUsuario = streetUsuario;
    }

    public Long getAgeUsuario() {
        return ageUsuario;
    }

    public void setAgeUsuario(Long ageUsuario) {
        this.ageUsuario = ageUsuario;
    }

    public Long getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(Long dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Double getCreditUsuario() {
        return creditUsuario;
    }

    public void setCreditUsuario(Double creditUsuario) {
        this.creditUsuario = creditUsuario;
    }

    public Double getCreditUsuarioAvailable() {
        return creditUsuarioAvailable;
    }

    public void setCreditUsuarioAvailable(Double creditUsuarioAvailable) {
        this.creditUsuarioAvailable = creditUsuarioAvailable;
    }
}
