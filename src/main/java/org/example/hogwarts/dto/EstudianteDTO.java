package org.example.hogwarts.dto;

import java.time.LocalDate;
import java.util.List;

public class EstudianteDTO {
    Long id;
    String nombre;
    LocalDate fechaNacimiento;
    String casa;
    MascotaDTO mascota;
    List<AsignaturaCalificacionDTO> asignatura;
}
