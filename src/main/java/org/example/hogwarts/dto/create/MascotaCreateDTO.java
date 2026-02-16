package org.example.hogwarts.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MascotaCreateDTO {

    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    @Size(min = 2, max = 25, message = "El nombre de la mascota debe estar entre 2 y 25 caracteres")
    private String nombre;

    @NotBlank(message = "La mascota debe tener una especie")
    @Size(min = 3, max = 25, message = "La especie debe estar entre 3 y 25 caracteres")
    private String especie;
}
