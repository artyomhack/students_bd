package com.hibernate.code.service;

import com.hibernate.code.entity.Student;
import com.hibernate.code.entity.Teacher;

import java.util.List;

public interface ServiceGroup {

    Student getStudentById(int id);

    Teacher getTeacherById(int id);

    List<Teacher> getAllTeacherByStudentId(int id);

    List<Student> getAllStudentByTeacherId(int id);
}
