package org.example.hogwarts.dto;

import org.example.hogwarts.model.Profesor;

import java.util.List;

public class CasaDTO {
    Long id;
    String nombre;
    String fundador;
    String fantasma;
    ProfesorDTO jefe;
    List<String> estudiantes;
}
