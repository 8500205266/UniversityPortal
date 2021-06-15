package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Teacher;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired(required=true)
    public DepartmentService dser;

    @RequestMapping("/getdepartment")
    public List<Department> get()
    {
        return dser.getdep();
    }

    @PostMapping("/adddepartment")
    public Department addDepartmentt(@RequestBody Department department )
    {
        return dser.addDepartment(department);
    }

    @RequestMapping(value="/deleteDepartment/{id}", method=RequestMethod.DELETE)
    public void deleteDepartment( @PathVariable("id") int id)
    {
        dser.deletDepartment(id);
    }

    @RequestMapping(value="/updatedepartment/{id}", method=RequestMethod.PUT)
    public Department updateDepartment( @PathVariable("id") int id,@RequestBody Department department)
    {
        Department t=new Department();
       t.setDid(id);
       t.setDname(department.getDname());
        return dser.updateemp(t);
    }

    //crud operations for

}
