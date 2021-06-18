package com.javstreamBasics;

import java.util.Comparator;

public class EmpComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        return a.getAge() - b.getAge();
    }
}
