package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class InscripcionDAO {

    public static Inscripcion porId(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Crear una consulta para recuperar todos los productos
        Query<Inscripcion> query = session.createQuery("from Inscripcion where id = :id", Inscripcion.class);
        query.setParameter("id", id);

        // Ejecutar la consulta y obtener la lista de productos
        Inscripcion inscripcion = query.uniqueResult();

        // Commit de la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();
        return inscripcion;
    }
    public static Inscripcion crear(Inscripcion inscripcion){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(inscripcion);
        session.getTransaction().commit();
        session.close();
        return inscripcion;
    }
    public static Inscripcion borrar(Inscripcion inscripcion){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.delete(inscripcion);
        session.getTransaction().commit();
        session.close();
        return inscripcion;
    }
    public static Inscripcion mostrar(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Crear una consulta para recuperar todas las inscripciones
        Query<Inscripcion> query = session.createQuery("FROM Inscripcion", Inscripcion.class);
        List<Inscripcion> inscripciones = query.getResultList();
        // Commit de la transacción
        session.getTransaction().commit();
        // Cerrar la sesión
        session.close();
        return (Inscripcion) inscripciones;
    }
    public static Inscripcion mostrarPorSocio(int idSocio){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Crear una consulta para recuperar todos los productos
        Query<Inscripcion> query = session.createQuery("from Inscripcion where id = :id", Inscripcion.class);
        query.setParameter("id", idSocio);
        // Ejecutar la consulta y obtener la lista de productos
        List<Inscripcion> inscripciones = query.getResultList();
        // Commit de la transacción
        session.getTransaction().commit();
        // Cerrar la sesión
        session.close();
        return (Inscripcion) inscripciones;
    }
    public static Inscripcion mostrarPorFecha(Date fechaInicio, Date fechaFin){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Crear una consulta para recuperar todos los productos
        Query<Inscripcion> query = session.createQuery("FROM Inscripcion WHERE fechaInscripcion BETWEEN :fechaInicio AND :fechaFin", Inscripcion.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        List<Inscripcion> inscripciones = query.getResultList();
        // Commit de la transacción
        session.getTransaction().commit();
        // Cerrar la sesión
        session.close();
        return (Inscripcion) inscripciones;
    }
    public static Inscripcion mostrarPorSocioYFecha(int idSocio, Date fechaInicio, Date fechaFin){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // Crear una consulta para recuperar las inscripciones de un socio entre las fechas dadas
        Query<Inscripcion> query = session.createQuery("FROM Inscripcion WHERE socio.id = :idSocio AND fechaInscripcion BETWEEN :fechaInicio AND :fechaFin", Inscripcion.class);
        query.setParameter("idSocio", idSocio);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        List<Inscripcion> inscripciones = query.getResultList();
        // Commit de la transacción
        session.getTransaction().commit();
        // Cerrar la sesión
        session.close();
        return (Inscripcion) inscripciones;
    }

}
