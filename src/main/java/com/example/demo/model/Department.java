package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departmenttable")
@NoArgsConstructor
@AllArgsConstructor
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did",nullable = false)
    private int did;

    @NotNull
    private String dname;


    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
