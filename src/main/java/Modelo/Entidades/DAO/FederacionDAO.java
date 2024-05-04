package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class FederacionDAO {

    public Federacion porId(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Crear una consulta para recuperar todos los productos
        Query<Federacion> query = session.createQuery("from Federacion where id = :id", Federacion.class);
        query.setParameter("id", id);

        // Ejecutar la consulta y obtener la lista de productos
        Federacion fede = query.uniqueResult();

        // Commit de la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();

        return fede;
    }

}
