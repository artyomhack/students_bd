package com.hibernate.code.service;

import com.hibernate.code.entity.Student;
import com.hibernate.code.entity.Teacher;
import com.hibernate.code.hiberconf.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServiceGroupImpl implements ServiceGroup {

    @Override
    public Student getStudentById(int id) {
        Session session = Objects.requireNonNull(HibernateSessionFactory.getSessionFactory()).openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public Teacher getTeacherById(int id) {
        Session session = Objects.requireNonNull(HibernateSessionFactory.getSessionFactory()).openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, id);

        session.getTransaction().commit();
        session.close();

        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacherByStudentId(int id) {
        Session session = Objects.requireNonNull(HibernateSessionFactory.getSessionFactory()).openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, id);

        List<Teacher> teachers = student.getTeachers();

        session.getTransaction().commit();
        session.close();

        return teachers;
    }

    @Override
    public List<Student> getAllStudentByTeacherId(int id) {
        Session session = Objects.requireNonNull(HibernateSessionFactory.getSessionFactory()).openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, id);

        List<Student> students = teacher.getStudents();

        session.getTransaction().commit();
        session.close();

        return students;
    }

}
