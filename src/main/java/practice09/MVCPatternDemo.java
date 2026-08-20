package practice09;

import practice09.controller.CourseController;
import practice09.model.Course;
import practice09.service.CourseService;
import practice09.service.CourseServiceImpl;
import practice09.view.CourseView;

public class MVCPatternDemo {
    private static CourseService courseService = new CourseServiceImpl();
    public static void main(String[] args) {
        Course course = retrieveCourseFromDatabase(); //create and save in the DB
        CourseView view = new CourseView();
        CourseController controller = new CourseController(course, view);
        controller.updateView();
        controller.setCourseName("Scala");
        courseService.updateCourse(course); //update in the DB
        System.out.println("After updating: ");
        controller.updateView();
    }

    private static Course retrieveCourseFromDatabase() {
        Course course = new Course("JS", "Programming");
        courseService.saveCourse(course);
        return course;
    }
}
