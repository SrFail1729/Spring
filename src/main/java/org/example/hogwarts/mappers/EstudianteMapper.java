package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EstudianteMapper {
    @Autowired
    private MascotaMapper mascotaMapper;

    @Autowired
    private AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    public EstudianteDTO toEstudianteDTO(Estudiante estudiante) {

        EstudianteDTO estudianteDTO = new EstudianteDTO();

        estudianteDTO.setId(estudiante.getId_estudiante());
        estudianteDTO.setNombre(estudiante.getNombre() +" "+ estudiante.getApellido());
        estudianteDTO.setFechaNacimiento(estudiante.getFecha_nacimiento());
        if (estudiante.getCasa() != null) {
            estudianteDTO.setCasa(estudiante.getCasa().getNombre());
        }
        if(estudiante.getMascota() != null) {
            estudianteDTO.setMascota(mascotaMapper.mascotaDTO(estudiante.getMascota()));
        }

        if (estudiante.getAsignaturas() != null) {
            estudianteDTO.setAsignatura(estudiante.getAsignaturas().stream()
                    .map(asignatura -> asignaturaCalificacionMapper.asignaturaDTOToAsignatura(asignatura))
                    .collect(Collectors.toList()));
        }
        return estudianteDTO;
    }
}
