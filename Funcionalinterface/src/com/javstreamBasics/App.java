package com.javstreamBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {

    public static final String CHENNAI = "Chennai";
    public static final String A = "A";
    public static final int AGE = 25;

    public static void main(String[] args) {
        List<Employee> testEmployees = getTestData();
        EmployeeUtility employeeUtility = new EmployeeUtility();
        System.out.println("List of Employees");
        print(testEmployees);

        System.out.println("Employees Group By Age");
        System.out.println(employeeUtility.groupByAge(testEmployees));

        System.out.println("Employees sort by age");
        print(employeeUtility.sortByAge(testEmployees));

        System.out.println("Employees age greater than 25");
        print(employeeUtility.getEmployeesAgeGreaterThan(testEmployees, AGE));

        System.out.println("Employee names starts with");
        print(employeeUtility.nameStartsWith(testEmployees, A));

        System.out.println("Employees of state ");
        print(employeeUtility.employeesOfState(testEmployees, CHENNAI));
    }
    private static void print(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static List<Employee> getTestData() {
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee e1 = new Employee("Mohan", 24, Arrays.asList("Telangana", "Banglore"));
        Employee e2 = new Employee("John", 27, Arrays.asList("Paris", "Chennai"));
        Employee e3 = new Employee("Vaibhav", 32, Arrays.asList("MP", "Telangana"));
        Employee e4 = new Employee("Amit", 27, Arrays.asList("Chennai", "MH"));
        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
        return listOfEmployees;
    }
}
