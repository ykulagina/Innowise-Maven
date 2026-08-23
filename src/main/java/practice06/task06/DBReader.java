package practice06.task06;

import practice06.task06.model.Discipline;
import practice06.task06.model.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private final String url = "jdbc:postgresql://localhost:5432/demo";
    private final String user = "postgres";
    private final String password = "root";

    public DBReader() {}

    public List<Discipline> getTeachersDisciplines(Teacher teacher, String query) {
        List<Discipline> disciplines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, (int) teacher.getId());
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    String discipline = rs.getString("name");
                    Discipline d = new Discipline(discipline);
                    disciplines.add(new Discipline(discipline));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }
}
