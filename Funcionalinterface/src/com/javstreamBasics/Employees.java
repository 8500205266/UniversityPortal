package com.javstreamBasics;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    List<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Employee emp) {
        employees.add(emp);
    }

    public Employee get(String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return employee;
            }
        }
        return null;
    }

    public void remove(String name) {
        employees.remove(get(name));
    }

    public Employee update(Employee employee) {
        Employee existingEmployee = get(employee.getName());
        Employee updatingEmployee = mapFields(existingEmployee, employee);
        remove(employee.getName());
        add(updatingEmployee);
        return updatingEmployee;
    }

    public Employee mapFields(Employee first, Employee second) {
        first.setAge(second.getAge());
        first.setListOfCities(second.getListOfCities());
        return first;
    }
}
