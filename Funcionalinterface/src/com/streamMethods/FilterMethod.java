package com.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Prashanth");
        list.add("baalu");
        list.add("naresh");
        list.add("raju");

        System.out.println(list.stream().filter(new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                if(s.startsWith("P"))
                {
                    //System.out.println("names start with p"+s);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }).collect(Collectors.toList())
        );
    }
}