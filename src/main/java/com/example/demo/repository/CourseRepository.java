package com.example.demo.repository;

import com.example.demo.model.Cource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Cource,Integer>
{
}
