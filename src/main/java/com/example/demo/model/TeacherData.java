package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PortalIn
{

    private Integer id;
    private String name;
    private Integer teacherId;
    @ElementCollection
    @CollectionTable(name="portal_course", joinColumns=@JoinColumn(name="teacherId"))
    @Column(name="courses")
    private List<Integer> courses=new ArrayList<>();
    private Integer departmentId;

}