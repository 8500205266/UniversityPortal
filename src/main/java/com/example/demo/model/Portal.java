package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Portal")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Portal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private Integer teacherId;

    @ElementCollection
    @CollectionTable(name="portal_course", joinColumns=@JoinColumn(name="teacherId"))
    @Column(name="courses")
    private List<Integer> courses=new ArrayList<Integer>();


    @NotNull
    private Integer departmentId;
    @NotNull
    private Integer courseId;



    //@OneToMany(ascade=CascadeType.ALL)
    //@NotNull
   // private List<Integer> courseId


}
