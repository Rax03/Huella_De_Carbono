package org.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria", schema = "huelladecarbono")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "factor_emision")
    private Float factorEmision;

    @Column(name = "unidad", length = 10)
    private String unidad;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recomendacion> recomendaciones;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actividad> actividades;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(Float factorEmision) {
        this.factorEmision = factorEmision;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
