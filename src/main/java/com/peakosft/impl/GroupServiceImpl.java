package com.peakosft.impl;

import com.peakosft.entity.Company;
import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import com.peakosft.repository.CourseRepository;
import com.peakosft.repository.GroupRepository;
import com.peakosft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }
    @Override
    public void addGroup(Group group,Long courseId) {
        groupRepository.save(group);
    }
    @Override
    public void updateGroup(Long id, Group group,Long courseId) {
        Group group1 = groupRepository.getById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group1.getDateOfFinish());
        groupRepository.save(group1);
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void deleteGroup(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public List<Course> getCoursesByGroupId(Long id) {
        return groupRepository.getCoursesByGroupId(id);
    }
    @Override
    public List<Student> getStudentsByGroupId(Long id) {
        return groupRepository.getStudentsByGroupId(id);
    }

    @Override
    public List<Student> search(Long groupId, String studentName) {
        return groupRepository.search(groupId,studentName);
    }
}
