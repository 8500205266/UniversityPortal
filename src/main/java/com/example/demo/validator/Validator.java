package com.example.demo.validator;

import com.example.demo.exception.InvalidCourseAndInvalidDepartment;
import com.example.demo.exception.NoContentException;
import com.example.demo.model.Portal;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validateTeacherInput(Portal portal) throws NoContentException, InvalidCourseAndInvalidDepartment {
        if(portal == null) {
            throw new NoContentException();
        }
        if(portal.getCourses() == null || portal.getDepartmentId()==null) {
            throw new InvalidCourseAndInvalidDepartment("Some message");
        }
    }
}
