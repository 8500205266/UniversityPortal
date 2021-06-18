package com.javaStreams;

import java.util.ArrayList;
import java.util.List;

public class EmployeesMethods {
    List<Employee> employeeList;

    public EmployeesMethods(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public EmployeesMethods() {
        employeeList = new ArrayList<>();
    }

    public void add(Employee employee) {
        employeeList.add(employee) ;
    }
    public void delete(Employee employee) {
        employeeList.remove(employee);
    }
}
