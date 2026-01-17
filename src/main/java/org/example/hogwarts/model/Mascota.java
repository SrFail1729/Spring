package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mascota;
    private String nombre;
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

}
