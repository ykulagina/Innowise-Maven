package practice06.task06.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice06.task06.SessionFactoryUtil;
import practice06.task06.model.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplineDAOImpl implements DisciplineDAO {
    @Override
    public Discipline findById(long id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Discipline discipline = session.get(Discipline.class, id);
        session.close();
        return discipline;
    }

    @Override
    public List<Discipline> findAll() {
        List<Discipline> disciplines = new ArrayList<>();
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        disciplines = session.createQuery("From Discipline").list();
        session.close();
        return disciplines;
    }

    @Override
    public void save(Discipline discipline) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(discipline);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Discipline discipline) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(discipline);
        transaction.commit();
        session.close();
    }
}
