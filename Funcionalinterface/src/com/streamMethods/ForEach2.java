package com.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class cosumerAction implements Consumer<String>
{
    @Override
    public void accept(String s)
    {
        System.out.println(s);
    }

}

public class ForEach2
{
    public static void main(String[] args)
    {
        List<String> list=new ArrayList<>();
        list.add("prashanth");
        list.add("baalu");
        list.add("naresh");
        list.add("raju");

        cosumerAction a=new cosumerAction();
        list.forEach(a);

    }

}