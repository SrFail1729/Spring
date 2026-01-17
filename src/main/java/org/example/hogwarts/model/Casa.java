package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casa;
    private String nombre;
    private String fantasma;
    private String fundador;


    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    @JsonManagedReference
    private Profesor jefe;

}
