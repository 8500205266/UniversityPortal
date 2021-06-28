package com.example.demo.exception;

import com.example.demo.model.ResponseObject;
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
        public ResponseEntity<Response> handleExceptions( TeacherNotFoundException exceptiont) {
            Response response = new Response();
            response.setResponseCode("404");
            response.setReponseStatus("Not found");
            ResponseObject responseObject =new ResponseObject();
            responseObject.setResponseCode("0");
            responseObject.setObject("null");
            responseObject.setStatus("BAD_REQUEST");
            responseObject.setStatusCode("404");
            responseObject.setTimestamp(LocalDateTime.now());
            responseObject.setMessage("Id does not exist");
            responseObject.setDebugMessage("null");
            responseObject.setSubErrors("null");
            response.setObject(responseObject);

            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Response> handleExceptions( NoContentException exceptiont) {
        Response response = new Response();
        response.setResponseCode("204");
        response.setReponseStatus("No Content");
        ResponseObject responseObject =new ResponseObject();
        responseObject.setResponseCode("0");
        responseObject.setObject("null");
        responseObject.setStatus("No Content Exception");
        responseObject.setStatusCode("204");
        responseObject.setTimestamp(LocalDateTime.now());
        responseObject.setMessage("No Content Available");
        responseObject.setDebugMessage("null");
        responseObject.setSubErrors("null");
        response.setObject(responseObject);

        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(InvalidCourse.class)
    public ResponseEntity<Response> handle(InvalidCourse ex)
    {
        Response response = new Response();
        response.setResponseCode("422");
        response.setReponseStatus("Unprocessable Entity");
        ResponseObject responseObject =new ResponseObject();
        responseObject.setResponseCode("0");
        responseObject.setObject("null");
        responseObject.setStatus("In valid Course data");
        responseObject.setStatusCode("422");
        responseObject.setTimestamp(LocalDateTime.now());
        responseObject.setMessage("In Valid Course Data");
        responseObject.setDebugMessage("null");
        responseObject.setSubErrors("null");
        response.setObject(responseObject);
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidDepartment.class)
    public ResponseEntity<Response> handle(InvalidDepartment ex)
    {
        Response response = new Response();
        response.setResponseCode("422");
        response.setReponseStatus("Unprocessable Entity");
        ResponseObject responseObject =new ResponseObject();
        responseObject.setResponseCode("0");
        responseObject.setObject("null");
        responseObject.setStatus("Invalid Department Data");
        responseObject.setStatusCode("422");
        responseObject.setTimestamp(LocalDateTime.now());
        responseObject.setMessage("Invalid Department Data");
        responseObject.setDebugMessage("null");
        responseObject.setSubErrors("null");
        response.setObject(responseObject);
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
        @ExceptionHandler(BadException.class)
    public ResponseEntity<Response> handle(BadException ex)
        {

            Response response = new Response();
            response.setResponseCode("400");
            response.setReponseStatus("Bad Request");
            ResponseObject responseObject =new ResponseObject();
            responseObject.setResponseCode("0");
            responseObject.setObject("null");
            responseObject.setStatus("It is Bad Request");
            responseObject.setStatusCode("422");
            responseObject.setTimestamp(LocalDateTime.now());
            responseObject.setMessage("This is Bad Request");
            responseObject.setDebugMessage("null");
            responseObject.setSubErrors("null");
            response.setObject(responseObject);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handle(ResourceNotFoundException ex)
    {
        Response response = new Response();
        response.setResponseCode("404");
        response.setReponseStatus("Resource-Not-Found");
        ResponseObject responseObject =new ResponseObject();
        responseObject.setResponseCode("0");
        responseObject.setObject("null");
        responseObject.setStatus("ResourceNotFound");
        responseObject.setStatusCode("404");
        responseObject.setTimestamp(LocalDateTime.now());
        responseObject.setMessage("ResourceisNotFound");
        responseObject.setDebugMessage("null");
        responseObject.setSubErrors("null");
        response.setObject(responseObject);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
