package com.peakosft.service;

import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Student;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();
    void addGroup(Group group,Long courseId);
    void updateGroup(Long id, Group group,Long courseId);
    Group getById(Long id);
    void deleteGroup(Group group);
    List<Student>getStudentsByGroupId(Long id);
    List<Student> search(Long groupId,String studentName);
    List<Course>getCoursesByGroupId(Long id);
}
