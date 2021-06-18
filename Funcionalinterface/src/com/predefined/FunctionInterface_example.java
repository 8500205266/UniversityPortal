package com.predefined;

import java.util.function.Function;

public class FunctionInterface_example {
    public static void main(String args[]) {
        Function<String, Integer> obj = new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return s.length();

            }
        };
        System.out.println("length of String-> " + obj.apply("prashanth"));
    }
}