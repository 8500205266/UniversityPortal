package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired(required=true)
    public EmployeeService ser;

    @RequestMapping("/getteacher")
    public List<Teacher> get()
    {
        return ser.getemp();
    }

    @PostMapping("/addteacher")
    public Teacher addTeacher(@RequestBody final Teacher teacher )
    {
        return ser.addEmp(teacher);
    }

    @RequestMapping(value="/deleteteacher/{id}", method=RequestMethod.DELETE)
    public void deleteemp( @PathVariable("id") int id)
    {
         ser.deleteemp(id);
    }

    @RequestMapping(value="/updateteacher/{id}", method=RequestMethod.PUT)
    public Teacher updateemp( @PathVariable("id") int id,@RequestBody Teacher teacher)
    {
        Teacher t=new Teacher();
        t.setTid(id);
        t.setTname(teacher.getTname());
        return ser.updateemp(t);
    }

    //crud operations for

}
