package com.example.demo.mapper;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;



@Component
public class Mapper
{
    public Course toCourseData(CourseData courseData)
    {
        Course course = new Course();
        course.setCid(courseData.getCid());
        course.setCname(courseData.getCname());
        return course;
    }
    public Department toDepartmentIn(DepartmentData departmentData)
    {
        Department department=new Department();
        department.setDid(departmentData.getDid());
        department.setDname(departmentData.getDname());
        return department;
    }
    public Teacher toPortalIn(TeacherData teacherData)
    {
        Teacher teacher =new Teacher();
        teacher.setId(teacherData.getId());
        teacher.setName(teacherData.getName());
        teacher.setTeacherId(teacherData.getTeacherId());
        teacher.setCourses(teacherData.getCourses());
        teacher.setDepartmentId(teacherData.getDepartmentId());
        return teacher;
    }

}
