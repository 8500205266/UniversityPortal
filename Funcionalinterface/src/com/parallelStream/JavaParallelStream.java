package com.parallelStream;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class JavaParallelStream
{
    public static void main(String[] args)
    {
        ArrayList<Student> studentList=new ArrayList<>();
        Student s1=new Student("prashanth",82);
        Student s2=new Student("baalu",90);
        Student s3=new Student("Raju",65);
        Student s4=new Student("Ravi",55);
        Student s5=new Student("lokesh",85);
        Student s6=new Student("virat",88);
        Student s7=new Student("mahi",50);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);

        ForkJoinPool pool=ForkJoinPool.commonPool();
        System.out.println(pool.getParallelism());

        //this is using normal stream(sequential processing )
        System.out.println("students name who has student score is  greater than 80 using normal Stream");

        long stratTime1=0;
        long endTime1=0;
         stratTime1=System.currentTimeMillis();
        studentList.stream()
                .filter(student -> student.getScore()>80)
                .limit(3)
                .forEach(student -> System.out.println("Student name ->    "+student.getName()+" Student Score ->  "+student.getScore()));
         endTime1=System.currentTimeMillis();
        long totalTimeStream=(endTime1-stratTime1);
        System.out.println("Total Time uints in normal Stream");
        System.out.println(totalTimeStream);

        //using parallel stream
        long parallelStreamStratTime=0;
        long parallStreamendtime=0;
        System.out.println("students name who has student score is  greater than 80 using parallel Stream");
         parallelStreamStratTime=System.currentTimeMillis();
        studentList.parallelStream()
                .filter(student -> student.getScore()>80)
                .limit(3)
                .forEach(student -> System.out.println("Student name ->    "+student.getName()+" Student Score ->  "+student.getScore()));
        parallStreamendtime=System.currentTimeMillis();
        long totalTime=(parallStreamendtime-parallelStreamStratTime);
        System.out.println("Total time in parallel stream");
        System.out.println(totalTime);

//convert normal Stream to Parallel stream
        System.out.println("students name who has student score is  greater than 80 using convert normal  to parallel stream");
        studentList.stream()
                .parallel()
                .filter(student -> student.getScore()>80)
                .limit(3)
                .forEach(student -> System.out.println("Student name ->    "+student.getName()+" Student Score ->  "+student.getScore()));

    }
}
