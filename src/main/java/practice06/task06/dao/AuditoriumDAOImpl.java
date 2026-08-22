package practice06.task06.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice06.task06.SessionFactoryUtil;
import practice06.task06.model.Auditorium;

public class AuditoriumDAOImpl implements AuditoriumDAO {
    @Override
    public Auditorium findById(long id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Auditorium auditorium = session.get(Auditorium.class, id);
        session.close();
        return auditorium;
    }

    @Override
    public void save(Auditorium auditorium) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(auditorium);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Auditorium auditorium) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(auditorium);
        transaction.commit();
        session.close();
    }
}
