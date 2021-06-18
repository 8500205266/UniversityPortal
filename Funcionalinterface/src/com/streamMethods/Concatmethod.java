package com.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concatmethod
{
    public static void main(String[] args)
    {

        List<String> list1= new ArrayList<>();
        List<String> list2= new ArrayList<>();

        list1.add("Raju");
        list1.add("gopi");
        list1.add("venky");
        list2.add("mani");
        list2.add("rajesh");
        list2.add("venkat");
        final Stream<String> concatResult = Stream.concat(list1.stream(), list2.stream());
        concatResult.forEach(s-> System.out.println(s));


    }
}
