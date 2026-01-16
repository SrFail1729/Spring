package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue
    private Long id_asignatura;
    private String nombre;
    private String aula;
    private Boolean obligatoria;

    @ManyToMany(mappedBy = "asignaturas")
    @JsonBackReference
    private List<Estudiante> estudiantes;

    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private Profesor profesor;

    public Long getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Boolean getObligatorio() {
        return obligatoria;
    }

    public void setObligatorio(Boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
