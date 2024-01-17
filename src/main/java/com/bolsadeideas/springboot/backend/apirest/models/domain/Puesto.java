package com.bolsadeideas.springboot.backend.apirest.models.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Puesto {

    ASESOR("ASESOR"),
    CAPTURISTA("CAPTURISTA"),
    SUPERVISOR("SUPERVISOR");

    final String puesto;

    Puesto(String puesto) {
        this.puesto = puesto;
    }

    @JsonCreator
    public static Puesto fromString(String value) {
        for (Puesto puesto : Puesto.values()) {
            if (puesto.name().equalsIgnoreCase(value)) {
                return puesto;
            }
        }

        throw new IllegalArgumentException("Especialidad Invalida: " + value);
    }

    public String getPuesto() {
        return puesto;
    }
}
