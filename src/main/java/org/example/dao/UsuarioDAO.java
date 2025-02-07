package org.example.dao;

import org.example.conection.Connection;
import org.example.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAO {

    public static void InsertarUsuario(Usuario usuario) {
        Usuario usuarioTMP = BuscarNombreUsuario(usuario.getNombre());

        if (usuarioTMP != null) {
            System.out.println("El Usuario ya existe");
        } else {
            Session session = Connection.getInstance().getSession();
            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
            System.out.println("Usuario creado exitosamente");
        }
    }


    public static Usuario BuscarNombreUsuario(String nombre) {
        Session session = Connection.getInstance().getSession();
        Query<Usuario> query = session.createQuery("from Usuario where nombre = :nombre", Usuario.class)
                .setParameter("nombre", nombre);

        return query.uniqueResult();
    }

    public static Usuario BuscarPorId(int id) {
        Session session = Connection.getInstance().getSession();
        Query<Usuario> query = session.createQuery("from Usuario where id = :id", Usuario.class)
                .setParameter("id", id);

        return query.uniqueResult();
    }


    public static void ActualizarUsuario(Usuario usuario) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
        System.out.println("El usuario se actualizado exitosamente");
    }


    public static void EliminarUsuario(Usuario usuario) {
        Session session = Connection.getInstance().getSession();
        session.beginTransaction();
        Usuario usuarioManaged = (Usuario) session.merge(usuario);
        session.delete(usuarioManaged);
        session.getTransaction().commit();
        session.close(); // Cerramos la sesión
        System.out.println("El usuario se a eliminado exitosamente");
    }
}
