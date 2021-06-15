package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="course")
@NoArgsConstructor
@AllArgsConstructor
public class Cource
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid", nullable = false)
    private int cid;
    private String cname;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Cource{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
