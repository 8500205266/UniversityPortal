package com.example.demo.repository;

import com.example.demo.model.Portal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortalRepositry extends JpaRepository<Portal, Integer> {
   List<Portal> findByTeacherId(Integer id);
}
