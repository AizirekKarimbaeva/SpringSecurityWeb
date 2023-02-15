package com.peakosft.controller;

import com.peakosft.entity.Course;
import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import com.peakosft.service.CourseService;
import com.peakosft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;


    @GetMapping
    public String groups(Model model) {
        model.addAttribute("groups", groupService.getAllGroup());
        return "groups/groups";
    }

    @GetMapping("/addGroup")
    public String add(Model model) {
        model.addAttribute("group", new Group());
        model.addAttribute("courses", courseService.getAllCourse());
        return "groups/addGroup";
    }

    @PostMapping("/saveGroup")
    public String save(@ModelAttribute("group") Group group) {
        groupService.addGroup(group, group.getCourseId());
        return "redirect:/groups";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getById(id);
        model.addAttribute("group", group);
        model.addAttribute("course", courseService.getAllCourse());
        return "groups/updateGroup";
    }

    @PatchMapping("/{id}")
    public String updateGroup(@PathVariable("id") Long id, @ModelAttribute("group") Group group) {
        groupService.updateGroup(id, group,group.getCourseId());
        return "redirect:/groups";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Group group = groupService.getById(id);
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id") Long id, Model model) {
        List<Course> courses = groupService.getCoursesByGroupId(id);
        model.addAttribute("courses", courses);
        return "groups/courses";
    }

    @GetMapping("/students/{id}")
    public String students(@PathVariable("id") Long id, Model model) {
        List<Student> students = groupService.getStudentsByGroupId(id);
        model.addAttribute("students", students);
        return "groups/students";
    }
    @GetMapping("/search/{id}")public String search(@PathVariable("id") Long id, Model model,@RequestParam("name")String name){
        List<Student>students = groupService.search(id,name);   model.addAttribute("students",students);
        return "group/search";
    }
}

