package org.example.hogwarts.mappers;

import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.create.EstudianteCreateDTO;
import org.example.hogwarts.dto.update.EstudianteUpdateDTO;
import org.example.hogwarts.model.AsignaturaCalificacion;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.CasaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EstudianteMapper {

    final private MascotaMapper mascotaMapper;

    final private CasaRepositoy casaRepositoy;

    final private AsignaturaCalificacionMapper asignaturaCalificacionMapper;

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

        if (estudiante.getCalificaciones() != null) {
            estudianteDTO.setAsignatura(estudiante.getCalificaciones().stream()
                    .map(AsignaturaCalificacion::getAsignatura)
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
        estudiante.setAnyo_curso(dto.getAnyo());
        estudiante.setCasa(casaRepositoy.getReferenceById((long) dto.getIdCasa()));
        estudiante.setFecha_nacimiento(dto.getFechaNacimiento());
        if(dto.getMascota() != null){
            estudiante.setMascota(mascotaMapper.toEntity(dto.getMascota()));
        }

        return estudiante;
    }

    public void updateEntity(EstudianteUpdateDTO dto, Estudiante estudiante){

        if (dto == null || estudiante == null ) return;

        if (dto.getAnyo() != null) {
            estudiante.setAnyo_curso(dto.getAnyo());
        }

        if (dto.getFechaNacimiento() != null) {
            estudiante.setFecha_nacimiento(dto.getFechaNacimiento());
        }

        if (dto.getIdCasa() != null) {
            Casa casa = casaRepositoy.findById(dto.getIdCasa().longValue())
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
