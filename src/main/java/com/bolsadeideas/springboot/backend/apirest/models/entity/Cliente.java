package com.bolsadeideas.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(nullable = false)
    private Double ingresosMensuales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(Double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }
}
