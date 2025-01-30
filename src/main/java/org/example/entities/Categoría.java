package org.example.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "`categoría`", schema = "huelladecarbono")
public class Categoría {
    @Id
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "factor_emision")
    private Float factorEmision;

    @Column(name = "unidad", length = 10)
    private String unidad;

    @OneToMany(mappedBy = "idCategoria")
    private Set<Actividad> actividads = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCategoria")
    private Set<org.example.entities.Recomendacion> recomendacions = new LinkedHashSet<>();

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

    public Set<Actividad> getActividads() {
        return actividads;
    }

    public void setActividads(Set<Actividad> actividads) {
        this.actividads = actividads;
    }

    public Set<org.example.entities.Recomendacion> getRecomendacions() {
        return recomendacions;
    }

    public void setRecomendacions(Set<org.example.entities.Recomendacion> recomendacions) {
        this.recomendacions = recomendacions;
    }

}