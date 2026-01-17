package org.example.hogwarts.dto;

import java.time.LocalDate;

public class EstudianteDTO {
    Long id;
    String nombre;
    LocalDate fechaNacimiento;
    String casa;
    MascotaDTO mascota;
    List<AsignaturaCalificacionDTO> asignatura;
}
