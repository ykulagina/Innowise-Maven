package practice06.task06;

import practice06.task06.model.Auditorium;
import practice06.task06.model.DayOfWeek;
import practice06.task06.model.Discipline;
import practice06.task06.model.Lecture;
import practice06.task06.model.Teacher;
import practice06.task06.service.AuditoriumService;
import practice06.task06.service.DisciplineService;
import practice06.task06.service.LectureService;
import practice06.task06.service.TeacherService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DisciplineService disciplineService = new DisciplineService();
        AuditoriumService auditoriumService = new AuditoriumService();
        LectureService lectureService = new LectureService();
        TeacherService teacherService = new TeacherService();

//        DBReader db = new DBReader();
//        String query = "SELECT disciplines.name " +
//                "FROM disciplines JOIN lectures on disciplines.id = lectures.discipline_id " +
//                "WHERE lectures.teacher_id = ?";
//        Teacher t = teacherService.findTeacher(5);
//        List<Discipline> disciplines = db.getTeachersDisciplines(t, query);
//        System.out.println(disciplines);

        Teacher t = teacherService.findTeacher(4);
        t.addDiscipline(disciplineService.findDiscipline(2));
        teacherService.updateTeacher(t);
        System.out.println(teacherService.findTeacher(4));
    }
}
