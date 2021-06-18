package com.javaStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static final String STATE = "AP";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Address> addresses1 = new ArrayList<>();

        addresses1.add(new Address(502103, "Thimmapur", "Telangana", 1234));
        addresses1.add(new Address(512300, "adfa", "AP", 1235));
        Employee employee1 = new Employee(1, "Ramesh", 24, "M", 50000, addresses1);

        List<Address> addresses2 = new ArrayList<>();

        addresses2.add(new Address(502100, "bebipet", "AP", 1004));
        addresses2.add(new Address(512300, "chowdar", "AP", 1020));
        Employee employee2 = new Employee(2, "Samesh", 24, "M", 10000, addresses2);

        List<Address> addresses3 = new ArrayList<>();

        addresses3.add(new Address(502120, "irkode", "MH", 1104));
        addresses3.add(new Address(512302, "bhevi", "MH", 1120));
        Employee employee3 = new Employee(3, "Gamesh", 24, "F", 5000, addresses3);

        List<Address> addresses4 = new ArrayList<>();

        addresses4.add(new Address(502100, "nellore", "AP", 1004));
        addresses4.add(new Address(512300, "tirupati", "AP", 1020));
        Employee employee4 = new Employee(4, "Tamesh", 24, "M", 8000, addresses4);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

    // Find a employee who are all belongs to AP state

        ArrayList<Employee> telanganaEmployees = employees.stream()
                .filter(employee -> isStateEmployee(employee, "AP") )
                        .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(STATE+ "Employees");
        for (Employee employee : telanganaEmployees) {
            System.out.println(employee);
        }

        Map<String, List<Employee>> groupByGender = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getGender()));

        System.out.println("F Gender employees:");
        for (Employee emp : groupByGender.get("F")) {
            System.out.println(emp.toString());
        }


        //Group employees based on zipcode
        //103,103 is one group
        //101 is one group
        //104 is on group
        Map<List<Integer>, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(employee -> getPincodes(employee)));

        collect.forEach((pincode, employeelist) -> {
            System.out.println("Pincode is " + pincode);
            for (Employee emp : employeelist) {
                System.out.println(emp);
            }
        });


        //sort the employeee based on their employee names

        ArrayList<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors
                        .toCollection(ArrayList::new));

        System.out.println("Sorted by names employees: ");
        for (Employee employee : sortedEmployees) {
            System.out.println(employee);
        }

        //find the employee who start with T
        Stream<Employee> nameswitht = employees.stream()
                .filter(name -> name.getName().startsWith("T"));

        System.out.println("Employee names start with t -> " + nameswitht.collect(Collectors.toList()));

        //Find the employee whose salary greater than 5000

        System.out.println("Sorted  employees salaries: ");
        employees.stream()
                .filter(emp -> emp.getSalary() > 10000)
                .forEach(System.out::println);
    }

    public static boolean isStateEmployee(Employee employee, String state) {
        return employee.getAddress()
                .stream()
                .anyMatch(address -> address.getState().equals(state));
    }

    public static List<Integer> getPincodes(Employee employee) {
        return employee.getAddress()
                .stream()
                .map(address -> address.getPincode())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}