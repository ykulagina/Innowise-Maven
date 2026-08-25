package practice06.task06.dao;

import practice06.task06.model.Discipline;

import java.util.List;

public interface DisciplineDAO {
    Discipline findById(long id);
    List<Discipline> findAll();
    void save(Discipline discipline);
    void delete(Discipline discipline);
}
