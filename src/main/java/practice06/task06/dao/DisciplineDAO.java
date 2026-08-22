package practice06.task06.dao;

import practice06.task06.model.Discipline;

public interface DisciplineDAO {
    Discipline findById(long id);
    void save(Discipline discipline);
    void delete(Discipline discipline);
}
