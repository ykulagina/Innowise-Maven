package practice05.task05;

import practice05.task05.model.Book;
import practice05.task05.service.BookService;
import practice05.task05.service.BookServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String searchFor = "dog";
        List<String> list = FileParser.parseFile("src/main/webapp/WEB-INF/sample.txt", searchFor);
        String result = (list.isEmpty()) ? "Not found." : "Number of times encountered: ";
        System.out.println("Word {" + searchFor + "}. " + result);
        System.out.println(list.size());
//        BookService bookService = new BookServiceImpl();
//        Book book = new Book("Catcher in the Rye", "J. D. Salinger", 1951);
//        bookService.saveBook(book);
//        System.out.println(bookService.findBook(book.getId()));
    }
}
