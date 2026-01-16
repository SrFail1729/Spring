package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casa;
    @Column(name = "nombre_casa")
    private String nombre_casa;
    private String fantasma;


    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Profesor> profesores;

    public Long getId_casa() {
        return id_casa;
    }

    public void setId_casa(Long id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombre_casa() {
        return nombre_casa;
    }

    public void setNombre_casa(String nombre_casa) {
        this.nombre_casa = nombre_casa;
    }

    public String getFantasma() {
        return fantasma;
    }

    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }


}
