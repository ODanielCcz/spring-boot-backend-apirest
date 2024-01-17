package com.bolsadeideas.springboot.backend.apirest.models.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FrecuenciaPago {

    PAGO_SEMANAL("SEMANAL"),
    PAGO_QUINCENAL("QUINCENAL"),
    PAGO_MENSUAL("MENSUAL");

    final String frecuenciaPago;

    FrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    @JsonCreator
    public static FrecuenciaPago fromString(String value) {
        for (FrecuenciaPago frecuenciaPago : FrecuenciaPago.values()) {
            if (frecuenciaPago.name().equalsIgnoreCase(value)) {
                return frecuenciaPago;
            }
        }

        throw new IllegalArgumentException("FrecuenciaPago Invalida: " + value);
    }

}
