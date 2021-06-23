package com.example.demo.repository;

import com.example.demo.model.Department;
import com.example.demo.model.Portal;
import com.example.demo.model.Portal_course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortalRepositry extends JpaRepository<Portal, Integer>
{
    Optional<Portal> findByTeacherId(Integer teacherId);
}
