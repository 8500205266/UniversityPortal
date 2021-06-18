package com.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForeachMethod
{
    public static void main(String[] args) {
        List <String> list=new ArrayList<>();
        list.add("prashanth");
        list.add("baalu");
        list.add("naresh");
        list.add("raju");
        list.forEach(new Consumer<String>()
        {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
