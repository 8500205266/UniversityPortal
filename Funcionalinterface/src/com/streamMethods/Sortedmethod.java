package com.streamMethods;

import java.util.*;
import java.util.stream.Stream;

public class Sortedmethod
{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(133);
        list.add(11);
        list.add(122);

        list.stream().sorted();

// stream process the collection
// stream has pipeline methods

        final Stream<Integer> sorted = list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        });
        sorted.forEach(s-> System.out.println(s));
    }
}
