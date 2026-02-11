package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.AsignaturaDTO;
import org.example.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO asignatura(Asignatura asignatura) {

        AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
        asignaturaDTO.setId(asignatura.getIdAsignatura());
        asignaturaDTO.setNombre(asignatura.getNombre());
        asignaturaDTO.setAula(asignatura.getAula());
        asignaturaDTO.setObligatoria(asignatura.getObligatoria());
        asignaturaDTO.setProfesor(asignatura.getProfesor().getNombre());

        return asignaturaDTO;
    }
}
