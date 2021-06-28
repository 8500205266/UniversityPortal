package com.example.demo.controller;

import com.example.demo.exception.*;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.Response;
import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherData;
import com.example.demo.repository.TeacherlRepository;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
public class EmployeeController {
    @Autowired
    public TeacherService teacherService;

    @Autowired
    public TeacherlRepository teacherRepository;

    @Autowired
    public Mapper mapper;


    @GetMapping("/getTeacher")
    public List<Teacher> getData() {
        return teacherService.getdata();
    }

    @RequestMapping("/getTeacherDataById/{id}")
    public Teacher getDataById(@PathVariable("id") int id) throws TeacherNotFoundException {
        return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher data is Not Found"));
    }

    @PostMapping("/addTeacherData")
    public Response adddata(@RequestBody TeacherData teacherData) throws InvalidCourse, InvalidDepartment, BadException {
        return teacherService.addData(mapper.toPortalIn(teacherData));
    }

    @DeleteMapping("delteTeacherById/{id}")
    public Response deleteData(@PathVariable("id") int id) throws TeacherNotFoundException {
        final Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher is Not Found"));
        return teacherService.deletedata(teacher);
    }

    @PutMapping("/updateTeacher/{id}")
    public Response updateData(@PathVariable("id") int id, @RequestBody TeacherData teacherData) throws TeacherNotFoundException {
        teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher is Not Found"));
        teacherData.setId(id);
        teacherData.setName(teacherData.getName());
        teacherData.setDepartmentId(teacherData.getDepartmentId());
        teacherData.setCourses(teacherData.getCourses());
        return teacherService.updatedata(mapper.toPortalIn(teacherData));
    }

}
