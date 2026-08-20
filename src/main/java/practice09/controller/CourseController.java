package practice09.controller;

import practice09.service.CourseService;
import practice09.view.CourseView;
import practice09.model.Course;

public class CourseController {
    private Course model;
    private CourseView view;

    public CourseController(Course model, CourseView view) {
        this.model = model;
        this.view = view;
    }

    public String getCourseName() {
        return this.model.getCourseName();
    }

    public void setCourseName(String name) {
        this.model.setCourseName(name);
    }

    public int getCourseId() {
        return this.model.getCourseId();
    }

    public String getCourseCategory() {
        return this.model.getCourseCategory();
    }

    public void setCourseCategory(String category) {
        this.model.setCourseCategory(category);
    }

    public void updateView() {
        this.view.printCourseView(model.getCourseName(), model.getCourseId(), model.getCourseCategory());
    }

//    private CourseService courseService;
//    private CourseView view;
//
//    public CourseController(CourseService courseService, CourseView view) {
//        this.courseService = courseService;
//        this.view = view;
//    }
//
//    public String getCourseName(int id) {
//        return this.courseService.findCourse(id).getCourseName();
//    }
//
//    public void setCourseName(int id, String name) {
//        this.courseService.findCourse(id).setCourseName(name);
//    }
//
//    public int getCourseId(int id) {
//        return this.courseService.findCourse(id).getCourseId();
//    }
//
//    public String getCourseCategory(int id) {
//        return this.courseService.findCourse(id).getCourseCategory();
//    }
//
//    public void setCourseCategory(int id, String category) {
//        this.courseService.findCourse(id).setCourseCategory(category);
//    }
}
