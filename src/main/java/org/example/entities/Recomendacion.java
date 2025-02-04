package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendacion", schema = "huelladecarbono")
public class Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "impacto_estimado")
    private Float impactoEstimado;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
