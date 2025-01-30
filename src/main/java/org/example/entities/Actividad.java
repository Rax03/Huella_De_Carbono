package org.example.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actividad", schema = "huelladecarbono")
public class Actividad {
    @Id
    @Column(name = "id_actividad", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private org.example.entities.Categoría idCategoria;

    @OneToMany(mappedBy = "idActividad")
    private Set<org.example.entities.Habito> habitos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idActividad")
    private Set<org.example.entities.Huella> huellas = new LinkedHashSet<>();

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

    public org.example.entities.Categoría getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(org.example.entities.Categoría idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Set<org.example.entities.Habito> getHabitos() {
        return habitos;
    }

    public void setHabitos(Set<org.example.entities.Habito> habitos) {
        this.habitos = habitos;
    }

    public Set<org.example.entities.Huella> getHuellas() {
        return huellas;
    }

    public void setHuellas(Set<org.example.entities.Huella> huellas) {
        this.huellas = huellas;
    }

}