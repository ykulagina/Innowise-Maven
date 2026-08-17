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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class's purpose is to find a word, provided by a user on the client side.
 * Search is performed against a text from a .txt file, located inside the project.
 * If applicable, word's frequency in the text will be displayed as well.
 */
@WebServlet("/servlet-find-word")
public class ServletFindWord extends HttpServlet {
    public ServletFindWord() {}

    public void init() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> wordsFromFile = new ArrayList<>();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            if (input == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
                return;
            }
            System.out.println("Parsing file...");
            String line;
            while ((line = reader.readLine()) != null) {
                wordsFromFile.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (Exception e) {
            System.out.println("File not found. " + e.getMessage());
        }

        String searchFor = (request.getParameter("searchWord")).trim();
        Pattern pattern = Pattern.compile(searchFor);
        List<String> results = wordsFromFile.stream().filter(pattern.asPredicate()).toList();
        String result = (results.isEmpty()) ? "'" + searchFor + "' not found." : "'" + searchFor + "' is found!";
        int numberOfTimesEncountered = results.size();

        request.setAttribute("resultResponse", result);
        request.setAttribute("numberOfTimes", numberOfTimesEncountered);
        request.getRequestDispatcher("servletFindWordResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
