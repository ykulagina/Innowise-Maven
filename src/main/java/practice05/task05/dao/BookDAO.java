package practice05.task05.dao;

import practice05.task05.model.Book;

import java.util.List;

public interface BookDAO {
    Book findById(int id);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    void delete(Book book);
}
