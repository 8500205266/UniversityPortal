package com.predefined;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Student {
     int id;
     String name;

     public Student(int id, String name) {
         this.id = id;
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     @Override
     public String toString() {
         return id + "-" + name;
     }
 }
     class StudentList
    {
        public static void main(String[] args)
        {
            List<Student> list=new ArrayList<Student>();
            Student s1=new Student(1,"prashanth");
            Student s2=new Student(40,"raju");
            list.add(s1);
            list.add(s2);
            for(Student b:list){
                System.out.println(b.id+" "+b.name);
            }

            //predicate
            Predicate <Student> studentdetail=(Student s)->s.getId()>18;
        List<Student> greaterstudentlist = new ArrayList<Student>();
        for (Student student : list)
        {
            if (studentdetail.test(student))
            {
                greaterstudentlist.add(student);
            }
        }
            System.out.println("using predicate age greater 18"+greaterstudentlist);


        //consumer
            Consumer<Student> nameConsumer = (Student student) -> {
                System.out.println("student names using consumer=> "+student.getName());
            };

            for (Student student : list)
            {
                nameConsumer.accept(student);
            }

            //Function
            Function<Student,String> lenthofnames=(Student stu)-> stu.getName();
            List<String> studentNames = new ArrayList<String>();

            for (Student student : list)
            {
                studentNames.add(lenthofnames.apply(student));
            }
            System.out.println("student names using Function interface=> "+studentNames);

            //Supplier
            Supplier<Student> studentSupplier = () -> new Student(111, "New Student");
            System.out.println("new student details using supplier=>    "+studentSupplier.get());
            list.add(studentSupplier.get());

        }
    }



