package org.example.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "huella")
public class Huella {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private org.example.entities.Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_actividad")
    private Actividad idActividad;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "unidad", nullable = false, length = 50)
    private String unidad;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fecha")
    private Instant fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.entities.Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(org.example.entities.Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Huella{" +
                "id=" + id +
                ", idActividad=" + idActividad.getNombre() +
                ", valor=" + valor +
                ", unidad='" + unidad + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}