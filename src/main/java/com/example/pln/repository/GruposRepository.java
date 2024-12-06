package com.example.pln.repository;

import com.example.pln.entity.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GruposRepository extends JpaRepository<Grupos,Integer > {
    
}
