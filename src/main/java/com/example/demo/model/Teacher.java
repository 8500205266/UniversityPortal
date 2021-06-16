package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teachertable")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tid",nullable = false)
    private int tid;
    private String tname;


    //
    @ManyToOne()
 //   @JoinColumn(name="did")
    private Department department;

    //
    @ManyToMany(targetEntity=Course.class, mappedBy="teacher",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> course;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }



    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", department=" + department +
                ", course=" + course +
                '}';
    }
}
