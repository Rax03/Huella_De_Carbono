package org.example.entities;



import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private org.example.entities.Categoria idCategoria;

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

    public org.example.entities.Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(org.example.entities.Categoria idCategoria) {
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

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idCategoria=" + idCategoria.getNombre() +
                ", habitos=" + habitos +
                ", huellas=" + huellas +
                '}';
    }
}