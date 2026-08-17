package practice05.task05.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import practice05.task05.model.Book;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private SessionFactoryUtil() {}

//    static {
//        try {
//            Configuration config = new Configuration().configure();
//            config.addAnnotatedClass(Book.class);
//            sessionFactory = config.buildSessionFactory();
//        } catch (Throwable ex) {
//            // This guarantees you see the initialization error in your logs
//            System.err.println("Initial SessionFactory creation failed. " + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Book.class);

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
