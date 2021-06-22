package com.example.demo.service;

import com.example.demo.exception.InvalidCourseAndInvalidDepartment;
import com.example.demo.model.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PortalRepositry;
import com.example.demo.repository.Portal_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public PortalRepositry portalRepositry;
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    public Portal_course portal_course;

    public List<Portal> getdata() {
        return portalRepositry.findAll();
    }

    public Portal addData(Portal teacher) throws Exception {
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


        Optional<Portal_course> portalid = portal_course.findById(teacher.getTeacherId());


        //   if(!portal.isEmpty())

        if (!portalid.isPresent()) {
            System.out.println("employee existst");
            throw new Exception("Teacher Id is Already Exists We Can't create Teacher Again");
        }
        else
        {
            Optional<Department> departmentid = departmentRepository.findByDid(teacher.getDepartmentId());
             if (departmentid.isPresent()) {
                    Optional<Course> coureid = courseRepository.findByCid(teacher.getCourseId());
                    if (coureid.isPresent())
                    {
                        return portalRepositry.save(teacher);
                    } else
                    {

                        throw new InvalidCourseAndInvalidDepartment("Invalid Course , Course is not there");
                    }
                }
             else {
                 throw new InvalidCourseAndInvalidDepartment("Invalid did , this  is not valid department Id");
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

    public Response deletedata(int id)
    {

        Optional<Portal> deleteobject=portalRepositry.findById(id);
        if(deleteobject.isPresent())
        {
            Response response2 = new Response();
            response2.setResponseCode("200 ");
            response2.setReponseStatus("Employee is Deleted Successfully");
            response2.setObject(deleteobject);
            portalRepositry.deleteById(id);
            return response2;
        }
        else
        {
            Response response=new Response();
            response.setResponseCode("400");
            response.setReponseStatus("Id does not exist");
           // Object object=new Object();
            ErrorObject errorObject =new ErrorObject();
            errorObject.setResponseCode("0");
           errorObject.setObject("null");
           errorObject.setStatus("BAD_REQUEST");
           errorObject.setStatusCode("400");
           errorObject.setTimestamp(LocalDateTime.now());
           errorObject.setMessage("Id does not exist");
            errorObject.setDebugMessage("null");
            errorObject.setSubErrors("null");
            response.setObject(errorObject );
            //response.setObject();
            return response;
        }
    }

    public Portal updatedata(Portal t) {
        return portalRepositry.save(t);
    }


    public Optional<Portal> getdataById(int id)
    {
        return portalRepositry.findById(id);
    }
}
