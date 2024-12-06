/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pln.controller;

import com.example.pln.DTO.AlumnosDTO;
import com.example.pln.entity.Alumnos;
import com.example.pln.entity.Generos;
import com.example.pln.entity.Grupos;
import com.example.pln.service.ServiceAlumno;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class ControllerAlumnos {

    @Autowired
    private ServiceAlumno alumnosService;

    @GetMapping("/listarAlumnos")
    public ResponseEntity<List<Alumnos>> getAllAlumnos() {
        try {
            List<Alumnos> alumnos = alumnosService.ListAllAlumnos();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/guardarAlumnos")
    public ResponseEntity<Alumnos> createUsuario(@RequestBody Alumnos alumnos) {
        try {
            System.out.println("Alumno recibido: " + alumnos);
            Alumnos res = alumnosService.saveAlumnos(alumnos);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//********************** Generos ***************

    @GetMapping("/listarGeneros")
    public ResponseEntity<List<Generos>> getAllGeneros() {
        try {
            List<Generos> alumnos = alumnosService.ListAllGeneros();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/guardarGenero")
    public ResponseEntity<Generos> guardarGenero(@RequestBody Generos genero) {
        try {

            Generos res = alumnosService.saveGenero(genero);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //********************** Grupos ***************
    @GetMapping("/listarGrupos")
    public ResponseEntity<List<Grupos>> getAllGrupos() {
        try {
            List<Grupos> alumnos = alumnosService.ListAllGrupos();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/guardarGrupos")
    public ResponseEntity<Grupos> guardarGrupo(@RequestBody Grupos grupo) {
        try {

            Grupos res = alumnosService.saveGrupo(grupo);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //*********************** DTO **************
    @GetMapping("/listarAlumnosDTO")
    public ResponseEntity<List<AlumnosDTO>> getAllAlumnosDTO() {
        try {
            List<AlumnosDTO> alumnos = alumnosService.ListAlumnosDTO();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/guardarAlumnosDTO")
    public ResponseEntity<Alumnos> guardarAlumnosDTO(@RequestBody AlumnosDTO alumnos) {
        try {

            Alumnos res = alumnosService.saveAlumnosDTO(alumnos);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listarAlumnosObject")
    public ResponseEntity<List<Object>> getAllAlumnosObject() {
        try {
            List<Object> alumnos = alumnosService.ListAlumnosObjet();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
