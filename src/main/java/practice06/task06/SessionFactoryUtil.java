package practice06.task06;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import practice06.task06.model.Auditorium;
import practice06.task06.model.Discipline;
import practice06.task06.model.Teacher;
import practice06.task06.model.Lecture;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private SessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Auditorium.class);
                configuration.addAnnotatedClass(Discipline.class);
                configuration.addAnnotatedClass(Lecture.class);
                configuration.addAnnotatedClass(Teacher.class);

                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception:" + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
