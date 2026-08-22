package practice06.task06.service;

import practice06.task06.dao.LectureDAO;
import practice06.task06.dao.LectureDAOImpl;
import practice06.task06.model.Lecture;

public class LectureService {
    private LectureDAO lectureDAO = new LectureDAOImpl();

    public LectureService() {}

    public Lecture findLecture(long id) {
        return this.lectureDAO.findById(id);
    }

    public void saveLecture(Lecture lecture) {
        this.lectureDAO.save(lecture);
    }

    public void updateLecture(Lecture lecture) {
        this.lectureDAO.update(lecture);
    }

    public void deleteLecture(Lecture lecture) {
        this.lectureDAO.delete(lecture);
    }
}
