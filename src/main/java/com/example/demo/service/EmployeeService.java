package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Department;
import com.example.demo.model.Portal;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PortalRepositry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Portal> getdata() {
        return portalRepositry.findAll();
    }

    public Portal addData(Portal teacher) throws Exception
    {
//cid=11
        Optional<Course> course = courseRepository.findByCid(teacher.getCourseId());
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
        throw new Exception("Invalid Course , Course is not there");
    }


    public void deletedata(int id) {
        portalRepositry.deleteById(id);
    }


    public Portal updatedata(Portal t) {
        return portalRepositry.save(t);
    }
}
