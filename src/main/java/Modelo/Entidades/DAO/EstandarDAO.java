package Modelo.Entidades.DAO;

import Modelo.Entidades.Estandar;
import Util.HibernateUtil;
import org.hibernate.Session;

public class EstandarDAO extends SocioDAO {

    public EstandarDAO() {
        super();
    }

    public Estandar crearEstandar(Estandar estandar) {
        SocioDAO socioDAO = new SocioDAO();
        socioDAO.crear(estandar); // Primero guardas el socio en la tabla Socio

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(estandar); // Luego guardas el estandar en su tabla específica
        session.getTransaction().commit();
        session.close();
        return estandar;
    }
}