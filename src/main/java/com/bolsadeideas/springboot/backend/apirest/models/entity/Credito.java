package com.bolsadeideas.springboot.backend.apirest.models.entity;

import com.bolsadeideas.springboot.backend.apirest.models.domain.EstatusCredito;
import com.bolsadeideas.springboot.backend.apirest.models.domain.FrecuenciaPago;
import com.bolsadeideas.springboot.backend.apirest.models.domain.NumeroPago;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "creditos")
public class Credito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "no puede estar vacío")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrega;

    @NotNull(message = "no puede estar vacío")
    @Column(nullable = false)
    private Double montoCredito;

    @NotNull(message = "no puede ser vacia")
    @Enumerated(EnumType.STRING) // dataType of your enum
    private NumeroPago numeroPago;

    @NotNull(message = "no puede ser vacia")
    @Enumerated(EnumType.STRING) // dataType of your enum
    private FrecuenciaPago frecuenciaPago;

    @NotNull(message = "no puede ser vacia")
    @Enumerated(EnumType.STRING) // dataType of your enum
    private EstatusCredito estatusCredito;

    @NotNull(message = "no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario; // <== PUESTO DEL USUARIO (SOLO EL ASESOR)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(Double montoCredito) {
        this.montoCredito = montoCredito;
    }

    public NumeroPago getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(NumeroPago numeroPago) {
        this.numeroPago = numeroPago;
    }

    public FrecuenciaPago getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(FrecuenciaPago frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public EstatusCredito getEstatusCredito() {
        return estatusCredito;
    }

    public void setEstatusCredito(EstatusCredito estatusCredito) {
        this.estatusCredito = estatusCredito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
