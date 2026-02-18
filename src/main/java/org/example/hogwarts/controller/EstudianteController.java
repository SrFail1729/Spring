package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "No se encuentran los alumnos"),
            @ApiResponse(responseCode = "500", description = "Error interno en el server")
    })
    @GetMapping
    @Operation(summary = "Lista todos los alumnos")
    public ResponseEntity<List<EstudianteDTO>> getAll(){
        List<EstudianteDTO> estudiantes = service.listarTodosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "400", description = "ID de alumno invalida"),
            @ApiResponse(responseCode = "404", description = "Alumno no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno en el server")
    })
    @PostMapping
    @Operation(summary = "Crea un alumno")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteCreateDTO dto){
        EstudianteDTO estudianteCreado = service.crearEstudiante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "400", description = "ID de alumno invalida"),
            @ApiResponse(responseCode = "404", description = "Alumno no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno en el server")
    })
    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un alumno")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @Valid @RequestBody EstudianteUpdateDTO dto){
        EstudianteDTO estudianteAcualizado = service.actualizarEstudiante(id,dto);
        return ResponseEntity.ok(estudianteAcualizado);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "400", description = "ID de alumno invalida"),
            @ApiResponse(responseCode = "404", description = "Alumno no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno en el server")
    })
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminina un usuario por su ID")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id){
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/setNull/{id}")
    @Operation(summary = "Hace un borrado logico del usuario por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "400", description = "ID de alumno invalida"),
            @ApiResponse(responseCode = "404", description = "Alumno no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno en el server")
    })
    public ResponseEntity<Void> eliminarEstudianteSetNullEstudiante(@PathVariable Long id){
        service.eliminarEstudianteSetNull(id);
        return ResponseEntity.noContent().build();
    }

}
