package com.sortmethod;

import java.util.*;
import java.util.stream.Stream;

public class SortMethod {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Prashanth", 30000, "8500305266", 502111));
        employeeList.add(new Employee(2, "Paul Niksui", 25000, "9493345691", 502112));
        employeeList.add(new Employee(3, "Martin Theron", 2119, "9493345342", 502113));
        employeeList.add(new Employee(4, "Murali Gowda", 2800, "9493322333", 502114));
        employeeList.add(new Employee(5, "Nima Roy", 27000, "9493348894", 502115));
        employeeList.add(new Employee(6, "Iqbal Hussain", 4329, "9493345695", 502116));
        employeeList.add(new Employee(7, "Manu Sharma", 35233, "9493345696", 502117));
        employeeList.add(new Employee(8, "Wang Liu", 31331, "9493345697", 502118));
        employeeList.add(new Employee(9, "Amelia Zoe", 24123, "9493345698", 502119));
        employeeList.add(new Employee(10, "Jaden Dough", 385677, "9493345699", 502110));
        employeeList.add(new Employee(11, "Jasna Kaur", 279999, "94933456910", 512111));
        employeeList.add(new Employee(12, "Nitin Joshi", 25666, "9493345611", 512112));
        employeeList.add(new Employee(13, "Jyothi Reddy", 275645, "9493345612", 512113));
        employeeList.add(new Employee(14, "Nicolus Den", 24565, "9493345613", 512114));
        employeeList.add(new Employee(15, "Ali Baig", 23000, "9493345614", 512115));
        employeeList.add(new Employee(16, "Sanvi Pandey", 26000, "9493345615", 512116));
        employeeList.add(new Employee(17, "Anuj Chettiar", 3199494, "9493345616", 512117));


        employeeList.add(new Employee(18, "raju", 31000, "8500305266", 512111));
        employeeList.add(new Employee(19, "ravi", 24000, "9193345691", 522112));
        employeeList.add(new Employee(20, "venky", 24119, "9293345342", 532113));
        employeeList.add(new Employee(21, "vijay", 28040, "9293322333", 542114));
        employeeList.add(new Employee(22, "maruti", 270600, "9593348894", 552115));
        employeeList.add(new Employee(23, "prabu", 43279, "9693345695", 562116));
        employeeList.add(new Employee(24, "pavan", 352373, "9793345696", 572117));
        employeeList.add(new Employee(25, "mahesh", 31301, "9893345697", 582118));
        employeeList.add(new Employee(26, "rana", 241230, "9993345698", 592119));
        employeeList.add(new Employee(27, "virat", 3856787, "9103345699", 510110));
        employeeList.add(new Employee(28, "rajesh", 2799, "91133456910", 511111));
        employeeList.add(new Employee(29, "nitin", 2566, "9123345611", 512012));
        employeeList.add(new Employee(30, "Jyothi Reddy", 2645, "9133345612", 500113));
        employeeList.add(new Employee(31, "anil", 24599, "9143345613", 512874));
        employeeList.add(new Employee(32, "Alia", 23080, "9153345614", 512785));
        employeeList.add(new Employee(33, "Pandey", 286000, "9163345615", 516416));
        employeeList.add(new Employee(34, "Chettiar", 399494, "9173345616", 514517));


        employeeList.add(new Employee(35, "Prashanth", 30000, "8501105266", 502111));
        employeeList.add(new Employee(36, "raju", 25000, "9013345691", 502132));
        employeeList.add(new Employee(37, "milan", 2119, "9023345342", 502143));
        employeeList.add(new Employee(38, "Murali ", 2800, "9033322333", 502154));
        employeeList.add(new Employee(39, "Roy", 27000, "9043348894", 502175));
        employeeList.add(new Employee(40, "Hussain", 4329, "9053345695", 502136));
        employeeList.add(new Employee(41, "Sharma", 35233, "9063345696", 502127));
        employeeList.add(new Employee(42, "Wang", 31331, "9073345697", 502138));
        employeeList.add(new Employee(43, "Amelia", 24123, "9083345698", 502519));
        employeeList.add(new Employee(44, "Dough", 385677, "9093345699", 502110));
        employeeList.add(new Employee(45, "Jasna", 279999, "91033456910", 512511));
        employeeList.add(new Employee(46, "Joshi", 25666, "9113345611", 512782));
        employeeList.add(new Employee(47, "sina Reddy", 275645, "9412345612", 502113));
        employeeList.add(new Employee(48, "Nicolus", 24565, "9133345613", 516114));
        employeeList.add(new Employee(49, "Ali ", 23000, "9143345614", 519115));
        employeeList.add(new Employee(50, "Sanvi", 26000, "9153345615", 512776));
        employeeList.add(new Employee(51, "Anuj Chettiar", 3199494, "9163345616", 512117));


        employeeList.add(new Employee(52, "raju", 30000, "8500005266", 512131));
        employeeList.add(new Employee(53, "ravi", 20000, "8003345691", 522142));
        employeeList.add(new Employee(54, "venky", 20119, "8113345342", 534113));
        employeeList.add(new Employee(55, "vijay", 29040, "8223322333", 542514));
        employeeList.add(new Employee(56, "maruti", 20600, "8123348894", 556115));
        employeeList.add(new Employee(57, "prabu", 3279, "8695545695", 562716));
        employeeList.add(new Employee(58, "pavan", 52373, "8788345696", 572717));
        employeeList.add(new Employee(59, "mahesh", 1301, "8899345697", 582818));
        employeeList.add(new Employee(60, "rana", 2230, "8993399698", 592619));
        employeeList.add(new Employee(61, "virat", 56787, "8103455699", 510710));
        employeeList.add(new Employee(62, "rajesh", 82799, "81155456910", 515111));
        employeeList.add(new Employee(63, "nitin", 82566, "8123378611", 512052));
        employeeList.add(new Employee(64, "Jyothi Reddy", 82645, "8167345612", 550113));
        employeeList.add(new Employee(65, "anil", 74599, "8143348713", 512274));
        employeeList.add(new Employee(66, "Alia", 773080, "8153359614", 513785));
        employeeList.add(new Employee(67, "Pandey", 7286000, "8453345615", 526416));
        employeeList.add(new Employee(68, "Chettiar", 3979494, "8178345616", 594517));


        employeeList.add(new Employee(69, "raju", 30000, "8500005266", 512100));
        employeeList.add(new Employee(70, "ravi", 20000, "8003345691", 5221101));
        employeeList.add(new Employee(71, "venky", 20119, "8113345342", 534200));
        employeeList.add(new Employee(72, "vijay", 29040, "8223322333", 5425300));
        employeeList.add(new Employee(73, "maruti", 20600, "8123348894", 556400));
        employeeList.add(new Employee(74, "prabu", 3279, "8695545695", 5627500));
        employeeList.add(new Employee(75, "pavan", 52373, "8788345696", 5727600));
        employeeList.add(new Employee(76, "mahesh", 1301, "8899345697", 582700));
        employeeList.add(new Employee(77, "rana", 2230, "8993399698", 592800));
        employeeList.add(new Employee(78, "virat", 56787, "8103455699", 510900));
        employeeList.add(new Employee(79, "rajesh", 82799, "81155456910", 515000));
        employeeList.add(new Employee(80, "nitin", 82566, "8123378611", 512111));
        employeeList.add(new Employee(81, "Jyothi Reddy", 82645, "8167345612", 550888));
        employeeList.add(new Employee(82, "anil", 74599, "8143348713", 513999));
        employeeList.add(new Employee(83, "Alia", 773080, "8153359614", 513333));
        employeeList.add(new Employee(84, "Pandey", 7286000, "8453345615", 526555));
        employeeList.add(new Employee(85, "Chettiar", 3979494, "8178345616", 594777));
        employeeList.add(new Employee(86, "pavan", 52373, "8788345696", 572001));
        employeeList.add(new Employee(87, "mahesh", 1301, "8899345697", 582002));
        employeeList.add(new Employee(88, "rana", 2230, "8993399698", 592003));
        employeeList.add(new Employee(90, "virat", 56787, "8103455699", 510560));
        employeeList.add(new Employee(91, "rajesh", 82799, "81155456910", 515111));
        employeeList.add(new Employee(92, "nitin", 82566, "8123378611", 512052));
        employeeList.add(new Employee(93, "Jyothi Reddy", 82645, "8167345612", 550113));
        employeeList.add(new Employee(94, "anil", 74599, "8143348713", 512274));
        employeeList.add(new Employee(95, "Alia", 773080, "8153359614", 513785));
        employeeList.add(new Employee(96, "Pandey", 7286000, "8453345615", 526416));
        employeeList.add(new Employee(97, "Chettiar", 3979494, "8178345616", 594517));
        employeeList.add(new Employee(98, "Jyothi Reddy", 82645, "8167345612", 550113));
        employeeList.add(new Employee(99, "anil", 74599, "8143348713", 512274));
        employeeList.add(new Employee(100, "Alia", 773080, "8153359614", 513785));

        System.out.println("Before sorting the List");
        employeeList.forEach(s -> System.out.println(s));

        final Stream<Employee> sortedEmployeeList = employeeList.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (o1.getName() + o1.getPincode()).compareTo(o2.getName() + o2.getPincode());
            }
        });

        System.out.println("After sorting name and pincode the List  ");
        sortedEmployeeList.forEach(System.out::println);

        // prashanh12345       Aaamer1000
        // praveen 500018  prakash 500018
        List<Employee> list1= Arrays.asList(
                new Employee(2,"praveen",20050,"182925555",500019),
                new Employee(1,"praveen",2000,"182928282",500017)

                );
        System.out.println("new result");
        list1.stream(). sorted(new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int e = o1.getName().compareTo(o2.getName()); // -1
                if (e != 0)
                {
                    return e;
                }
                else
                {
                    return Integer.compare(o1.getPincode(), o2.getPincode());
                }
            }
        }).forEach(System.out::println);


      /*  final Stream<Employee> sortedEmployeeList2 = employeeList.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (o1.getName() + o1.getPincode() + o1.getSalary()).compareTo(o2.getName() + o2.getPincode() + o1.getSalary());
            }
        });
        System.out.println("After sorting name and pincode and salarythe List  ");
        sortedEmployeeList2.forEach(System.out::println);*/


        System.out.println("sort the list based upon name and using comparable");
        Collections.sort(employeeList);
        employeeList.forEach(s-> System.out.println(s));

        System.out.println("sort list based upon on name and salary and pincode ");
        employeeList.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                int p = o1.getName().compareTo(o2.getName());
                if (p != 0)
                {
                    return p;
                }
                else
                {
                    int k = Integer.compare(o1.getSalary(), o2.getSalary());
                    if(k!=0)
                    {
                        return k;
                    }
                    else
                    {
                        return Integer.compare(o1.getPincode(), o2.getPincode());
                    }
                }
            }
        }).forEach(s-> System.out.println(s));

        List<Employee> listResult1= Arrays.asList(
                new Employee(1,"prAZen",20050,"182925555",500019),
                new Employee(2,"prAveEen",2000,"182928282",500017)

        );

        final Comparator<Employee> EmpResult = Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getPincode);
        Collections.sort(listResult1,EmpResult);
        System.out.println("Final Result/n");
        listResult1.forEach(s-> System.out.println(s));

        List<Employee> listResult= Arrays.asList(
                new Employee(1,"prASZeen",20050,"182925555",500019),
                new Employee(2,"prACAeen",2000,"182928282",500017)

        );

        final Comparator<Employee> EmpResult1= Comparator.comparing(Employee::getName,String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getPincode);
        Collections.sort(listResult,EmpResult1);
        System.out.println("Final Result/n");
        listResult.forEach(s-> System.out.println(s));


    }
}

