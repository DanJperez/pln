package com.example.pln.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "generos")
public class Generos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_genero;
    private String descripcion_genero;

    public Generos() {

        super();
    }

    public Generos(Integer id_genero, String descripcion_genero) {
        this.id_genero = id_genero;
        this.descripcion_genero = descripcion_genero;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getDescripcion_genero() {
        return descripcion_genero;
    }

    public void setDescripcion_genero(String descripcion_genero) {
        this.descripcion_genero = descripcion_genero;
    }
    

}
