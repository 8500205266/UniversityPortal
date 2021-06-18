package com.sortmethod;

public class Employee implements Comparable<Employee>
{
    private int id;
    private String name;
    private  int salary;
    private String phoneNumber;
    private int  pincode;

    public Employee(int id, String name, int salary, String phoneNumber, int pincode) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumber=" + phoneNumber +
                ", pincode=" + pincode +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.pincode-o.getPincode();
    }
}
