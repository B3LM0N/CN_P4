package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class SocioDAO {
    private final int CUOTA_MENSUAL = 10;
    public Socio porId(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("from Socio where id = :id", Socio.class);
        query.setParameter("id", id);
        Socio socio = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return socio;
    }

    public Socio crear(Socio socio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(socio);
        session.getTransaction().commit();
        session.close();
        return socio;
    }

    public Estandar crearEstandar(Estandar estandar) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(estandar);
        session.getTransaction().commit();
        session.close();
        return estandar;
    }

    public Federado crearFederado(Federado federado) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(federado);
        session.getTransaction().commit();
        session.close();
        return federado;
    }

    public Infantil crearInfantil(Infantil infantil) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(infantil);
        session.getTransaction().commit();
        session.close();
        return infantil;
    }

    public Estandar modificarSeguroSocio(int idSocio, int nuevoSeguroContratado) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Seguro nuevoSeguro = new Seguro();
        nuevoSeguro.setIdSeguro(nuevoSeguroContratado);
        nuevoSeguro.setSeguroContratado("");
        nuevoSeguro.setPrecio(0);


        Query<Estandar> modificarSeguro = session.createQuery("UPDATE Estandar SET seguroContratado = :nuevoSeguro WHERE idSocio = :idSocio");
        modificarSeguro.setParameter("nuevoSeguro", nuevoSeguro);
        modificarSeguro.setParameter("idSocio", idSocio);
        modificarSeguro.executeUpdate();

        Query<Estandar> recuperarSeguroSocioModificado = session.createQuery("FROM Estandar WHERE idSocio = :idSocio", Estandar.class);
        Estandar resultadoModificado = recuperarSeguroSocioModificado.setParameter("idSocio", idSocio).getSingleResult();

        session.getTransaction().commit();
        session.close();

        return resultadoModificado;
    }

    public List<Socio> mostrar() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("FROM Socio", Socio.class);
        List<Socio> socios = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return socios;
    }

    public List<Socio> mostrarPorTipo(String tipoSocio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("FROM Socio WHERE tipoSocio = :tipoSocio", Socio.class);
        query.setParameter("tipoSocio", tipoSocio);
        List<Socio> socios = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return socios;
    }
public double mostrarFacturaEstandar(int idSocio){
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
 String sql = ("SELECT " + CUOTA_MENSUAL + " + SUM(e.precioInscripcion + seg.precio) FROM Socio s " +
         "JOIN s.inscripciones i " +
         "JOIN i.excursion e " +
         "LEFT JOIN s.estandar es " +
         "LEFT JOIN es.seguroContratado seg " +
         "WHERE s.idSocio = :idSocio ");
    Query<Double> query = session.createQuery(sql, Double.class);
    query.setParameter("idSocio", idSocio);
    Double factura = query.getSingleResult();
    session.getTransaction().commit();
    session.close();
    return factura;
}

public double mostrarFacturaFederado(int idSocio){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // multiplicamos la cuota mensual * 0.05 para hacer una rebaja del 5%
        Double cuotaConDescuento = CUOTA_MENSUAL * 0.95;
        String sql = "SELECT " + cuotaConDescuento + " + SUM(e.precioInscripcion) " +
                "FROM Socio s " +
                "JOIN s.inscripciones i " +
                "JOIN i.excursion e " +
                "WHERE s.idSocio = :idSocio ";

        Query<Double> query = session.createQuery(sql, Double.class);
        query.setParameter("idSocio", idSocio);
        Double factura = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return factura;
}

public double mostrarFacturaInfantil(int idSocio){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // multiplicamos la cuota mensual * 0.5 para hacer una rebaja del 50%
        Double cuotaConDescuento = CUOTA_MENSUAL * 0.5;

        String sql = "SELECT " + cuotaConDescuento + " + SUM(e.precioInscripcion) " +
                    "FROM Socio s " +
                    "JOIN s.inscripciones i " +
                    "JOIN i.excursion e " +
                    "WHERE s.idSocio = :idSocio ";

        Query<Double> query = session.createQuery(sql, Double.class);
        query.setParameter("idSocio", idSocio);
        Double factura = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return factura;
    }

public Socio borrar(Socio socio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.delete(socio);
        session.getTransaction().commit();
        session.close();
        return socio;
}
}
