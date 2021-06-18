package com.predefined;

import java.util.*;
import java.text.*;

public class SupplierOldmethod
{
    static Object datefun() {

        Date dNow = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));

        return dNow;
    }
}