package com.peakosft.impl;

import com.peakosft.entity.Company;
import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Teacher;
import com.peakosft.repository.CompanyRepository;
import com.peakosft.repository.CourseRepository;
import com.peakosft.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    @Override
    public void addCourse(Course course, Long companyId) {
      courseRepository.save(course);
    }
    @Override
    public void updateCourse(Long id, Course course,Long companyId) {
        Course course1 = courseRepository.getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        courseRepository.save(course1);
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteCourse(Course course) {
      courseRepository.delete(course);
    }

    @Override
    public List<Group> getGroupsByCourseId(Long id) {
        return null;
    }
    @Override
    public List<Teacher> getTeachersByCourseId(Long id) {
        return courseRepository.getTeachersByCourseId(id);
    }
}
