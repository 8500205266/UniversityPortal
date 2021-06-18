package com.parallelStream;

import java.util.*;
import java.util.stream.Collectors;

public class Flatmapinjava7{
    public static void main(String[] args) {
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee e1 = new Employee("Mohan", 24, Arrays.asList("Telangana", "Banglore"));
        Employee e2 = new Employee("John", 27, Arrays.asList("Paris", "Chennai"));
        Employee e3 = new Employee("Vaibhav", 32, Arrays.asList("MP", "Telangana"));
        Employee e4 = new Employee("Amit", 27, Arrays.asList("Chennai", "MH"));

        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);

        //in map ->one output for one input
        //flat map ->multiple output for one input
        //flat map in java 7
        for(Employee employee:listOfEmployees)
        {
            System.out.println("find cities of employees->    "+employee.getListOfCities());

        }

        //reduce method in java 7
            int sum = 0;
        for(Employee employee:listOfEmployees)
        {
           sum=sum+employee.getAge();     
        }
        System.out.println(sum);

        int min= 1000000;
        for(Employee employee:listOfEmployees)
        {
            if(employee.getAge()<min)
            {
                min= employee.getAge();
            }
        }
        System.out.println("minimum age->  "+min);

    }
}
