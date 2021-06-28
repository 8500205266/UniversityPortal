package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.Course;
import com.example.demo.model.CourseData;
import com.example.demo.model.Response;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    public CourseService courseservice;

    @Autowired
    public Mapper mapper;

    @Autowired
    public CourseRepository courseRepository;

    @RequestMapping("/getcourse")
    public List<Course> get() {
        return courseservice.getcourse();
    }

    @PostMapping("/addcourse")
    public Response addCourse(@RequestBody final CourseData course) {
        return courseservice.addCourse(mapper.toCourseData(course));
    }

    @DeleteMapping("/deletecourseById/{id}")
    public Response deleteCourse(@PathVariable("id") int courseId) throws ResourceNotFoundException {
        final Course course = courseRepository.findByCid(courseId).orElseThrow(() -> new ResourceNotFoundException("Course is not Found"));
       return courseservice.deleteCourse(course);
    }

    @PutMapping("/updatecourse/{id}")
    public Response updateCourse(@PathVariable("id") int courseId, @RequestBody CourseData coursedata) throws ResourceNotFoundException {
        Course courseById = courseRepository.findByCid(courseId).orElseThrow(() -> new ResourceNotFoundException("Course is not Found"));
        courseById.setCid(courseId);
        courseById.setCname(coursedata.getCname());
        return courseservice.updatecourse(courseById);
    }
}
