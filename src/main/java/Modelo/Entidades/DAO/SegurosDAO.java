package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class SegurosDAO {

    public Seguro porId(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Crear una consulta para recuperar todos los productos
        Query<Seguro> query = session.createQuery("from Seguro where id = :id", Seguro.class);
        query.setParameter("id", id);

        // Ejecutar la consulta y obtener la lista de productos
        Seguro seguro = query.uniqueResult();

        // Commit de la transacción
        session.getTransaction().commit();

        // Cerrar la sesión
        session.close();

        return seguro;
    }
}

