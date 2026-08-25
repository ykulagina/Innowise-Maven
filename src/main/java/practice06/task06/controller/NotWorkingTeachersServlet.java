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

@WebServlet("/not-working-teachers")
public class NotWorkingTeachersServlet extends HttpServlet {
    private TeacherQueryService teacherQueryService = new TeacherQueryService();

    public NotWorkingTeachersServlet() {}

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers;
        String dayOfWeek = request.getParameter("day2").trim().toUpperCase();
        if (!dayOfWeek.isEmpty()) {
            teachers = teacherQueryService.getTeachersNotWorking(dayOfWeek);
            if (!teachers.isEmpty()) {
                request.setAttribute("not_working_teachers", teachers);
                request.setAttribute("day", dayOfWeek);
            } else {
                request.setAttribute("result", "Not found.");
            }
        } else {
            request.setAttribute("result", "Search criteria must be entered.");
        }
        request.getRequestDispatcher("notWorkingTeachersResult.jsp").forward(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}
