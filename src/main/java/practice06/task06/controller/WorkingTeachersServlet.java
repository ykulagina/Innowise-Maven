package practice06.task06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice06.task06.model.Teacher;
import practice06.task06.service.TeacherQueryService;

import java.io.IOException;
import java.util.List;

@WebServlet("/working-teachers")
public class WorkingTeachersServlet extends HttpServlet {
    private TeacherQueryService teacherQueryService = new TeacherQueryService();

    public WorkingTeachersServlet() {}

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers;
        String dayOfWeek = request.getParameter("day").trim().toUpperCase();
        String auditorium = request.getParameter("room").trim();
        if (!dayOfWeek.isEmpty() && !auditorium.isEmpty()) {
            teachers = teacherQueryService.getTeachersWorking(dayOfWeek, auditorium);
            if (!teachers.isEmpty()) {
                request.setAttribute("teachers", teachers);
                request.setAttribute("day", dayOfWeek);
            } else {
                request.setAttribute("result", "Not found.");
            }
        } else {
            request.setAttribute("result", "Search criteria must be entered.");
        }
        request.getRequestDispatcher("workingTeachersResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
