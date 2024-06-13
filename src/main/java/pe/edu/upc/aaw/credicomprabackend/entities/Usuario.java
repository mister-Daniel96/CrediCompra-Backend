package pe.edu.upc.aaw.credicomprabackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "nameUsuario", nullable = false, length = 100)
    private String nameUsuario;//puede ser username
    @Column(name = "passwordUsuario", nullable = false, length = 100)
    private String passwordUsuario;// puede ser password
    @Column(name = "emailUsuario", nullable = false, length = 50)
    private String emailUsuario;

    @Column(name = "enabledUsuario",nullable = false)
    private Boolean enabledUsuario;
    @Column (name = "streetUsuario",nullable = false)
    private String streetUsuario;
    @Column(name="ageUsuario")
    private Long ageUsuario;
    @Column (name = "dniUsuario",nullable = false,length = 45)
    private Long dniUsuario;
    @Column (name= "creditUsuario", nullable = false)
    private Double creditUsuario;


    @Column (name= "creditUsuarioAvailable")
    private Double creditUsuarioAvailable;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypeUser> roles;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nameUsuario, String passwordUsuario, String emailUsuario,
                   Boolean enabledUsuario, String streetUsuario, Long ageUsuario,
                   Long dniUsuario, Double creditUsuario, Double creditUsuarioAvailable,Double saldoUsuario,
                   List<TypeUser> roles) {
        this.idUsuario = idUsuario;
        this.nameUsuario = nameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.emailUsuario = emailUsuario;
        this.enabledUsuario = enabledUsuario;
        this.streetUsuario = streetUsuario;
        this.ageUsuario = ageUsuario;
        this.dniUsuario = dniUsuario;
        this.creditUsuario = creditUsuario;
        this.creditUsuarioAvailable = creditUsuarioAvailable;
        this.roles = roles;

    }


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

    public List<TypeUser> getRoles() {
        return roles;
    }

    public void setRoles(List<TypeUser> roles) {
        this.roles = roles;
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
