package com.example.demo.repository;

import com.example.demo.model.Portal_course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Portal_courseRepositry extends JpaRepository<Portal_course,Integer>
{
    List<Portal_courseRepositry> findByTeacherId(int teacherId1);
}
