package com.company;

interface parent
{
    int add(int a,int b);
}
class Main implements parent
{
    public int add(int a,int b)
    {
        int sum=a+b;
        return sum;
    }
    public static void main(String args[]){
        parent obj = new Main();
        System.out.println(obj.add(11,22));
    }
}