package com.predefined;

import java.util.Date;
import java.util.function.Supplier;

public class Supplier_interface
{
    public static void main(String [] args)
    {
        Supplier<Date> obj=()->new Date();
        System.out.println(obj.get());
        System.out.println(SupplierOldmethod.datefun());
    }
}
