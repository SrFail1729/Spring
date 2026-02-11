package org.example.hogwarts.dto;

import lombok.Data;
import java.util.List;

@Data
public class CasaDTO {
    Long id;
    String nombre;
    String fundador;
    String fantasma;
    ProfesorDTO jefe;
    List<String> estudiantes;
}
