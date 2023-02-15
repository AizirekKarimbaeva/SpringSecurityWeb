package com.peakosft.impl;

import com.peakosft.entity.*;
import com.peakosft.repository.CourseRepository;
import com.peakosft.repository.TeacherRepository;
import com.peakosft.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }


    @Override
    public void addTeacher(Teacher teacher, Long courseId) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher, Long courseId) {
        Teacher teacher1 = teacherRepository.getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save( teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public List<Student> sizeOfStudents(Long id) {
        return teacherRepository.sizeOfStudents(id);
    }
}

