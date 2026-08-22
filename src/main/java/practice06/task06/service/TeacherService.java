package practice06.task06.service;

import practice06.task06.dao.TeacherDAO;
import practice06.task06.dao.TeacherDAOImlp;
import practice06.task06.model.Teacher;

public class TeacherService {
    private TeacherDAO teacherDAO = new TeacherDAOImlp();

    public TeacherService() {}

    public Teacher findTeacher(long id) {
        return this.teacherDAO.findById(id);
    }

    public void saveTeacher(Teacher teacher) {
        this.teacherDAO.save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        this.teacherDAO.update(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        this.teacherDAO.delete(teacher);
    }
}
