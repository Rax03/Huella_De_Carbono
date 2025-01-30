package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendacion", schema = "huelladecarbono")
public class Recomendacion {
    @Id
    @Column(name = "id_recomendacion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoría idCategoria;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "impacto_estimado")
    private Float impactoEstimado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoría getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoría idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getImpactoEstimado() {
        return impactoEstimado;
    }

    public void setImpactoEstimado(Float impactoEstimado) {
        this.impactoEstimado = impactoEstimado;
    }

}