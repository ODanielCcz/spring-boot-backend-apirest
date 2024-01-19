package com.bolsadeideas.springboot.backend.apirest.models.entity;

import com.bolsadeideas.springboot.backend.apirest.models.domain.Puesto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, max = 10, message = "el tamaño tiene que estar entre 4 y 10 caracteres.")
    @Column(nullable = false, unique = true, length = 10)
    private String username;

    @NotEmpty(message = "no puede estar vacío")
    @Column(nullable = false, length = 60)
    private String password;

    private Boolean enabled;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, max = 30, message = "el tamaño tiene que estar entre 4 y 30 caracteres.")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, max = 30, message = "el tamaño tiene que estar entre 4 y 30 caracteres.")
    @Column(nullable = false)
    private String apellidoPaterno;

    @Size(min = 4, max = 30, message = "el tamaño tiene que estar entre 4 y 30 caracteres.")
    private String apellidoMaterno;

    @NotNull(message = "no puede estar vacío")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaNacimiento;

    @NotNull(message = "no puede estar vacío")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaIngreso;

    @Enumerated(EnumType.STRING) // dataType of your enum
    @Column(insertable = false, updatable = false , name = "tipo_puesto")
    private Puesto puesto;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})})
    private List<Rol> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
