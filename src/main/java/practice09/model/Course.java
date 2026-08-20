package practice09.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_seq")
    @SequenceGenerator(name = "courses_seq", sequenceName = "courses_seq", allocationSize = 1)
    private int id;
    @Column(name = "name")
    private String courseName;
    @Column(name = "category")
    private String courseCategory;

    public Course() {}

    public Course(String courseName, String courseCategory) {
        this.courseName = courseName;
        this.courseCategory = courseCategory;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return id;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    @Override
    public String toString() {
        return "Course Details: {name: " + this.courseName + ", category: " + this.courseCategory + "}.";
    }
}
