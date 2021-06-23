package com.example.demo.exception;

import com.example.demo.model.ErrorObject;
import com.example.demo.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Handler extends RuntimeException
{
        @ExceptionHandler(TeacherNotFoundException.class)
        public ResponseEntity handleExceptions( TeacherNotFoundException exceptiont) {
            Response response = new Response();
            response.setResponseCode("404");
            response.setReponseStatus("Not found");
            ErrorObject errorObject =new ErrorObject();
            errorObject.setResponseCode("0");
            errorObject.setObject("null");
            errorObject.setStatus("BAD_REQUEST");
            errorObject.setStatusCode("404");
            errorObject.setTimestamp(LocalDateTime.now());
            errorObject.setMessage("Id does not exist");
            errorObject.setDebugMessage("null");
            errorObject.setSubErrors("null");
            response.setObject(errorObject );
            //response.setObject();
          //  return response;
            return new ResponseEntity(response,HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity handleExceptions( NoContentException exceptiont) {
        Response response = new Response();
        response.setResponseCode("204");
        response.setReponseStatus("No Content");
        ErrorObject errorObject =new ErrorObject();
        errorObject.setResponseCode("0");
        errorObject.setObject("null");
        errorObject.setStatus("No Content Exception");
        errorObject.setStatusCode("204");
        errorObject.setTimestamp(LocalDateTime.now());
        errorObject.setMessage("No Content Available");
        errorObject.setDebugMessage("null");
        errorObject.setSubErrors("null");
        response.setObject(errorObject );
        //response.setObject();
        //  return response;
        return new ResponseEntity(response,HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(InvalidCourse.class)
    public ResponseEntity handle(InvalidCourse ex)
    {
        Response response = new Response();
        response.setResponseCode("422");
        response.setReponseStatus("Unprocessable Entity");
        ErrorObject errorObject =new ErrorObject();
        errorObject.setResponseCode("0");
        errorObject.setObject("null");
        errorObject.setStatus("In valid Course data");
        errorObject.setStatusCode("422");
        errorObject.setTimestamp(LocalDateTime.now());
        errorObject.setMessage("In Valid Course Data");
        errorObject.setDebugMessage("null");
        errorObject.setSubErrors("null");
        response.setObject(errorObject );
        return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidDepartment.class)
    public ResponseEntity handle(InvalidDepartment ex)
    {
        Response response = new Response();
        response.setResponseCode("422");
        response.setReponseStatus("Unprocessable Entity");
        ErrorObject errorObject =new ErrorObject();
        errorObject.setResponseCode("0");
        errorObject.setObject("null");
        errorObject.setStatus("Invalid Department Data");
        errorObject.setStatusCode("422");
        errorObject.setTimestamp(LocalDateTime.now());
        errorObject.setMessage("Invalid Department Data");
        errorObject.setDebugMessage("null");
        errorObject.setSubErrors("null");
        response.setObject(errorObject );
        return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
        @ExceptionHandler(Exception.class)
    public ResponseEntity handle(Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
}
