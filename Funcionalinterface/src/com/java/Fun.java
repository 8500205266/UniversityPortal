package com.java;

//@FunctionalInterface
interface parent
{
    int add(int a,int b);
}
class Fun
{
    public static void main(String args[])
    {
        parent p= (int a,int b)->a+b;
        System.out.println(p.add(11,22));
    }
}