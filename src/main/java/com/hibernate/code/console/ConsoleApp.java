package com.hibernate.code.console;

import com.hibernate.code.entity.Student;
import com.hibernate.code.entity.Teacher;
import com.hibernate.code.service.ServiceGroupImpl;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        ServiceGroupImpl serviceGroup = new ServiceGroupImpl();

        Teacher teacher = serviceGroup.getTeacherById(1);
        List<Student> students = serviceGroup.getAllStudentByTeacherId(teacher.getId());

        Student student = serviceGroup.getStudentById(1);
        List<Teacher> teachers = serviceGroup.getAllTeacherByStudentId(student.getId());

        for (Student s : students) {
            System.out.println(s);
        }

        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }
}
