package com.example.pln.service;


import com.example.pln.DTO.AlumnosDTO;
import com.example.pln.entity.Alumnos;
import com.example.pln.entity.Generos;
import com.example.pln.entity.Grupos;
import java.util.List;

public interface ServiceAlumno {

    //SERVICIO PARA LISTAR A TODOS LOS ALUMNOS
    public List<Alumnos> ListAllAlumnos();

    //SERVICIO PARA GUARDAR ALUMNOS
    public Alumnos saveAlumnos(Alumnos alumnos);

    public Alumnos findOneAlumno(Integer id_alumno);

    //************** Generos ***************
    public List<Generos> ListAllGeneros();
    public Generos saveGenero(Generos genero);
    //************** Grupos *******************
    public List<Grupos> ListAllGrupos();
    public Grupos saveGrupo(Grupos grupo);
    //************** DTO *********************
    public List<AlumnosDTO>ListAlumnosDTO();
    public Alumnos saveAlumnosDTO(AlumnosDTO alumnos);
    public List<Object> ListAlumnosObjet();

}
