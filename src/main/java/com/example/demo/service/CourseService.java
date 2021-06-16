package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
{
    @Autowired
    CourseRepository crepo;

    public List<Course> getcourse()
    {
        return crepo.findAll();
    }

    public Course addCourse(Course course)
    {
        return crepo.save(course);
    }

    public void deleteCourse(int id)
    {
        crepo.deleteById(id);
    }

    public Course updatecourse(Course t)
    {
        return crepo.save(t);
    }
}
