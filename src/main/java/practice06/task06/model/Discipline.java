package practice06.task06.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "disciplines", fetch = FetchType.EAGER)
    List<Teacher> teachers = new ArrayList<>();

    public Discipline(String name) {
        this.name = name;
    }

    public Discipline() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

//    public void addTeacher(Teacher teacher) {
//        this.teachers.add(teacher);
//        teacher.addDiscipline(this);
//    }
//
//    public void deleteTeacher(Teacher teacher) {
//        this.teachers.remove(teacher);
//        teacher.deleteDiscipline(this);
//    }

    @Override
    public String toString() {
        return "Discipline {id: " + this.id + ", name: " + this.name + "}";
    }
}
