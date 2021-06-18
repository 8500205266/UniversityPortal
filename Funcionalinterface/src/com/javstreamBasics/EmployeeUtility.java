package com.javstreamBasics;
import java.util.*;
public class EmployeeUtility {

    public Map<Integer, List<Employee>> groupByAge(List<Employee> employeeList)
    {
        HashMap<Integer, List<Employee>> groupByAge = new HashMap<>();
        for (Employee employee : employeeList) {
            if (!groupByAge.containsKey(employee.getAge())) {
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                groupByAge.put(employee.getAge(), employees);
            } else {
                groupByAge.get(employee.getAge()).add(employee);
            }
        }
        return groupByAge;
    }

    public List<Employee> sortByAge(List<Employee> employees)
    {
        employees.sort(new EmpComparator());
        return employees;
    }

    public List<Employee> getEmployeesAgeGreaterThan(List<Employee> employees, int age) {
        List<Employee> ageGreaterThanList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > age) {
                ageGreaterThanList.add(employee);
            }
        }
        return ageGreaterThanList;
    }

    public List<Employee> nameStartsWith(List<Employee> employees, String starts) {
        List<Employee> startsWithLetter = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().startsWith(starts)) {
                startsWithLetter.add(employee);
            }
        }
        return startsWithLetter;
    }

    public List<Employee> employeesOfState(List<Employee> employees, String state) {
        List<Employee> stateEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getListOfCities().contains(state)) {
                stateEmployees.add(emp);
            }
        }
        return stateEmployees;
    }
}
