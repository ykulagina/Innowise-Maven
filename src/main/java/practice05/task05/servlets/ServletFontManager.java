package practice05.task05.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class's purpose is to display several lines from a text file.
 * Number of lines to display and text font size is set up by a user on the client's page.
 */
@WebServlet("/servlet-font-manager")
public class ServletFontManager extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isInteger(request.getParameter("fontSize")) && isInteger(request.getParameter("numberOfLines"))) {
            int fontSize = Integer.parseInt(request.getParameter("fontSize"));
            int numberOfLines = Integer.parseInt(request.getParameter("numberOfLines"));
            List<String> list = new ArrayList<>();
            try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                list = reader.lines().toList();
                if (numberOfLines <= list.size()) {
                    list = list.subList(0, numberOfLines);
                }
            } catch (IOException e) {
                System.out.println("File not found. " + e.getMessage());
            }
            request.setAttribute("numberOfLines", numberOfLines);
            request.setAttribute("textToDisplay", list);
            request.setAttribute("textFontSize", fontSize);
            request.getRequestDispatcher("servletFontManagerResult.jsp").forward(request, response);
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
