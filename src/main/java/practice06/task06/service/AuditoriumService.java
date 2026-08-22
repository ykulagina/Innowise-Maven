package practice06.task06.service;

import practice06.task06.dao.AuditoriumDAO;
import practice06.task06.dao.AuditoriumDAOImpl;
import practice06.task06.model.Auditorium;

public class AuditoriumService {
    private AuditoriumDAO auditoriumDAO = new AuditoriumDAOImpl();

    public AuditoriumService() {}

    public Auditorium findAuditorium(long id) {
        return this.auditoriumDAO.findById(id);
    }

    public void saveAuditorium(Auditorium auditorium) {
        this.auditoriumDAO.save(auditorium);
    }

    public void deleteAuditorium(Auditorium auditorium) {
        this.auditoriumDAO.delete(auditorium);
    }
}
