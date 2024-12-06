package com.example.pln.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AlumnosDTO {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;
    private String nombre;
    private Integer edad;
    public AlumnosDTO(){
    super ();
    }

    public AlumnosDTO(Integer id_alumno, String nombre, Integer edad) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
}
