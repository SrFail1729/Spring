package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.ProfesorDTO;
import org.example.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO profesorDTO(Profesor profesor) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getIdProfesor());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setAsignatura(profesor.getAsignatura().getNombre());
        profesorDTO.setFechaInicio(profesor.getFechaInicio());
        return profesorDTO;
    }
}
