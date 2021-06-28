package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name="departmenttable")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did",nullable = false)
    private int did;
    private String dname;
}
