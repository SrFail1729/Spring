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
    Integer anyo;
    MascotaDTO mascota;
    List<AsignaturaCalificacionDTO> asignatura;
}
