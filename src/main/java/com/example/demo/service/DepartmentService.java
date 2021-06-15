package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService
{
    @Autowired(required=true)
    DepartmentRepository drepo;

    public List<Department> getdep()
    {
        return drepo.findAll();
    }

    public Department addDepartment(Department department)
    {
        return drepo.save(department);
    }

    public void deletDepartment(int id)
    {
        drepo.deleteById(id);
    }

    public Department updateemp(Department t)
    {
        return drepo.save(t);
    }
}
