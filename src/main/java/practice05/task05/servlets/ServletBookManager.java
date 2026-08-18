package practice05.task05.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice05.task05.model.Book;
import practice05.task05.service.BookService;
import practice05.task05.service.BookServiceImpl;

import java.io.IOException;

/**
 * Class's purpose is to find or update a book's info, found by its ID.
 * Search is performed against a [books] table in the DB.
 */
@WebServlet("/servlet-book-manager")
public class ServletBookManager extends HttpServlet {
    private BookService bookService = new BookServiceImpl();
    public ServletBookManager() {}

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = null;
        if (isInteger(request.getParameter("bookId"))) {
            int id = Integer.parseInt(request.getParameter("bookId"));
            book = bookService.findBook(id);
        }
        if (book != null) {
            request.setAttribute("book", book);
        } else {
            request.setAttribute("result", "Not found.");
        }
        request.getRequestDispatcher("servletBookManagerResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getParameter("bookId").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("bookId"));
            String name = request.getParameter("bookName");
            String author = request.getParameter("bookAuthor");
            int year = Integer.parseInt(request.getParameter("bookYear"));
            Book updatedBook = bookService.findBook(id);
            updatedBook.setName(name);
            updatedBook.setAuthor(author);
            updatedBook.setYear(year);
            bookService.updateBook(updatedBook);
            request.setAttribute("bookId", updatedBook.getId());
            request.setAttribute("bookName", updatedBook.getName());
            request.setAttribute("bookAuthor", updatedBook.getAuthor());
            request.setAttribute("bookYear", updatedBook.getYear());
            request.getRequestDispatcher("servletBookManagerUpdated.jsp").forward(request, response);
        }
    }

    public void destroy() {
        super.destroy();
    }

    //helper method
    private boolean isInteger(String line) {
        if (line == null || line.isEmpty()) return false;
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
