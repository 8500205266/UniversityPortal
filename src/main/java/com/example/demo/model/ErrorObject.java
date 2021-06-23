package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorObject
{
    public String responseCode;
    public  String object;
    public  String statusCode;
    //public  String timestamp;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    public LocalDateTime timestamp;
    public String message;
    public  String debugMessage;
    public  String subErrors;
    public String status;

    public ErrorObject()
    {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(String subErrors) {
        this.subErrors = subErrors;
    }

    @Override
    public String toString() {
        return "ErrorObject{" +
                "responseCode='" + responseCode + '\'' +
                ", object='" + object + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", subErrors='" + subErrors + '\'' +
                '}';
    }
}
