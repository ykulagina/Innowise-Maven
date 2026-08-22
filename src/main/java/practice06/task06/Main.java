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

public class Main {

    public static void main(String[] args) {
        DisciplineService disciplineService = new DisciplineService();
        AuditoriumService auditoriumService = new AuditoriumService();
        LectureService lectureService = new LectureService();
        TeacherService teacherService = new TeacherService();
//        Discipline d1 = disciplineService.findDiscipline(1);
//        Auditorium a1 = auditoriumService.findAuditorium(1);

        Lecture l1 = lectureService.findLecture(1);
        Teacher t1 = new Teacher("T2");
        t1.addLecture(l1);
        teacherService.saveTeacher(t1);
        System.out.println(teacherService.findTeacher(t1.getId()));
    }
}
