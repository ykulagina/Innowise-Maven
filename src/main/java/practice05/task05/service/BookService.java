package practice05.task05.service;

import practice05.task05.model.Book;

import java.util.List;

public interface BookService {
    Book findBook(int id);
    List<Book> findAllBooks();
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
}
