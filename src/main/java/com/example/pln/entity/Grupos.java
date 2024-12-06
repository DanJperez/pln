package com.example.pln.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "grupos")
public class Grupos implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_grupo;
    private String descripcion_grupo;
    private String turno;

    public Grupos() {

        super();
    }

    public Grupos(Integer id_grupo, String descripcion_grupo, String turno) {
        this.id_grupo = id_grupo;
        this.descripcion_grupo = descripcion_grupo;
        this.turno = turno;
    }

    public Integer getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Integer id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getDescripcion_grupo() {
        return descripcion_grupo;
    }

    public void setDescripcion_grupo(String descripcion_grupo) {
        this.descripcion_grupo = descripcion_grupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
}
