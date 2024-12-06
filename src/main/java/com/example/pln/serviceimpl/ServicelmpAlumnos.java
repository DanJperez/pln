package com.example.pln.serviceimpl;

import com.example.pln.DTO.AlumnosDTO;
import com.example.pln.entity.Alumnos;
import com.example.pln.entity.Generos;
import com.example.pln.entity.Grupos;
import com.example.pln.repository.AlumnosRepository;
import com.example.pln.repository.GenerosRepository;
import com.example.pln.repository.GruposRepository;
import com.example.pln.service.ServiceAlumno;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicelmpAlumnos implements ServiceAlumno {

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Override
    public List<Alumnos> ListAllAlumnos() {
        return alumnosRepository.findAllAlumnos();
    }
    @Autowired
    private GenerosRepository generosRepository;
    @Autowired
    private GruposRepository gruposRepository;

    @Override
    public Alumnos saveAlumnos(Alumnos alumnos) {
        Alumnos a = new Alumnos();

        a.setNombre(alumnos.getNombre());
        a.setApellido_paterno(alumnos.getApellido_paterno());
        a.setApellido_materno(alumnos.getApellido_materno());
        a.setEdad(alumnos.getEdad());

        // Asegúrate de no sobrescribir
        a.setGeneros(alumnos.getGeneros());

        return alumnosRepository.save(a);
    }

    @Override
    public Alumnos findOneAlumno(Integer id_alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @return
     */
    @Override
    public List<Generos> ListAllGeneros() {
        return generosRepository.findAll();
    }

    @Override
    public Generos saveGenero(Generos genero) {

        Generos g = new Generos();
        g.setDescripcion_genero(genero.getDescripcion_genero());
        return generosRepository.save(g);
    }
    //************** Grupos *******************

    @Override
    public List<Grupos> ListAllGrupos() {
        return gruposRepository.findAll();
    }

    @Override
    public Grupos saveGrupo(Grupos grupo) {
        Grupos g = new Grupos();
        g.setDescripcion_grupo(grupo.getDescripcion_grupo());
        g.setTurno(grupo.getTurno());
        return gruposRepository.save(g);
    }

    @Override
    public List<AlumnosDTO> ListAlumnosDTO() {
        return alumnosRepository.finAllAlumnosDTO();
    }

    @Override
    public Alumnos saveAlumnosDTO(AlumnosDTO alumnos) {
        Alumnos a = new Alumnos();
        a.setNombre(alumnos.getNombre());
        a.setEdad(alumnos.getEdad());
        return alumnosRepository.save(a);
    }

    @Override
    public List<Object> ListAlumnosObjet() {             
        return alumnosRepository.findAllAlumnosObject();
        
    }

}
