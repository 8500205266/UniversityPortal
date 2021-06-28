package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Response;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService
{
    @Autowired
    DepartmentRepository departmentRepositry;

    public List<Department> getDepartment()
    {
        return departmentRepositry.findAll();
    }

    public Response addDepartment(Department department)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Department is Added Successfully");
        response.setObject(departmentRepositry.save(department));
        return response;
    }

    public Response deletDepartment(Department department)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Department is Deleted Successfully");
        response.setObject(department);
        departmentRepositry.delete(department);
        return response;
    }

    public Response updateemp(Department department)
    {
        Response response = new Response();
        response.setResponseCode("200 ");
        response.setReponseStatus("Department is Update Successfully");
        response.setObject(departmentRepositry.save(department));
        return response;
    }
}
