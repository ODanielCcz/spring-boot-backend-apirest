package com.bolsadeideas.springboot.backend.apirest.models.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NumeroPago {

    PAGO_10_MESES(10),
    PAGO_12_MESES(12),
    PAGO_16_MESES(16),
    PAGO_24_MESES(24);

    final int numeroPago;

    NumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    @JsonCreator
    public static NumeroPago fromString(String value) {
        for (NumeroPago numeroPago : NumeroPago.values()) {
            if (numeroPago.name().equalsIgnoreCase(value)) {
                return numeroPago;
            }
        }

        throw new IllegalArgumentException("Pago Invalida: " + value);
    }

}
