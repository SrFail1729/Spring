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
    @JoinColumn(name = "id_estudiante")
    Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura",
            foreignKey = @ForeignKey(name = "FK_ASIGNATURA_CALIFICACION", foreignKeyDefinition = "FOREIGN KEY (id_asignatura) REFERENCES asignatura(id_asignatura) ON DELETE RESTRICT"))
    Asignatura asignatura;

    @Column(name = "calificacion")
    private Double calificacion;

}
