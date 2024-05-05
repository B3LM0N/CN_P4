package Modelo.Entidades.DAO;

import Modelo.Entidades.Estandar;
import Util.HibernateUtil;
import org.hibernate.Session;

public class EstandarDAO extends SocioDAO {

    public EstandarDAO() {
        super();
    }

    public Estandar crear(Estandar estandar) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(estandar);
        session.getTransaction().commit();
        session.close();
        return estandar;
    }
}