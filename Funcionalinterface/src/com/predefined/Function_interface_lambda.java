package com.predefined;

import java.util.function.Function;

public class Function_interface_lambda {
    public static void main(String args[]) {
        TraditionalWay traditionalWay = new TraditionalWay();
        //Fun->1
        Function<String, Integer> obj = (s) ->
        {
            return s.length();
        };
        System.out.println("length of String-> " + obj.apply("prashanth"));
        System.out.println("length of String-> " + traditionalWay.len("prashanth"));

        //Fun->2
        Function<Integer, String> obj2 = (number) ->
        {
            if (number % 2 == 0) {
                return "even";
            } else {
                return "odd";
            }
        };
        System.out.println("number is ->" + obj2.apply(21));
        System.out.println("number is ->" + traditionalWay.evenOrOdd(21));

        //fun3 and fun 4 and develop another method andthen
        Function<String, Integer> obj3 = (s1) -> {
            System.out.println(s1.length());
            return s1.length();
        };


        Function<Integer, Integer> obj4 = (number1) -> number1 * 2;
        Function<Integer, Integer> obj5 = (number2) -> number2 + 2;

        Integer finalresult = obj3.andThen(obj4).andThen(obj5).apply("prashanthsaidugari");

        System.out.println("output result->" + finalresult);
    }

}