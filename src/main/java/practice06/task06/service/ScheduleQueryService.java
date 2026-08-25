package practice06.task06.service;

import practice06.task06.model.DayOfWeek;
import practice06.task06.model.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleQueryService {
    private final String url = "jdbc:postgresql://localhost:5432/demo";
    private final String user = "postgres";
    private final String password = "root";
    private AuditoriumService auditoriumService = new AuditoriumService();
    private TeacherService teacherService = new TeacherService();
    private DisciplineService disciplineService = new DisciplineService();

    public ScheduleQueryService() {}

    public List<DayOfWeek> getDaysWithSetupNumberOfLectures(int lectures) {
        List<DayOfWeek> days = new ArrayList<>();
        String q1 = "SELECT week_day, COUNT(discipline_id) FROM lectures GROUP BY week_day HAVING COUNT(discipline_id) = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setInt(1, lectures);
            try (ResultSet rs = p1.executeQuery()) {
                while(rs.next()) {
                    String day = rs.getString("week_day");
                    days.add(DayOfWeek.valueOf(day));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return days;
    }

    public List<DayOfWeek> getDaysWithOccupiedAuditoria(int auditoria) {
        List<DayOfWeek> days = new ArrayList<>();
        String q1 = "SELECT week_day, COUNT(auditorium_id) FROM lectures GROUP BY week_day HAVING COUNT(auditorium_id) = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setInt(1, auditoria);
            try (ResultSet rs = p1.executeQuery()) {
                while(rs.next()) {
                    String day = rs.getString("week_day");
                    days.add(DayOfWeek.valueOf(day));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return days;
    }
}
