package org.example.hogwarts.mappers;

import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.create.EstudianteCreateDTO;
import org.example.hogwarts.dto.update.EstudianteUpdateDTO;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.CasaRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EstudianteMapper {

    private final MascotaMapper mascotaMapper;

    private final CasaRepository casaRepository;

    private final AsignaturaCalificacionMapper asignaturaCalificacionMapper;

    public EstudianteDTO toEstudianteDTO(Estudiante estudiante) {

        EstudianteDTO estudianteDTO = new EstudianteDTO();

        estudianteDTO.setId(estudiante.getIdEstudiante());
        estudianteDTO.setNombre(estudiante.getNombre() +" "+ estudiante.getApellido());
        estudianteDTO.setFechaNacimiento(estudiante.getFechaNacimiento());
        if (estudiante.getCasa() != null) {
            estudianteDTO.setCasa(estudiante.getCasa().getNombre());
        }
        estudianteDTO.setMascota(mascotaMapper.mascotaDTO(estudiante.getMascota()));
        if (estudiante.getCalificaciones() != null) {
            estudianteDTO.setAsignatura(estudiante.getCalificaciones().stream()
                    .map(asignaturaCalificacionMapper::asignaturaDTOToAsignatura)
                    .collect(Collectors.toList()));
        }
        return estudianteDTO;
    }

    public Estudiante toEntity(EstudianteCreateDTO dto){

        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyoCurso(dto.getAnyo());
        estudiante.setCasa(casaRepository.getReferenceById((long) dto.getIdCasa()));
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        if(dto.getMascota() != null){
            estudiante.setMascota(mascotaMapper.toEntity(dto.getMascota()));
        }

        return estudiante;
    }

    public void updateEntity(EstudianteUpdateDTO dto, Estudiante estudiante){

        if (dto == null || estudiante == null ) return;

        if (dto.getAnyo() != null) {
            estudiante.setAnyoCurso(dto.getAnyo());
        }

        if (dto.getFechaNacimiento() != null) {
            estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        }

        if (dto.getIdCasa() != null) {
            Casa casa = casaRepository.findById(dto.getIdCasa().longValue())
                    .orElseThrow(() -> new RuntimeException("Casa no encontrada"));
            estudiante.setCasa(casa);
        }
        if(dto.getMascota() != null){
            Mascota mascota = mascotaMapper.toEntity(dto.getMascota());
            mascota.setEstudiante(estudiante);
            estudiante.setMascota(mascota);
        }

    }
}
