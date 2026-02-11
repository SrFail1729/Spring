package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@Table(name="Estudiante_Asignatura")
@NoArgsConstructor
public class AsignaturaCalificacion {

    @EmbeddedId
    AsignaturaCalificaiconClave id;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante" ,referencedColumnName = "id_estudiante")
    Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura" ,referencedColumnName = "id_asignatura")
    Asignatura asignatura;

    @Column(name = "calificacion")
    private double calificacion;

}
