package com.example.demo.controller;

import com.example.demo.exception.TeacherNotFoundException;
import com.example.demo.model.Portal;
import com.example.demo.model.Response;
import com.example.demo.repository.PortalRepositry;
import com.example.demo.service.EmployeeService;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController
{
    @Autowired(required=true)
    public EmployeeService employeeService;

    @Autowired
    private PortalRepositry repositry;

    @Autowired
    private Validator validator;



    @RequestMapping(value = "/GetTeacherData",method = RequestMethod.GET)
    public Response getData()
    {
        Response response1 = new Response();
        response1.setResponseCode("Response Status Code: 200 OK");
        response1.setReponseStatus("Employee List Get Successfully");
        response1.setObject(employeeService.getdata());
        return  response1;
    }
    @RequestMapping("/GetTeacherDataById/{id}")
    public Portal getDataById(@PathVariable("id") int id) throws TeacherNotFoundException {
        Optional<Portal> teacher=employeeService.getdataById(id);
        if(!(teacher.isPresent()))
        {
            throw  new TeacherNotFoundException();
        }
       return  teacher.get();
    }

    @PostMapping("/AddTeacherData")
    public Response adddata(@RequestBody  Portal portal ) throws Exception
    {

            validator.validateTeacherInput(portal);
            Response response = new Response();
            response.setResponseCode("200 K");
            response.setReponseStatus("Employee Saved Successfully");
            response.setObject(employeeService.addData(portal));
            return response;

    }
    @RequestMapping(value="DelteTeacherById/{id}", method=RequestMethod.DELETE)
    public Response deleteData(@PathVariable("id") int id)  throws Exception
    {
        Optional<Portal> employee=repositry.findById(id);
        Validator.validateEmployee(employee);
      return employeeService.deletedata(id);
    }

    @RequestMapping(value="/UpdateTeacher{id}", method=RequestMethod.PUT)
    public Response updateData(@PathVariable("id") int id, @RequestBody Portal portal) throws TeacherNotFoundException {
        Optional<Portal> employee=repositry.findById(id);
        Validator.validateEmployee(employee);
        Portal t=new Portal();
        t.setId(id);
        t.setName(t.getName());
        t.setDepartmentId(t.getDepartmentId());
        t.setCourses(t.getCourses());
        return employeeService.updatedata(t);
    }

    //crud operations for

}
