package org.example.hogwarts.service;

import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.mappers.EstudianteMapper;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private EstudianteMapper mapper;
    public List<EstudianteDTO> listarTodosEstudiantes() {
        List<Estudiante> estudiantes = repository.findAll();
        return estudiantes.stream()
                .map(mapper::toEstudianteDTO)
                .toList();
    }

}
