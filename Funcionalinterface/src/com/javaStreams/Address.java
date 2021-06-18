package com.javaStreams;

public class Address
{
    private int pincode;
    private String village_name;
    private String state;
    private int hnumber;

    public Address(int pincode, String village_name, String state, int hnumber) {
        this.pincode = pincode;
        this.village_name = village_name;
        this.state = state;
        this.hnumber = hnumber;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getHnumber() {
        return hnumber;
    }

    public void setHnumber(int hnumber) {
        this.hnumber = hnumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", village_name='" + village_name + '\'' +
                ", state='" + state + '\'' +
                ", hnumber=" + hnumber +
                '}';
    }
}
