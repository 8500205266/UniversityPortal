package com.example.demo.repository;

import com.example.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherlRepositry extends JpaRepository<Teacher, Integer>
{
    Optional<Teacher> findByTeacherId(Integer teacherId);

}
