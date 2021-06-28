package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TeacherAndCourses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeachercAndCourses
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int teacherId;
     private Integer courses;
}
