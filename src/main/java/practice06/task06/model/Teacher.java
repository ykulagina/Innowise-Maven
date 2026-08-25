package practice06.task06.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Lecture> lectures = new ArrayList<>();

    @ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "teachers_disciplines",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines = new ArrayList<>();

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
        lecture.setTeacher(this);
    }

    public void deleteLecture(Lecture lecture) {
        this.lectures.remove(lecture);
        lecture.setTeacher(null);
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void addDiscipline(Discipline discipline) {
        this.disciplines.add(discipline);
        discipline.getTeachers().add(this);
    }

    public void deleteDiscipline(Discipline discipline) {
        this.disciplines.remove(discipline);
        discipline.getTeachers().remove(this);
    }

    @Override
    public String toString() {
        return "Teacher: " + this.id + "/" + this.name + ", Disciplines: " + this.disciplines;
    }
}
