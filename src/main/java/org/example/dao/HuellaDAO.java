package org.example.dao;

import org.example.conection.Connection;
import org.example.entities.Actividad;
import org.example.entities.Huella;
import org.example.entities.Sesion;
import org.example.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HuellaDAO {
    public static void InsertHuella(Huella huella) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        Usuario usuarioPersistido = (Usuario) session.merge(huella.getIdUsuario());
        Actividad actividadPersistida = (Actividad) session.merge(huella.getIdActividad());
        huella.setIdUsuario(usuarioPersistido);
        huella.setIdActividad(actividadPersistida);
        Huella huellaExistente = session.createQuery(
                        "FROM Huella h WHERE h.idUsuario = :usuario AND h.idActividad = :actividad", Huella.class)
                .setParameter("usuario", huella.getIdUsuario())
                .setParameter("actividad", huella.getIdActividad())
                .uniqueResult();
        if (huellaExistente != null) {
            System.out.println("La huella ya existe.");
            session.getTransaction().rollback(); // Revertir cambios si ya existe
        } else {
            session.persist(huella);
            session.getTransaction().commit();
            System.out.println("Se ha agregado la huella.");
        }
    }
    public static Huella BuscarHuellaId(int idHuella) {
        Session session = Connection.getInstance().getSession();
        return session.get(Huella.class, idHuella);
    }
    public static List<Huella> BuscarHuella() {
        Session session = Connection.getInstance().getSession();
        Query<Huella> query = session.createQuery("SELECT h FROM Huella h " +
                                "JOIN FETCH h.idUsuario " +
                                "JOIN FETCH h.idActividad " +
                                "where h.idUsuario.id = :usuario",
                        Huella.class)
                .setParameter("usuario", Sesion.getSesion().getUsuario().getId());
        return query.list();
    }

    public static void ActualizarHuella(Huella huella) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();

        Huella huellaExistente = session.get(Huella.class, huella.getId());

        if (huellaExistente != null) {
            session.merge(huella);
            session.getTransaction().commit();
            System.out.println("Se ha actualizado el huella.");
        } else {
            System.out.println("Error: La huella no existe en la base de datos");
            session.getTransaction().rollback();
        }
    }

    public static void EliminarHuella(Huella huella) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        Huella huellaExistente = session.find(Huella.class, huella.getId());
        if (huellaExistente != null) {
            session.remove(huellaExistente);
            session.getTransaction().commit();
            System.out.println("Se ha eliminado la huella.");
        } else {
            session.getTransaction().rollback();
            System.out.println("La huella no existe, no se puede eliminar.");
        }
    }
    public static List<Huella> BuscarPorActividad(Actividad actividad) {
        Session session = Connection.getInstance().getSession();
        Query<Huella> query = session.createQuery("SELECT h FROM Huella h " +
                                "JOIN FETCH h.idUsuario " +
                                "JOIN FETCH h.idActividad " +
                                "where h.idActividad.id = :idActividad",
                        Huella.class)
                .setParameter("idActividad", actividad.getId());
        return query.list();
    }
}
