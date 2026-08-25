package practice06.task06.dao;

import practice06.task06.model.Auditorium;

import java.util.List;

public interface AuditoriumDAO {
    Auditorium findById(long id);
    List<Auditorium> findAll();
    void save(Auditorium auditorium);
    void delete(Auditorium auditorium);
}
