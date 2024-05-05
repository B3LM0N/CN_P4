package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ExcursionDAO {

    /* */
    public Excursion porId(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Crear una consulta para recuperar todos los productos
        Query<Excursion> query = session.createQuery("from Excursion where id = :id", Excursion.class);
        query.setParameter("id", id);

        // Ejecutar la consulta y obtener la lista de productos
        Excursion excursion = query.uniqueResult();

        // Commit de la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();

        return excursion;
    }

    public static Excursion crear(Excursion excursion){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.persist(excursion);
        session.getTransaction().commit();
        session.close();
        System.out.println("**********");
        return excursion;
    }
}
