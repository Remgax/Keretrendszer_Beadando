package beadando.m5apwk.dao.relational;

import beadando.m5apwk.dao.DiakDAO;
import beadando.m5apwk.exceptions.DiakLetezik;
import beadando.m5apwk.exceptions.DiakNemTalalhato;
import beadando.m5apwk.model.Diak;
import beadando.m5apwk.model.Osztaly;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Collection;

public class DiakDAORelational implements DiakDAO {

    private static SessionFactory factory;
    public DiakDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();

    }

    @Override
    public void createDiak(Diak diak) throws DiakLetezik {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(diak);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Diak> readAllDiak() {
        Session session = factory.openSession();
        Collection<Diak> result = session.createQuery("FROM Diak").list();
        return result;
    }

    @Override
    public Diak readDiak(String id) throws DiakNemTalalhato {
        Session session = factory.openSession();
        Diak result = session.get(Diak.class, id);
        if (result == null) {
            throw new DiakNemTalalhato(id);
        }
        return result;
    }

    @Override
    public void updateDiak(Diak diak) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(diak);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteDiak(Diak diak) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(diak);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Diak> readAllDiakOfOsztaly(Osztaly osztaly) {
        Session session = factory.openSession();
        String hql = "From Diak WHERE osztaly = :osztaly";
        Query q = session.createQuery(hql);
        q.setParameter("osztaly",osztaly);
        Collection result = q.list();
        return result;
    }
}
