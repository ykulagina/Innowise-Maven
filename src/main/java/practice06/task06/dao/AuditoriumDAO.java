package practice06.task06.dao;

import practice06.task06.model.Auditorium;

public interface AuditoriumDAO {
    Auditorium findById(long id);
    void save(Auditorium auditorium);
    void delete(Auditorium auditorium);
}
