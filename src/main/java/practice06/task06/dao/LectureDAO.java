package practice06.task06.dao;

import practice06.task06.model.Lecture;

public interface LectureDAO {
    Lecture findById(long id);
    void save(Lecture lecture);
    void update(Lecture lecture);
    void delete(Lecture lecture);
}
