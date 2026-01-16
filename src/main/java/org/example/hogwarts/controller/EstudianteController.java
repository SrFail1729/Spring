package org.example.hogwarts.controller;

import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> findAll(){
        List<Estudiante> estudiantes = service.listarTodosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }
}
