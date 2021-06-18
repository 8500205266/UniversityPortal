package com.parallelStream;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelStreamJava7 {
    public static void main(String[] args) {
        List<Student> list= getdata();
        // Fixed thread number
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (Student e : list)
        {
            if(e.getScore()>80) {
                service.execute(new MyTask(e));
            }
        }
        // shutdown
        // this will get blocked until all task finish
        //Split - (SplitIterator) -> Excute each of these using Fork join pool ->  Combine
        service.shutdown();

    }


        public static List<Student> getdata ()
        {
            ArrayList<Student> studentList = new ArrayList<>();
            Student s1 = new Student("prashanth", 82);
            Student s2 = new Student("baalu", 90);
            Student s3 = new Student("Raju", 65);
            Student s4 = new Student("Ravi", 55);
            Student s5 = new Student("lokesh", 85);
            Student s6 = new Student("virat", 88);
            Student s7 = new Student("mahi", 50);

            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
            studentList.add(s4);
            studentList.add(s5);
            studentList.add(s6);
            studentList.add(s7);
            return studentList;
        }

public static class MyTask implements Runnable {
    Object target;

    public MyTask(Object target) {
        this.target = target;
    }
    @Override
    public void run()
    {
        System.out.println(target);
        System.out.println(Thread.currentThread().getName()+" (Start)");

        System.out.println(Thread.currentThread().getName()+" (End)");
    }
}
}