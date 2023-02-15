package com.peakosft.service;

import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    void addCourse(Course course,Long companyId);
    void updateCourse(Long id, Course course,Long companyId);
    Course getById(Long id);
    void deleteCourse(Course course);
    List<Group>getGroupsByCourseId(Long id);
    List<Teacher>getTeachersByCourseId(Long id);

}

