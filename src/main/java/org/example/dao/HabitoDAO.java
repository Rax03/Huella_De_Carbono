package org.example.dao;

import org.example.conection.Connection;
import org.example.entities.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HabitoDAO {
    public static void InsertarHabito(Habito habito) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        Usuario usuarioPersistido = (Usuario) session.merge(habito.getIdUsuario());
        Actividad actividadPersistida = (Actividad) session.merge(habito.getIdActividad());
        habito.setIdUsuario(usuarioPersistido);
        habito.setIdActividad(actividadPersistida);
        Habito habitoExistente = session.get(Habito.class, habito.getId());
        if (habitoExistente != null) {
            System.err.println("El hábito ya existe.");
        } else {
            session.persist(habito);
            session.getTransaction().commit();
            System.out.println("El habita se a creado exitosamente.");
        }
    }

    public static Habito BuscarHabitoId(int idActividad) {
        Session session = Connection.getInstance().getSession();
        int idUsuario = Sesion.getSesion().getUsuario().getId();
        HabitoId habitoId = new HabitoId();
        habitoId.setIdUsuario(idUsuario);
        habitoId.setIdActividad(idActividad);
        return session.get(Habito.class, habitoId);
    }
    public static List<Habito> BuscarHabito() {
        Session session = Connection.getInstance().getSession();
        Query<Habito> query = session.createQuery(
                "SELECT h FROM Habito h " +
                        "JOIN FETCH h.idUsuario " +
                        "JOIN FETCH h.idActividad " +
                        "WHERE h.idUsuario.id = :idUsuario",  // Filtrar por el usuario logueado
                Habito.class
        ).setParameter("idUsuario", Sesion.getSesion().getUsuario().getId());
        List<Habito> habitos = query.list();
        return habitos;
    }
    public static void ActualizarHabito(Habito habito) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        Habito habitoExistente = session.get(Habito.class, habito.getId());
        if (habitoExistente != null) {
            session.merge(habito);  // Usa merge en lugar de update
            session.getTransaction().commit();
            System.out.println("Se ha actualizado el hábito.");
        } else {
            System.out.println("Error: El hábito no existe en la base de datos.");
            session.getTransaction().rollback();
        }
    }
    public static void EliminarHabito(Habito habito) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        try {
            HabitoId id = new HabitoId();
            id.setIdUsuario(Sesion.getSesion().getUsuario().getId());
            id.setIdActividad(habito.getId().getIdActividad());
            Habito habitoTMP = session.get(Habito.class, id);
            if (habitoTMP != null) {
                session.remove(habitoTMP); // Hibernate 6
                session.getTransaction().commit();
                System.out.println("Se ha eliminado el hábito correctamente.");
            } else {
                System.out.println("No se encontró el hábito con los IDs proporcionados.");
                session.getTransaction().rollback();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
