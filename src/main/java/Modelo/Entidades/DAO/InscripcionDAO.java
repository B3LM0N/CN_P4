package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class InscripcionDAO {

    public Inscripcion porId(int id){
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


}
