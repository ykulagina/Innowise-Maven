package practice06.task06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice06.task06.model.DayOfWeek;
import practice06.task06.service.ScheduleQueryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/days-auditoria")
public class DaysAuditoriaServlet extends HttpServlet {
    private ScheduleQueryService scheduleQuery = new ScheduleQueryService();

    public DaysAuditoriaServlet() {}

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DayOfWeek> days;
        int numberOfAuditoria = Integer.parseInt(request.getParameter("auditoria"));
        if (numberOfAuditoria > 0) {
            days = scheduleQuery.getDaysWithOccupiedAuditoria(numberOfAuditoria);
            if (!days.isEmpty()) {
                request.setAttribute("days", days);
                request.setAttribute("numberOfAuditoria", numberOfAuditoria);
            } else {
                request.setAttribute("result", "Not found.");
            }
        } else {
            request.setAttribute("result", "Search criteria must be entered.");
        }
        request.getRequestDispatcher("daysAuditoriaResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
