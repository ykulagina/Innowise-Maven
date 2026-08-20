package practice09.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice05.task05.utils.SessionFactoryUtil;
import practice09.model.Course;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public Course findById(int id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public void save(Course course) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(course);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Course course) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(course);
        transaction.commit();
        session.close();
    }
}
