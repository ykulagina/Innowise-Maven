package practice06.task06.dao;

import practice06.task06.model.Teacher;

import java.util.List;

public interface TeacherDAO {
    Teacher findById(long id);
    List<Teacher> findAll();
    void save(Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
}
