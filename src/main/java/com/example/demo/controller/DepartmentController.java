package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.Department;
import com.example.demo.model.DepartmentData;
import com.example.demo.model.Response;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController
{
    @Autowired
    public DepartmentService departmentService;

    @Autowired
    public Mapper mapper;

    @Autowired
    public DepartmentRepository departmentRepository;

    @RequestMapping("/getDepartment")
    public List<Department> getDepartment()
    {
        return departmentService.getDepartment();
    }

    @PostMapping("/addDepartment")
    public Response addDepartmentt(@RequestBody DepartmentData department )
    {
        return departmentService.addDepartment(mapper.toDepartmentIn(department));
    }

    @DeleteMapping("/deleteDepartmentById/{id}")
    public Response deleteDepartment(@PathVariable("id") int departmentId) throws ResourceNotFoundException
    {
        Department department=departmentRepository.findByDid(departmentId).orElseThrow(()->new ResourceNotFoundException("Department Id  is not Found"));
       return departmentService.deletDepartment(department);
    }

    @PutMapping("/updateDepartmentById/{id}")
    public Response updateDepartment(@PathVariable("id") int departmentId, @RequestBody DepartmentData department) throws ResourceNotFoundException {
        final Department departmentById = departmentRepository.findByDid(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department Id  is not Found"));
        departmentById.setDid(departmentId);
        departmentById.setDname(department.getDname());
        return departmentService.updateemp(departmentById);
    }

}
