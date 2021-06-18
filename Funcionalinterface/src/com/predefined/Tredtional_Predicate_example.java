package com.predefined;
import java.util.function.Predicate;

public class Tredtional_Predicate_example implements Predicate<Integer>
{
    @Override
    public boolean test(Integer i)
    {
        if(i%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[]args)
    {
        Predicate<Integer> obj= new Tredtional_Predicate_example();
        System.out.println(obj.test(11));
    }
}
