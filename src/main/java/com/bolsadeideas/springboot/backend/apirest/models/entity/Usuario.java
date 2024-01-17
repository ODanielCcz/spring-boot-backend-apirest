package com.bolsadeideas.springboot.backend.apirest.models.entity;

import com.bolsadeideas.springboot.backend.apirest.models.domain.Puesto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacío")
    @Size(min = 4, max = 10, message = "el tamaño tiene que estar entre 4 y 10 caracteres.")
    @Column(nullable = false, unique = true, length = 10)
    private String usuario;

    @NotEmpty(message = "no puede estar vacío")
    @Column(nullable = false, length = 60)
    private String contrasena;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
}
