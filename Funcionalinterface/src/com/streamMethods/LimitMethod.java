package com.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LimitMethod
{
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("prashanth");
        list.add("baalu");
        list.add("raaju");
        list.add("ravi");


        final Stream<String> names= list.stream().limit(6);
        names.forEach(s-> System.out.println(s));
    }
}
