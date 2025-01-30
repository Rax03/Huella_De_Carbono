package org.example.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "huelladecarbono")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "`contraseña`", length = 100)
    private String contraseña;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "idUsuario")
    private List<Habito> habitos = new LinkedList<>();

    @OneToMany(mappedBy = "idUsuario")
    private List<Huella> huellas = new LinkedList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Habito> getHabitos() {
        return habitos;
    }

    public void setHabitos(List<Habito> habitos) {
        this.habitos = habitos;
    }

    public List<Huella> getHuellas() {
        return huellas;
    }

    public void setHuellas(List<Huella> huellas) {
        this.huellas = huellas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", habitos=" + habitos +
                ", huellas=" + huellas +
                '}';
    }
}