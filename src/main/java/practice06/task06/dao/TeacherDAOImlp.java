package practice06.task06.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice06.task06.SessionFactoryUtil;
import practice06.task06.model.Teacher;

import java.util.List;

public class TeacherDAOImlp implements TeacherDAO {
    @Override
    public Teacher findById(long id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.close();
        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        List<Teacher> teachers = session.createQuery("From Teacher").list();
        session.close();
        return teachers;
    }

    @Override
    public void save(Teacher teacher) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(teacher);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Teacher teacher) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(teacher);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Teacher teacher) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(teacher);
        transaction.commit();
        session.close();
    }
}
