package com.predefined;

public class TraditionalWay {
    public  int len(String s)
    {
        return s.length();
    }

    public String evenOrOdd(int number)
    {
        if (number % 2 == 0) {
            return "even";
        }
        return "odd";
    }
}
