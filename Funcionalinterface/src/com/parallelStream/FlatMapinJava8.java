package com.parallelStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapinJava8
{
    public static void main(String[] args)
    {
        List<FlatmapData> list=new ArrayList<>();
        FlatmapData e1=new FlatmapData("IIIT-Basar", Arrays.asList("Hydarabad","Chennai"));
        FlatmapData e2=new FlatmapData("Mallareddy", Arrays.asList("Hydarabad","bangalore"));
        FlatmapData e3=new FlatmapData("Geetanjali", Arrays.asList("Siddipet","Vishaka"));
        list.add(e1);
        list.add(e2);
        list.add(e3);

       List<String> listcolleges= list.stream().map(e->e.getName()).collect(Collectors.toList());
        System.out.println(listcolleges);

        List<String> listlocations= list.stream().flatMap(a->a.getLocations().stream()).collect(Collectors.toList());
        System.out.println(listlocations);
    }

}