package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Response;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
{
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getcourse()
    {
        return  courseRepository.findAll();
    }

    public Response addCourse(Course course)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Course is Added Successfully");
        response.setObject( courseRepository.save(course));
        return response;
    }

    public Response deleteCourse(Course course)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Course is Deleted Successfully");
        response.setObject(course);
        courseRepository.delete(course);
        return response;
    }

    public Response updatecourse(Course course)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Course is Updated Successfully");
        response.setObject( courseRepository.save(course));
        return response;
    }
}
