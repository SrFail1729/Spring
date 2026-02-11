package org.example.hogwarts.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 25, min = 3, message = "El nombre debe estar entre 3 y 25 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Size(max = 25, min = 3, message = "El nombre debe estar entre 3 y 25 caracteres")
    private String apellido;

    @NotNull(message = "El curso es obligatorio")
    @Max(6)
    @Min(1)
    private int anyo;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha anterior")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotNull(message = "La casa es obligatoria")
    @Max(4)
    @Min(1)
    private int idCasa;

    @Valid
    private MascotaCreateDTO mascota;

}
