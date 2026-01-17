package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.AsignaturaCalificacionDTO;
import org.example.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDTO asignaturaDTOToAsignatura(Asignatura asignatura){

        AsignaturaCalificacionDTO asignaturaCalificacionDTO = new AsignaturaCalificacionDTO();
        asignaturaCalificacionDTO.setAsignatura(asignatura.getNombre());
        asignaturaCalificacionDTO.setCalificacion(0.0);

        return asignaturaCalificacionDTO;
    }
}
