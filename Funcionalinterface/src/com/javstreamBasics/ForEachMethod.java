package com.javstreamBasics;

import java.util.ArrayList;

public class ForEachMethod
{
    public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(50);
        list.add(90);

        System.out.println("before");
        System.out.println(list);

        for (int i=0;i<5;i++)
        {
            System.out.println(list.get(i));
        }

        for (int i:list)
        {
            System.out.println(i);
        }
        System.out.println("For each method");
        list.forEach(i-> System.out.println(i));
}
}