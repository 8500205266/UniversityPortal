package com.javstreamBasics;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethod
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        System.out.println("before");
        System.out.println(list);

        System.out.println("After Add 10 marks to every student");
        List<Integer> output=list.stream().map(i->i+10).collect(Collectors.toList());
        System.out.println(output);



    }
}
