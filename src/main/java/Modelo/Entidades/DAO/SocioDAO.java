package Modelo.Entidades.DAO;

import Modelo.Entidades.*;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SocioDAO {

    public Socio porId(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("from Socio where id = :id", Socio.class);
        query.setParameter("id", id);
        Socio socio = query.uniqueResult();
        session.getTransaction().commit();
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
    public Socio mostrar(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("FROM Socio", Socio.class);
        List<Socio> socios = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return (Socio) socios;
    }
    public Socio mostrarPorTipo(String tipoSocio){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<Socio> query = session.createQuery("FROM Socio where tipoSocio = :tipoSocio", Socio.class);
        List<Socio> socios = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return (Socio) socios;
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
