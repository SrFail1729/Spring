package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue
    private Long id_asignatura;
    private String nombre;
    private String aula;
    private Boolean obligatoria;

    @OneToMany(mappedBy = "asignatura")
    @JsonBackReference
    private List<AsignaturaCalificacion> calificaciones;

    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private Profesor profesor;

}
