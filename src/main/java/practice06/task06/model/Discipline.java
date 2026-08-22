package practice06.task06.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    private DayOfWeek day;
//    private List<Auditorium> auditoria;

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
//
//    public DayOfWeek getDay() {
//        return day;
//    }
//
//    public void setDay(DayOfWeek day) {
//        this.day = day;
//    }
//
//    public List<Auditorium> getAuditoria() {
//        return auditoria;
//    }
//
//    public void setAuditoria(List<Auditorium> auditoria) {
//        this.auditoria = auditoria;
//    }
//
//    public void addAuditorium(Auditorium auditorium) {
//        this.auditoria.add(auditorium);
//    }
//
//    public void deleteAuditorium(Auditorium auditorium) {
//        this.auditoria.remove(auditorium);
//    }

    @Override
    public String toString() {
        return "Discipline {id: " + this.id + ", name: " + this.name + "}";
    }
}
