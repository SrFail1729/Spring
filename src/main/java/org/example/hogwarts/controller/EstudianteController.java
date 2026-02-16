package org.example.hogwarts.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.create.EstudianteCreateDTO;
import org.example.hogwarts.dto.update.EstudianteUpdateDTO;
import org.example.hogwarts.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService service;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> getAll(){
        List<EstudianteDTO> estudiantes = service.listarTodosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO dto){
        EstudianteDTO estudianteCreado = service.crearEstudiante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody EstudianteUpdateDTO dto){
        EstudianteDTO estudianteAcualizado = service.actualizarEstudiante(id,dto);
        return ResponseEntity.ok(estudianteAcualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id){
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/setNull/{id}")
    public ResponseEntity<Void> eliminarEstudianteSetNullEstudiante(@PathVariable Long id){
        service.eliminarEstudianteSetNull(id);
        return ResponseEntity.noContent().build();
    }

}
