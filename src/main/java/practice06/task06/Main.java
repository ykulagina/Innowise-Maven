package practice06.task06;

import practice06.task06.model.DayOfWeek;
import practice06.task06.model.Lecture;
import practice06.task06.model.Teacher;
import practice06.task06.service.AuditoriumService;
import practice06.task06.service.ScheduleQueryService;
import practice06.task06.service.TeacherQueryService;
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

        TeacherQueryService teacherQuery = new TeacherQueryService();
        ScheduleQueryService scheduleQuery = new ScheduleQueryService();
//        List<Teacher> teachers = teacherQuery.getTeachersWorking("SATURDAY", "203");
//        List<Teacher> teachers2 = teacherQuery.getTeachersNotWorking("MONDAY");
//        for (Teacher t : teachers2) {
//            System.out.println(t);
//        }
//        int number = teacherQuery.getNumberOfLecturesPerDiscipline("Pan Kasciushka", "Scala");
//        System.out.println(number);
//        List<Integer> students = teacherQuery.getNumberOfStudentsPerDiscipline("Pan Kasciushka", "Scala");
//        System.out.println(students);
        List<DayOfWeek> days = scheduleQuery.getDaysWithSetupNumberOfLectures(2);
        System.out.println(days);
//        List<DayOfWeek> days2 = scheduleQuery.getDaysWithOccupiedAuditoria(1);
//        System.out.println(days2);

//        Teacher t = teacherService.findTeacher(4);
//        System.out.println(t.getLectures());
    }
}
