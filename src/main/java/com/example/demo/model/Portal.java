package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Portal")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Portal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer teacherId;
    private Integer departmentId;
    private Integer courseId;
}
