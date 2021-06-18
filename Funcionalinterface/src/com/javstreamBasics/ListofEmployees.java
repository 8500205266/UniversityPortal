package com.javstreamBasics;

import java.util.*;
import java.util.stream.Collectors;

public class ListofEmployees
{
    public static void main(String[] args)
    {
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee e1 = new Employee("Mohan", 24,Arrays.asList("Telangana","Banglore"));
        Employee e2 = new Employee("John", 27,Arrays.asList("Paris","Chennai"));
        Employee e3 = new Employee("Vaibhav", 32,Arrays.asList("MP","Telangana"));
        Employee e4 = new Employee("Amit", 27,Arrays.asList("Chennai","MH"));

        //listOfEmployees.add(e1);
        Employees emplist=new Employees();
        emplist.add(e1);
        emplist.add(e2);
        emplist.add(e3);
        emplist.add(e4);
        emplist.employees.forEach(System.out::println);
        //listOfEmployees.add(e2);
        //listOfEmployees.add(e3);
        //listOfEmployees.add(e4);


        //Common intemediate operations

        //find out names of employees using map
        List<String> employeelist1= emplist.employees.stream()
                                                        .map(emp->emp.getName())
                                                         .map(s -> s.toUpperCase())
                                                        .collect(Collectors.toList());
        System.out.println("employee names using map->  "+employeelist1);

        //find out names of employees starts with 'A' using Filter
        List<String> employeeNames =  emplist.employees.stream()
                                                         .map(e -> e.getName())
                                                        . filter(s -> s.startsWith("A"))
                                                        .collect(Collectors.toList());
        System.out.println("Employee names start with A"+employeeNames);

        //sorted the employee list using sorted metod
        ArrayList<Employee> sortedEmployees =  emplist.employees.stream()
                                    .sorted(Comparator.comparing(Employee::getName))
                                    .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Sorted by names employees: ");
        sortedEmployees.forEach(employee -> System.out.println(employee));

            //get the employee list of limit 2
        List<Employee> employees =  emplist.employees.stream()
                .limit(2)
                .collect(Collectors.toList());
                System.out.println("employee list of limit 2"+employees);

                //skip(3) discards first 3 elements from stream.
        List<Employee> skipemployees =  emplist.employees.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("discard first 3 employees "+employees);

        //in map ->one output for one input
        //flat map ->multiple output for one input

        List<String> listOfCities =  emplist.employees.stream()
                                .flatMap(e->e.getListOfCities() .stream())
                               .collect(Collectors.toList());
        System.out.println("ListOfCities Usig Flatmap: " +listOfCities);

        //Common terminal operations
            //foreach
            System.out.println("employee list using foreach");
        emplist.employees.stream().forEach(employee -> System.out.println(employee));


            //collector for collect the names
        System.out.println("collect names using collector");
        List<String> employeeNames1 =  emplist.employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeNames1);

//reduce Function uses to reduce elements
                System.out.println("employe name who has minimum age");
        emplist.employees.stream()
                .reduce( (a1,a2)-> (a1.getAge() < a2.getAge()? a1:a2))
                .ifPresent(System.out::println);

                //count the employee list start with J

              System.out.println("employe name start with J");
                long countofemp= emplist.employees.stream().filter(s->s.getName().startsWith("J")).count();
                 System.out.println(countofemp);

                 //all match returns boolean value
        boolean allMatch =  emplist.employees.stream()
                .allMatch(e ->e.getAge()>18);
        System.out.println("Are all the employess adult: " +allMatch);

         //any match
        boolean anyMatch =  emplist.employees.stream()
                .anyMatch(e ->e.getAge()>30);
        System.out.println("is any employee's age greater than 30: " +anyMatch);

        //find the employee who has min age
        Optional<Employee> minEmpOpt =  emplist.employees.stream()
                .min(Comparator.comparing(Employee::getAge));

        System.out.println("Employee with minimum age is: " +minEmpOpt.get());

        //write methods using in java7
        //search who is belongs to telangana state


        //Group employees based on Age
        HashMap<Integer, List<Employee>> hashMap = new HashMap<Integer, List<Employee>>();
        for (Employee emp1:emplist.employees) {
            if (!hashMap.containsKey(emp1.getAge())) {
                List<Employee> list11 = new ArrayList<Employee>();
                list11.add(emp1);
                hashMap.put(emp1.getAge(), list11);
            }
            else
            {
                hashMap.get(emp1.getAge()).add(emp1);
            }
        }
        System.out.println(hashMap);


        Collections.sort(emplist.employees, new EmpComparator());
        for (Employee emp1:emplist.employees)
        {
            System.out.println(emp1);
        }

        System.out.println("Employee age greater than 24");
        for (Employee emp1:emplist.employees)
        {
            if(emp1.getAge()>24){
            System.out.println(emp1);
        }
        }
        System.out.println("Employee names start with A");
        for (Employee emp1:emplist.employees) {
            if (emp1.getName().startsWith("A")) {
                System.out.println(emp1);
            }
        }


    }
    }
