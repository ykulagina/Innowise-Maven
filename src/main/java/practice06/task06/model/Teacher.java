package practice06.task06.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.MERGE)
    private List<Lecture> lectures = new ArrayList<>();
//    private List<Discipline> disciplines;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void deleteLecture(Lecture lecture) {
        this.lectures.remove(lecture);
    }

    @Override
    public String toString() {
        return "Teacher {id: " + this.id + ", name: " + this.name + "}";
    }
}
