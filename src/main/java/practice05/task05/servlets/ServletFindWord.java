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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> wordsFromFile = new ArrayList<>();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/sample.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String searchFor = (request.getParameter("searchWord")).trim();
            if (!searchFor.isEmpty()) {
                Pattern pattern = Pattern.compile(Pattern.quote(searchFor));
                reader.lines()
                        .map(e -> Arrays.stream(e.split("[\\s.,]+"))
                                .filter(pattern.asMatchPredicate())
                                .toList())
                        .forEach(wordsFromFile::addAll);
                String result = (wordsFromFile.isEmpty()) ? "'" + searchFor + "' not found." : "'" + searchFor + "' is found!";
                int numberOfTimesEncountered = wordsFromFile.size();

                request.setAttribute("resultResponse", result);
                request.setAttribute("numberOfTimes", numberOfTimesEncountered);
            } else {
                request.setAttribute("resultResponse", "Search criteria must be entered.");
            }
        } catch (Exception e) {
            System.out.println("File not found. " + e.getMessage());
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
        }
        request.getRequestDispatcher("servletFindWordResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void destroy() {
        super.destroy();
    }
}
