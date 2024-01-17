package com.bolsadeideas.springboot.backend.apirest.models.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstatusCredito {

    PAGADO("PAGADO"),
    PENDIENTE_DE_PAGO("PENDIENTE DE PAGO");

    final String estatus;

    EstatusCredito(String estatus) {
        this.estatus = estatus;
    }

    @JsonCreator
    public static EstatusCredito fromString(String value) {
        for (EstatusCredito estatusCredito : EstatusCredito.values()) {
            if (estatusCredito.name().equalsIgnoreCase(value)) {
                return estatusCredito;
            }
        }

        throw new IllegalArgumentException("EstatusCredito Invalida: " + value);
    }

}
