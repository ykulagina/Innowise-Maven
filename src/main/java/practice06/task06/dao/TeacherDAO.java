package practice06.task06.dao;

import practice06.task06.model.Teacher;

public interface TeacherDAO {
    Teacher findById(long id);
    void save(Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
}
