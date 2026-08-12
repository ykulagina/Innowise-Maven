package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet("/servlet-two")
public class ServletTwo extends HttpServlet {
    public ServletTwo() {
        super();
    }

    public void init() throws ServletException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float)(gc.getTimeInMillis()-Long.parseLong(timeJsp)))/1_000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("servletTwoResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
