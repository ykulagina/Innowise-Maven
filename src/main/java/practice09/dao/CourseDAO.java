package practice09.dao;

import practice09.model.Course;

public interface CourseDAO {
    Course findById(int id);
    void save(Course course);
    void update(Course course);
}
