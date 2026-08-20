package practice09.service;

import practice09.model.Course;

public interface CourseService {
    Course findCourse(int id);
    void saveCourse(Course course);
    void updateCourse(Course course);
}
