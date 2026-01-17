package org.example.hogwarts.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ProfesorDTO {
    Long id;
    String nombre;
    String asignatura;
    LocalDate fechaInicio;
}
