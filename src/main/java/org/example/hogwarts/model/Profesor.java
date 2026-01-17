package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;
    private String nombre;
    private String apellido;
    private LocalDate fecha_inicio;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference
    private Asignatura asignatura;

    @OneToOne(mappedBy = "jefe")
    @JsonBackReference
    private Casa casaJefe;
}
