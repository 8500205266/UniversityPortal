package com.example.demo.controller;

import com.example.demo.model.Portal;
import com.example.demo.model.Response;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired(required=true)
    public EmployeeService employeeService;

    @RequestMapping("/getdata")
    public List<Portal> getData()
    {
        return employeeService.getdata();
    }

    @PostMapping("/adddata")
    public Response adddata(@RequestBody final Portal portal ) throws Exception {
        Response response = new Response();
        response.setResponseCode("200");
        response.setReponseStatus("Employee Saved Successfully");
        response.setObject(employeeService.addData(portal));
        return response;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteData( @PathVariable("id") int id)
    {
         employeeService.deletedata(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Portal updateData( @PathVariable("id") int id,@RequestBody Portal portal)
    {
        Portal t=new Portal();
        t.setId(id);
        t.setName(t.getName());
        return employeeService.updatedata(t);
    }

    //crud operations for

}
