package practice06.task06.service;

import practice06.task06.model.Auditorium;
import practice06.task06.model.Discipline;
import practice06.task06.model.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherQueryService {
    private final String url = "jdbc:postgresql://localhost:5432/demo";
    private final String user = "postgres";
    private final String password = "root";
    private AuditoriumService auditoriumService = new AuditoriumService();
    private TeacherService teacherService = new TeacherService();
    private DisciplineService disciplineService = new DisciplineService();

    public TeacherQueryService() {}

    public List<Teacher> getTeachersWorking(String day, String auditorium) {
        List<Teacher> teachers = new ArrayList<>();
        String q1 = "SELECT teacher_id FROM lectures WHERE lectures.auditorium_id = ? AND lectures.week_day = ?";
        List<Auditorium> auditoria = auditoriumService.findAllAuditoria(); // here Driver is registered already via session (from hybernate.cfg.xml)
        long auditoriumId = 0;
        for (Auditorium a : auditoria) {
            if (Objects.equals(a.getName(), auditorium)) {
                auditoriumId = a.getId();
            }
        }
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setLong(1, auditoriumId);
            p1.setObject(2, DayOfWeek.valueOf(day), Types.OTHER);
            try (ResultSet rs = p1.executeQuery()) {
                while(rs.next()) {
                    long teacherId = rs.getLong("teacher_id");
                    Teacher t = teacherService.findTeacher(teacherId);
                    teachers.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public List<Teacher> getTeachersNotWorking(String day) {
        List<Teacher> teachers = new ArrayList<>();
        String q1 = "SELECT id FROM teachers WHERE id NOT IN (SELECT teachers.id FROM teachers " +
                "JOIN lectures on teachers.id = lectures.teacher_id WHERE lectures.week_day = ?)";
        try {
            Class.forName("org.postgresql.Driver"); //since there is no Session object
            // (which loads Driver from hybernate.cfg.xml), you should load the Driver explicitly
            // in order to register Driver for Tomcat
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't load the Driver.");
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setObject(1, DayOfWeek.valueOf(day), Types.OTHER);
            try (ResultSet rs = p1.executeQuery()) {
                while(rs.next()) {
                    long teacherId = rs.getLong("id");
                    Teacher t = teacherService.findTeacher(teacherId);
                    teachers.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public int getNumberOfLecturesPerDiscipline(String teacher, String discipline) {
        int number = 0;
        long teacherId = 0;
        long disciplineId = 0;
        List<Teacher> teachers = teacherService.findAllTeachers();
        for (Teacher t : teachers) {
            if (Objects.equals(t.getName(), teacher)) {
                teacherId = t.getId();
            }
        }
        List<Discipline> disciplines = disciplineService.findAllDisciplines();
        for (Discipline d : disciplines) {
            if (Objects.equals(d.getName(), discipline)) {
                disciplineId = d.getId();
            }
        }
        String q1 = "SELECT disciplines.name, COUNT(lectures.discipline_id) FROM disciplines " +
                "JOIN lectures ON disciplines.id = lectures.discipline_id " +
                "WHERE lectures.teacher_id = ? AND lectures.discipline_id = ? GROUP BY disciplines.name";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setLong(1, teacherId);
            p1.setLong(2, disciplineId);
            try (ResultSet rs = p1.executeQuery()) {
                if (rs.next()) {
                    number = rs.getInt(2);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    public List<Integer> getNumberOfStudentsPerDiscipline(String teacher, String discipline) {
        List<Integer> students = new ArrayList<>();
        long teacherId = 0;
        long disciplineId = 0;
        List<Teacher> teachers = teacherService.findAllTeachers();
        for (Teacher t : teachers) {
            if (Objects.equals(t.getName(), teacher)) {
                teacherId = t.getId();
            }
        }
        List<Discipline> disciplines = disciplineService.findAllDisciplines();
        for (Discipline d : disciplines) {
            if (Objects.equals(d.getName(), discipline)) {
                disciplineId = d.getId();
            }
        }
        String q1 = "SELECT students_number FROM lectures WHERE teacher_id = ? AND discipline_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement p1 = connection.prepareStatement(q1)) {
            p1.setLong(1, teacherId);
            p1.setLong(2, disciplineId);
            try (ResultSet rs = p1.executeQuery()) {
                while (rs.next()) {
                    Integer number = rs.getInt(1);
                    students.add(number);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
