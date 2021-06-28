package com.example.demo.service;

import com.example.demo.exception.*;
import com.example.demo.model.Department;
import com.example.demo.model.Teacher;
import com.example.demo.model.Response;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PortalRepositry;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    public PortalRepositry portalRepositry;
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    private Validator validator;


    public Response getdata() throws TeacherNotFoundException {
        return validator.validateoutput(portalRepositry.findAll());
    }

    public Response addData(Teacher teacher) throws BadException, InvalidDepartment, InvalidCourse, NoContentException {

        validator.validateTeacherInput(teacher);
        Response response = new Response();
        response.setResponseCode("200 K");
        response.setReponseStatus("Employee Saved Successfully");


        Optional<Teacher> portalid = portalRepositry.findByTeacherId(teacher.getTeacherId());

        if (portalid.isPresent()) {
            throw new BadException();
        } else {
            Optional<Department> departmentid = departmentRepository.findByDid(teacher.getDepartmentId());
            if (departmentid.isPresent()) {
                final List<Integer> courses = teacher.getCourses();
                final List<Integer> validcourses = courses.stream().filter(courses1 -> (courseRepository.findByCid(courses1).isPresent())).collect(Collectors.toList());
                if (courses.size() == validcourses.size()) {
                    response.setObject(portalRepositry.save(teacher));
                    return response;
                } else {
                    throw new InvalidCourse();
                }
            } else {
                throw new InvalidDepartment();
            }
        }
    }


    public Response deletedata(int id) throws TeacherNotFoundException {

        Optional<Teacher> deleteobject = portalRepositry.findById(id);

        if (deleteobject.isPresent()) {
            Response response = new Response();
            response.setResponseCode("200 ");
            response.setReponseStatus("Employee is Deleted Successfully");
            response.setObject(deleteobject);
            portalRepositry.deleteById(id);
            return response;
        } else {
            throw new TeacherNotFoundException();
        }

    }

    public Response updatedata(Teacher t) {

        Response response2 = new Response();
        response2.setResponseCode("200 ");
        response2.setReponseStatus("Employee is Updated Successfully");
        response2.setObject(t);
        portalRepositry.save(t);
        return response2;

    }

    public Optional<Teacher> getdataById(int id) {
        return portalRepositry.findById(id);
    }


}
