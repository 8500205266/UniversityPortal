package com.example.demo.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "did",nullable = false)
    private int did;
    private String dname;

    @OneToMany(targetEntity=Teacher.class, mappedBy="department",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    @OneToMany(targetEntity=Course.class, mappedBy="department",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> course;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

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
                ", teachers=" + teachers +
                ", course=" + course +
                '}';
    }
}
