package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.ProfesorDTO;
import org.example.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDTO profesorDTO(Profesor profesor) {
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId_profesor());
        profesorDTO.setNombre(profesor.getNombre());
        if (profesor.getAsignatura() != null) {
            profesorDTO.setAsignatura(profesor.getAsignatura().getNombre());
        }
        profesorDTO.setFechaInicio(profesor.getFecha_inicio());
        return profesorDTO;
    }
}
