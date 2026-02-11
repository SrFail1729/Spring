package org.example.hogwarts.mappers;

import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dto.AsignaturaCalificacionDTO;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AsignaturaCalificacionMapper {

    public AsignaturaCalificacionDTO asignaturaDTOToAsignatura(Asignatura asignatura){

        AsignaturaCalificacionDTO asignaturaCalificacionDTO = new AsignaturaCalificacionDTO();
        asignaturaCalificacionDTO.setCalificacion(asignaturaCalificacionDTO.getCalificacion());

        return asignaturaCalificacionDTO;
    }
}
