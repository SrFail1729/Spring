package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @OneToOne(mappedBy = "estudiante")
    @JsonManagedReference
    private Mascota mascota;

    @ManyToMany
    @JoinTable(
            name = "Estudiante_Asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    @JsonManagedReference
    private List<Asignatura> asignaturas;


    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getAnyo_curso() {
        return anyo_curso;
    }

    public void setAnyo_curso(Integer anyo_curso) {
        this.anyo_curso = anyo_curso;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
