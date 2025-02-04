package org.example.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HabitoId implements Serializable {
    private Long idUsuario;
    private Long idActividad;

    public HabitoId() {
    }

    public HabitoId(Long idUsuario, Long idActividad) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
    }

    // Getters, setters, equals, and hashCode methods
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HabitoId habitoId = (HabitoId) o;
        return Objects.equals(idUsuario, habitoId.idUsuario) &&
                Objects.equals(idActividad, habitoId.idActividad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idActividad);
    }
}