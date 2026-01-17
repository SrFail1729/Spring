package org.example.hogwarts.dto;

import lombok.Data;

@Data
public class AsignaturaDTO {
    Long id;
    String nombre;
    String aula;
    Boolean obligatoria;
    String profesor;
}
