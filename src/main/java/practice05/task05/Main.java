package practice05.task05;

import practice05.task05.model.Book;
import practice05.task05.service.BookService;
import practice05.task05.service.BookServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws SQLException {
//        List<String> list = FileParser.parseFile("src/main/webapp/WEB-INF/sample.txt");
//        String searchFor = "dog";
//        Pattern pattern = Pattern.compile(searchFor);
//        List<String> results = list.stream().filter(pattern.asPredicate()).toList();
//        String result = (results.isEmpty()) ? "Not found." : "Number of times encountered: ";
//        System.out.print("Word {" + searchFor + "}. " + result);
//        System.out.println(results.size());
        BookService bookService = new BookServiceImpl();
        Book book = new Book("Catcher in the Rye", "J. D. Salinger", 1951);
        bookService.saveBook(book);
        System.out.println(bookService.findBook(book.getId()));
    }
}
