package org.example.hogwarts.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.create.EstudianteCreateDTO;
import org.example.hogwarts.dto.update.EstudianteUpdateDTO;
import org.example.hogwarts.mappers.EstudianteMapper;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    final private EstudianteRepository repository;

    final private EstudianteMapper mapper;

    public List<EstudianteDTO> listarTodosEstudiantes() {
        List<Estudiante> estudiantes = repository.findAll();
        return estudiantes.stream()
                .map(mapper::toEstudianteDTO)
                .toList();
    }

    public EstudianteDTO obtenerEstudianteConID(Long id){
        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        return mapper.toEstudianteDTO(estudiante);
    }

    @Transactional
    public EstudianteDTO crearEstudiante(EstudianteCreateDTO dto){
        Estudiante estudiante = mapper.toEntity(dto);

        if(estudiante.getMascota() != null){
            estudiante.getMascota().setEstudiante(estudiante);
        }
        Estudiante estudianteGuardado = repository.save(estudiante);
        return mapper.toEstudianteDTO(estudianteGuardado);
    }

    @Transactional
    public EstudianteDTO actualizarUsuario(Long id, EstudianteUpdateDTO dto){

        Estudiante estudianteExistente =  repository.findById(id)
                .orElseThrow(() ->new NoSuchElementException("Usuario no encontrado con id"));

        mapper.updateEntity(dto,estudianteExistente);
        Estudiante estudianteActualizado = repository.save(estudianteExistente);

        return mapper.toEstudianteDTO(estudianteActualizado);
    }

}
