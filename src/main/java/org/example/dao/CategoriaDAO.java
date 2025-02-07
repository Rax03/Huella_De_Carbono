package org.example.dao;


import org.example.conection.Connection;
import org.example.entities.Categoria;
import org.hibernate.Session;

public class CategoriaDAO {
    public static Categoria BuscarPorId(int id) {
        Session session = Connection.getInstance().getSession();
        return (Categoria) session.get(Categoria.class, id);
    }
}
