package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Portal_course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Portalcourses
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int teacherId;
     private Integer courses;
}
