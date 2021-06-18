
package com.sortmethod;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator
{
    public static Employee newEmpGenerator()
    {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String name= new String(array, Charset.forName("UTF-8"));
        Random r=new Random();
        int id=r.nextInt(100);
      //  String name=r.toString();
        int salary=r.nextInt(2500000) + 15000;
        String phoneNumber=String.valueOf( (r.nextInt(900000)+1));
        int pincode=r.nextInt(612341230)+51324125;


        return new Employee(id,name,salary,phoneNumber,pincode);
    }
    public static void main(String[] args)
    {
        List<Employee> list=new ArrayList<>();
        for(int i=0;i<100;i++){
        list.add(newEmpGenerator());
    }
        list.stream().forEach(s-> System.out.println(s));
    }
}
