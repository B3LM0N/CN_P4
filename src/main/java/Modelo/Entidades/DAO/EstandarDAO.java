package Modelo.Entidades.DAO;

import Modelo.Entidades.Estandar;
import Modelo.Entidades.Socio;
import Util.HibernateUtil;
import org.hibernate.Session;

public class EstandarDAO extends SocioDAO {

    public EstandarDAO() {
        super();
    }

    public Estandar crearEstandar(Estandar estandar) {
        SocioDAO socioDAO = new SocioDAO();
        Socio socioCreado = socioDAO.crear(estandar); // Primero guardas el socio en la tabla Socio

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        // Sobreescribimos la entidad de estandar
        estandar.setIdSocio(socioCreado.getIdSocio());

        session.persist(estandar); // Luego guardas el estandar en su tabla específica
        session.getTransaction().commit();
        session.close();
        return estandar;
    }
}