package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;

    private String nombre;

    private String apellido;

    private Integer anyo_curso;

    private LocalDate fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    @JsonBackReference
    private Casa casa;

    @OneToOne(mappedBy = "estudiante",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Mascota mascota;

    @OneToMany(mappedBy = "estudiante")
    private List<AsignaturaCalificacion> calificaciones;

}
