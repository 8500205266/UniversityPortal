package com.streamMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectMethod
{
    public static void main(String[] args)
    {
        List<Student> list=new ArrayList<>();
        Student s1=new Student(1,"prashanth","saidugari",1998);
        Student s2=new Student(2,"Baalu","jaali",1993);
        Student s3=new Student(3,"Raaju","peddolla",1996);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.forEach(s-> System.out.println(s.getId()));

        list.stream().collect(new Collector<Student, Object, Object>() {
            @Override
            public Supplier<Object> supplier()
            {
                return ArrayList::new;
                //return  () -> new ArrayList<>();
            }

            @Override
            public BiConsumer<Object, Student> accumulator()
            {
           //     return (list,p)->list.add(p);
                return null;
            }
            @Override
            public BinaryOperator<Object> combiner()
            {
                //return (l1,l2)->l1.addAll(l2);
                return null;
            }

            @Override
            public Function<Object, Object> finisher() {
                return null;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return null;
            }
        });
    }
}