package org.example.hogwarts.service;

import org.example.hogwarts.model.Casa;
import org.example.hogwarts.model.Estudiante;
import org.example.hogwarts.model.Mascota;
import org.example.hogwarts.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    private Estudiante estudianteTest;


    @BeforeEach
    void setUp(){
        estudianteTest = new Estudiante();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombre("Test");
        estudianteTest.setAnyoCurso(1);
        estudianteTest.setFechaNacimiento(LocalDate.of(1997,9,27));
        estudianteTest.setCasa(new Casa());
        estudianteTest.setMascota(new Mascota());
    }

    @Test
    void eliminarEstudianteConMascotaExito(){
        Long id = 1L;

        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        estudianteService.eliminarEstudiante(id);

        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }

    @Test
    void eliminarEstudianteSinMascotaExito(){
        Long id = 1L;

        estudianteTest.setMascota(null);

        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudianteTest));

        estudianteService.eliminarEstudiante(id);

        verify(estudianteRepository, times(1)).delete(estudianteTest);
    }

}
