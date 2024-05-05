package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class SocioDAO {

    public Socio porId(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Crear una consulta para recuperar todos los productos
        Query<Socio> query = session.createQuery("from Socio where id = :id", Socio.class);
        query.setParameter("id", id);

        // Ejecutar la consulta y obtener la lista de productos
        Socio socio = query.uniqueResult();

        // Commit de la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();

        return socio;
    }

    public Socio crear(Socio socio){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(socio);
        session.getTransaction().commit();
        session.close();
        return socio;
    }
    public Estandar crearEstandar(Estandar estandar){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(estandar);
        session.getTransaction().commit();
        session.close();
        return estandar;
    }


}
