package com.hibernate.code.hiberconf;

import com.hibernate.code.entity.Student;
import com.hibernate.code.entity.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory(){}

    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(sessionFactory)) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Teacher.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return sessionFactory;
    }

}
