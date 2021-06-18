package com.predefined;
import java.util.function.Predicate;
public class Predicate_example {
    public static void main(String[] args) {
        Predicate<Integer> obj = (number) ->
        {
            if (number % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println("output-> " + obj.test(+22));
        System.out.println("output-> " + predicateOldMethod.oddoreven(+22));
    }
}
