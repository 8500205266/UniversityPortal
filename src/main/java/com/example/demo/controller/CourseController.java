package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController
{
    @Autowired(required=true)
    public CourseService cser;

    @RequestMapping("/getcourse")
    public List<Course> get()
    {
        return cser.getcourse();
    }

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody final Course course )
    {
        return cser.addCourse(course);
    }

    @RequestMapping(value="/deletecourse/{id}", method=RequestMethod.DELETE)
    public void deleteCourse( @PathVariable("id") int id)
    {
        cser.deleteCourse(id);
    }

    @RequestMapping(value="/updatecourse/{id}", method=RequestMethod.PUT)
    public Course updateCourse( @PathVariable("id") int id,@RequestBody Course course)
    {
        Course t=new Course();
        t.setCid(id);
        t.setCname(course.getCname());
        return cser.updatecourse(t);
    }

    //crud operations for

}
