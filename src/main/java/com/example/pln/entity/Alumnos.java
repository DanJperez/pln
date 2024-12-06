package com.example.pln.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Table(name = "alumnos")
@Entity
public class Alumnos implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer edad;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="genero_id",nullable=true)
    private Generos generos;
    
    public Alumnos(){
        super();
    }

    public Alumnos(Integer id_alumno, String nombre, String apellido_paterno, String apellido_materno, Integer edad, Generos generos) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.edad = edad;
        this.generos = generos;
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Generos getGeneros() {
        return generos;
    }

    public void setGeneros(Generos generos) {
        this.generos = generos;
    }

   
}