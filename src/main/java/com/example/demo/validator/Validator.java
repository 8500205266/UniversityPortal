package com.example.demo.validator;
import com.example.demo.exception.InvalidCourse;
import com.example.demo.exception.InvalidDepartment;
import com.example.demo.exception.NoContentException;
import com.example.demo.exception.TeacherNotFoundException;
import com.example.demo.model.Portal;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validator {



    public void validateTeacherInput(Portal portal) throws NoContentException, InvalidCourse ,InvalidDepartment
    {
        if(portal == null)
        {
            throw new NoContentException();
        }
        if(portal.getCourses() == null )
        {
            throw new InvalidCourse();
        }
        if(portal.getDepartmentId()==null)
        {
            throw new InvalidDepartment();
        }
    }

    public static void validateEmployee(Optional<Portal> employee) throws TeacherNotFoundException {
        if(!employee.isPresent())
        {
            //Throw new TeacherNotFoundException();
            throw new TeacherNotFoundException();
        }
    }

}
