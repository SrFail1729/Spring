package org.example.hogwarts.repositories;

import jakarta.persistence.EntityManager;
import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.EstudianteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class EstudianteRepositoryTestMem {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudianteYMascotaEnCascada(){

        Casa casa = new Casa();
        casa.setNombre("Gryffindor");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Test");
        estudiante.setApellido("Potter");
        estudiante.setCasa(casa);
        estudiante.setFechaNacimiento(LocalDate.of(1997, 9, 11));
        estudiante.setAnyoCurso(1);

        Mascota mascota = new Mascota();
        mascota.setNombre("Dobby");
        mascota.setEspecie("Elfo");

        estudiante.setMascota(mascota);
        mascota.setEstudiante(estudiante);

        Estudiante guardar = estudianteRepository.save(estudiante);
        Long idMascota = guardar.getMascota().getIdMascota();

        estudianteRepository.delete(guardar);
        estudianteRepository.flush();
        entityManager.clear();

        assertFalse(estudianteRepository.findById(guardar.getIdEstudiante()).isPresent());

        Mascota mascotaBD = entityManager.find(Mascota.class,idMascota);
        assertNull(mascotaBD,"Mascota borrada en cascada");
    }
}
