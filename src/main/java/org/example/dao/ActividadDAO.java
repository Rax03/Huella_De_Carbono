package org.example.dao;


import org.example.conection.Connection;
import org.example.entities.Actividad;
import org.hibernate.Session;

import java.util.List;

public class ActividadDAO {
    public static Actividad BuscarPorId(int id) {
        Session session = Connection.getInstance().getSession();
        return (Actividad) session.get(Actividad.class, id);
    }

    public static List<Actividad> BuscarTodasActividades() {
        Session session = Connection.getInstance().getSession();
        return session.createQuery("from Actividad").list();
    }
}
