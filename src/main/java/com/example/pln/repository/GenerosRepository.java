package com.example.pln.repository;

import com.example.pln.entity.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosRepository extends JpaRepository<Generos,Integer > {
    
}
