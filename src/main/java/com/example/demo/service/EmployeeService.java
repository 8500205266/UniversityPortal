package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    public TeacherRepository trepo;

    public List<Teacher> getemp()
    {
        return  trepo.findAll();
    }

    public Teacher addEmp(Teacher teacher)
    {
        return trepo.save(teacher);
    }

    public void deleteemp(int id)
    {
         trepo.deleteById(id);
    }

    public Teacher updateemp(Teacher t)
    {
        //trepo.save(t);
        return trepo.save(t);
    }
}
