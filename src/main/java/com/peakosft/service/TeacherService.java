package com.peakosft.service;

import com.peakosft.entity.Student;
import com.peakosft.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void addTeacher(Teacher teacher,Long courseId);
    void updateTeacher(Long id, Teacher teacher,Long courseId);
    Teacher getById(Long id);
    void deleteTeacher(Teacher teacher);
    List<Student>sizeOfStudents(Long id);

}
