package com.example.pln.repository;

import com.example.pln.DTO.AlumnosDTO;
import com.example.pln.entity.Alumnos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository <Alumnos, Integer> {
     @Query(value = "SELECT * FROM alumnos;", nativeQuery = true)
    List<Alumnos> findAllAlumnos();
    
    @Query(value="SELECT new com.example.pln.DTO.AlumnosDTO(id_alumno,nombre, edad) FROM Alumnos")
    List<AlumnosDTO> finAllAlumnosDTO();
    
    @Query(value="SELECT id_alumno,nombre,edad FROM alumnos",nativeQuery=true)
    List<Object> findAllAlumnosObject();
}
