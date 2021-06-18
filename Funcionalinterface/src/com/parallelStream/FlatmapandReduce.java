package com.parallelStream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlatmapandReduce {
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

        List<String> listOfCities = listOfEmployees.stream()
                .flatMap(e -> e.getListOfCities().stream())
                .collect(Collectors.toList());
        System.out.println("ListOfCities Usig Flatmap: " + listOfCities);


        //reduce Function uses to reduce elements
        System.out.println("employe name who has minimum age");
        listOfEmployees.stream()
                .reduce((a1, a2) -> (a1.getAge() < a2.getAge() ? a1 : a2))  // abstract interface
                .ifPresent(System.out::println);

        //find sumof age using reduce method

Integer sum=listOfEmployees.stream()
                                .map(employee -> employee.getAge())
                                .reduce(0,(employe1, employ2)->employe1+employ2);
        System.out.println(sum);

    }



}