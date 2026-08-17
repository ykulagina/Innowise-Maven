package practice05.task05.service;

import practice05.task05.dao.BookDAOImpl;
import practice05.task05.model.Book;
import practice05.task05.dao.BookDAO;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    public BookServiceImpl() {}

    @Override
    public Book findBook(int id) {
        return this.bookDAO.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookDAO.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookDAO.save(book);
    }

    @Override
    public void updateBook(Book book) {
        this.bookDAO.update(book);
    }

    @Override
    public void deleteBook(Book book) {
        this.bookDAO.delete(book);
    }
}
