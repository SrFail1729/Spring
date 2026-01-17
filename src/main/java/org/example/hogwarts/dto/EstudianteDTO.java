package org.example.hogwarts.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EstudianteDTO {
    Long id;
    String nombre;
    LocalDate fechaNacimiento;
    String casa;
    MascotaDTO mascota;
    List<AsignaturaCalificacionDTO> asignatura;
}
