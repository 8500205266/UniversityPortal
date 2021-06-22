package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Portal_course extends JpaRepository<com.example.demo.model.Portal_course,Integer>
{


    List<Portal_course> findByTeacherId(int teacherId1);
}
