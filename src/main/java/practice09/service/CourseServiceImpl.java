package practice09.service;

import practice09.dao.CourseDAO;
import practice09.dao.CourseDAOImpl;
import practice09.model.Course;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = new CourseDAOImpl();

    public CourseServiceImpl() {}

    @Override
    public Course findCourse(int id) {
        return this.courseDAO.findById(id);
    }

    @Override
    public void saveCourse(Course course) {
        this.courseDAO.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        this.courseDAO.update(course);
    }
}
