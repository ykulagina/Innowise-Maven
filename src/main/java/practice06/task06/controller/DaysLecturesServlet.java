package practice06.task06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice06.task06.model.DayOfWeek;
import practice06.task06.service.ScheduleQueryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/days-lectures")
public class DaysLecturesServlet extends HttpServlet {
    private ScheduleQueryService scheduleQuery = new ScheduleQueryService();

    public DaysLecturesServlet() {}

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DayOfWeek> days = new ArrayList<>();
        int numberOfLectures = Integer.parseInt(request.getParameter("lectures"));
        if (numberOfLectures > 0) {
            days = scheduleQuery.getDaysWithSetupNumberOfLectures(numberOfLectures);
            if (!days.isEmpty()) {
                request.setAttribute("days", days);
                request.setAttribute("number", numberOfLectures);
            } else {
                request.setAttribute("result", "Not found.");
            }
        } else {
            request.setAttribute("result", "Search criteria must be entered.");
        }
        request.getRequestDispatcher("daysLecturesResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
