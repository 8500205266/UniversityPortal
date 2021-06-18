package com.example.demo.model;

public class Response {
    private String reponseStatus;
    private String responseCode;
    private Object object;

    public String getReponseStatus() {
        return reponseStatus;
    }

    public void setReponseStatus(String reponseStatus) {
        this.reponseStatus = reponseStatus;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
