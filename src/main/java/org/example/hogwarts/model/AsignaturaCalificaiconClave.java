package org.example.hogwarts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AsignaturaCalificaiconClave implements Serializable {
    
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

}
