package com.example.demo.service;
import com.example.demo.exception.*;
import com.example.demo.model.Department;
import com.example.demo.model.Teacher;
import com.example.demo.model.Response;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.TeacherlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService
{
    @Autowired
    public TeacherlRepository teacherlRepository;
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    public List<Teacher> getdata()
    {
        return teacherlRepository.findAll();
    }
    public Response addData(Teacher teacher) throws BadException, InvalidDepartment, InvalidCourse {
        Response response = new Response();
        response.setResponseCode("200 K");
        response.setReponseStatus("Employee Saved Successfully");
        Optional<Teacher> teacherById = teacherlRepository.findByTeacherId(teacher.getTeacherId());
        if (teacherById.isPresent())
        {
            throw new BadException("this is bad request");
        }
        else
        {
            Optional<Department> departmentid = departmentRepository.findByDid(teacher.getDepartmentId());
            if (departmentid.isPresent()) {
                final List<Integer> courses = teacher.getCourses();
                final List<Integer> validcourses = courses.stream().filter(courses1 -> (courseRepository.findByCid(courses1).isPresent())).collect(Collectors.toList());
                if (courses.size() == validcourses.size()) {
                    response.setObject(teacherlRepository.save(teacher));
                    return response;
                } else {
                    throw new InvalidCourse("This course is not Valid");
                }
            } else {
                throw new InvalidDepartment("this department is not valid ");
            }
        }
    }
    public Response deletedata(Teacher teacher)
    {
            Response response = new Response();
            response.setResponseCode("200 ");
            response.setReponseStatus("Employee is Deleted Successfully");
            response.setObject(teacher);
            teacherlRepository.delete(teacher);
            return response;

    }
    public Response updatedata(Teacher teacher) throws  InvalidCourse, InvalidDepartment, TeacherNotFoundException {

        Optional<Teacher> teacherById = teacherlRepository.findByTeacherId(teacher.getTeacherId());
        if (teacherById.isPresent())
        {
            Optional<Department> departmentid = departmentRepository.findByDid(teacher.getDepartmentId());
            if (departmentid.isPresent()) {
                final List<Integer> courses = teacher.getCourses();
                final List<Integer> validcourses = courses.stream().filter(courses1 -> (courseRepository.findByCid(courses1).isPresent())).collect(Collectors.toList());
                if (courses.size() == validcourses.size())
                {
                    Response response = new Response();
                    response.setResponseCode("200 ");
                    response.setReponseStatus("Employee is Updated Successfully");
                    response.setObject(teacherlRepository.save(teacher));
                    return response;
                } else {
                    throw new InvalidCourse("This course is not Valid");
                }
            } else {
                throw new InvalidDepartment("this department is not valid ");
            }
        }else {throw new TeacherNotFoundException("Teacher is not found");}

    }
}
