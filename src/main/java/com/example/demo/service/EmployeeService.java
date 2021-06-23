package com.example.demo.service;

import com.example.demo.exception.InvalidCourse;
import com.example.demo.exception.InvalidDepartment;
import com.example.demo.exception.NoContentException;
import com.example.demo.model.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PortalRepositry;
import com.example.demo.repository.Portal_courseRepositry;
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
    public Portal_courseRepositry portal_courseRepositry;

    public List<Portal> getdata()
    {
        return portalRepositry.findAll();
    }

    public Portal addData(Portal teacher) throws Exception,NoContentException {
//cid=11
        /*Optional<Course> course = courseRepository.findByCid(teacher.getCourseId());
        //cid=11 tid=1 did
        //cid=11 tid=2 did
        List<Portal> existingTeacher = portalRepositry.findByTeacherId(teacher.getTeacherId());
        //if enter tid=112  cid=11
               //   tid=112    cid=11
        existingTeacher.forEach(s-> System.out.println(s));
        if (course.isPresent() && existingTeacher != null && !existingTeacher.isEmpty()) {
            if (existingTeacher.get(0).getDepartmentId().equals(teacher.getDepartmentId())) {
                return portalRepositry.save(teacher);
            } else {
                throw new Exception("Teacher belongs to another department already!");
            }
            //new teacher
        } else if (course.isPresent()) {
            Optional<Department> dept = departmentRepository.findByDid(teacher.getDepartmentId());
            if (dept.isPresent()) {
                return portalRepositry.save(teacher);
            }
            throw new Exception("Invalid department , Department is not there");
        }
        throw new Exception("Invalid Course , Course is not there");*/

        Optional<Portal> portalid = portalRepositry.findByTeacherId(teacher.getTeacherId());

        if (portalid.isPresent())
        {
            System.out.println("employee existst");
            throw new Exception("Teacher Id is Already Exists We Can't create Teacher Again");
        }

        else {
            Optional<Department> departmentid = departmentRepository.findByDid(teacher.getDepartmentId());
            if (departmentid.isPresent()) {
                final List<Integer> courses = teacher.getCourses(); //1,2,3
                final List<Integer> valid_courses = courses.stream().filter(courses1 -> (courseRepository.findByCid(courses1).isPresent())).collect(Collectors.toList());
               //1,2

                if (courses.size() == valid_courses.size()) {
                    return portalRepositry.save(teacher);
                } else {
                    throw new InvalidCourse();
                }
            } else {
                throw new InvalidDepartment();
            }
        }
    }

/*           else if (departmentid.isPresent())
            {
                System.out.println("got");
                if (portalid.get(0).getDepartmentId().equals(teacher.getDepartmentId())) {
                    Optional<Course> coureid = courseRepository.findByCid(teacher.getCourseId());
                    if (coureid.isPresent()) {
                        return portalRepositry.save(teacher);
                    } else {
                        throw new Exception("Invalid Course , Course is not there");
                    }
                }*/

    // return nul

    public Response deletedata(int id) {

     Optional<Portal> deleteobject = portalRepositry.findById(id);
        //if (deleteobject.isPresent()) {
            Response response2 = new Response();
            response2.setResponseCode("200 ");
            response2.setReponseStatus("Employee is Deleted Successfully");
            response2.setObject(deleteobject);
            portalRepositry.deleteById(id);
            return response2;

    }

    public Response updatedata(Portal t)
    {

        Response response2 = new Response();
        response2.setResponseCode("200 ");
        response2.setReponseStatus("Employee is Deleted Successfully");
        response2.setObject(t);
        portalRepositry.save(t);
        return response2;

       // return portalRepositry.save(t);
    }


    public Optional<Portal> getdataById(int id) {
        return portalRepositry.findById(id);
    }
}
