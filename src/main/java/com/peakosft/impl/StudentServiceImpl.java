package com.peakosft.impl;

import com.peakosft.entity.Company;
import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import com.peakosft.repository.GroupRepository;
import com.peakosft.repository.StudentRepository;
import com.peakosft.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public void addStudent(Student student, Long groupId) {
        studentRepository.save(student);
    }
    @Override
    public void updateStudent(Long id, Student student,Long groupId) {
        Student student1 = studentRepository.getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setEmail(student.getEmail());
        student1.setLastName(student.getLastName());
        student1.setStudyFormat(student.getStudyFormat());
        studentRepository.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(Student student) {
     studentRepository.delete(student);
    }

    @Override
    public List<Group> getGroupById(Long id) {
        return studentRepository.getGroupById(id);
    }
}
