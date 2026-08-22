package practice06.task06.service;

import practice06.task06.dao.DisciplineDAO;
import practice06.task06.dao.DisciplineDAOImpl;
import practice06.task06.model.Discipline;

public class DisciplineService {
    private DisciplineDAO disciplineDAO = new DisciplineDAOImpl();

    public DisciplineService() {}

    public Discipline findDiscipline(long id) {
        return this.disciplineDAO.findById(id);
    }

    public void saveDiscipline(Discipline discipline) {
        this.disciplineDAO.save(discipline);
    }

    public void deleteDiscipline(Discipline discipline) {
        this.disciplineDAO.delete(discipline);
    }
}
