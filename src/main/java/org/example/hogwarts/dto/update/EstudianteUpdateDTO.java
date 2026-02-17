package org.example.hogwarts.dto.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.example.hogwarts.dto.create.MascotaCreateDTO;

import java.time.LocalDate;

@Data
public class EstudianteUpdateDTO {

    @Max(6)
    @Min(1)
    private Integer anyo;

    @Max(4)
    @Min(1)
    private Integer idCasa;

    @Past(message = "La fecha de nacimiento debe ser una fecha anterior")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Nullable
    @Valid
    private MascotaCreateDTO mascota;
}
