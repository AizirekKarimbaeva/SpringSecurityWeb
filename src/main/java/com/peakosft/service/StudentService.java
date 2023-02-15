package com.peakosft.service;

import com.peakosft.entity.Group;
import com.peakosft.entity.Student;


import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void addStudent(Student student, Long groupId);
    void updateStudent(Long id, Student student,Long groupId);
    Student getById(Long id);
    void deleteStudent(Student student);
    List<Group> getGroupById(Long id);

}
