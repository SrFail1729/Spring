package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.AsignaturaCalificacionDTO;
import org.example.hogwarts.model.AsignaturaCalificacion;
import org.springframework.stereotype.Component;

@Component

public class AsignaturaCalificacionMapper {

    public AsignaturaCalificacionDTO asignaturaDTOToAsignatura(AsignaturaCalificacion calificacion){

        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setNombre(calificacion.getAsignatura().getNombre());
        dto.setCalificacion(calificacion.getCalificacion());

        return dto;
    }
}
