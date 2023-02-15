package com.peakosft.controller;

import com.peakosft.entity.Group;
import com.peakosft.entity.Student;
import com.peakosft.service.GroupService;
import com.peakosft.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;
    private final GroupService groupService;

    @GetMapping
    public  String students(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "student/students";
    }
    @GetMapping("/addStudent")
    public String add(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("groups",groupService.getAllGroup());
        return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String save(@ModelAttribute("student")Student student){
        studentService.addStudent(student,student.getGroupId());
        return "redirect:/students";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        model.addAttribute("groups",groupService.getAllGroup());
        return "student/updateStudent";
    }
    @PatchMapping("/{id}")
    public String updateStudent(@PathVariable("id")Long id,@ModelAttribute("student")Student student){
        studentService.updateStudent(id,student,student.getGroupId());
        return "redirect:/students";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        Student student = studentService.getById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/groups/{id}")
    public String getGroup(@PathVariable("id")Long id, Model model){
        List<Group> groups = studentService.getGroupById(id);
        model.addAttribute("groups",groups);
        return "groups/groups";
    }
}
