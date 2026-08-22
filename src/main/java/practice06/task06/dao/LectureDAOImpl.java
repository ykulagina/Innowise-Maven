package practice06.task06.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice06.task06.SessionFactoryUtil;
import practice06.task06.model.Lecture;

public class LectureDAOImpl implements LectureDAO {
    @Override
    public Lecture findById(long id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Lecture lecture = session.get(Lecture.class, id);
        session.close();
        return lecture;
    }

    @Override
    public void save(Lecture lecture) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(lecture);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Lecture lecture) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(lecture);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Lecture lecture) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(lecture);
        transaction.commit();
        session.close();
    }
}
