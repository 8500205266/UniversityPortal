package com.javstreamBasics;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilertMethod
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(50);
        list.add(90);

        System.out.println("before");
        System.out.println(list);

        System.out.println("After passing students");
        List<Integer> output=list.stream().filter(i->i>35).collect(Collectors.toList());
        System.out.println(output);

        System.out.println("After Failure Students count");
        long output1=list.stream().filter(i->i>35).count();
        System.out.println(output1);

        System.out.println("After Sorted Students marks");
        List<Integer> output2=list.stream().sorted().collect(Collectors.toList());
        System.out.println(output2);

    }
}
