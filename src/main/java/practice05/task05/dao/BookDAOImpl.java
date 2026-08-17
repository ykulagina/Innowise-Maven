package practice05.task05.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice05.task05.model.Book;
import practice05.task05.utils.SessionFactoryUtil;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Book findById(int id) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public List<Book> findAll() {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("From Book").list();
        session.close();
        return books;
    }

    @Override
    public void save(Book book) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(book);
        transaction.commit();
        session.close();
    }
}
