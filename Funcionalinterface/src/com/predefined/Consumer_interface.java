package com.predefined;

import java.util.function.Consumer;

public class Consumer_interface
{
    public static void main(String [] args)
    {
        Consumer<Integer> obj=(number)->{System.out.println("output=> "+number);};
        obj.accept(12);
        consumerclass_oldmethod.accpectname(232);

        Consumer<Integer> obj1=(number)->{System.out.println("object 1=> "+number);};
        obj1.accept(12);

        Consumer<Integer> obj2=(number)->{System.out.println("object 2=> "+number);};
        obj2.accept(12);
        obj1.andThen(obj2).accept(12121);
    }
}
