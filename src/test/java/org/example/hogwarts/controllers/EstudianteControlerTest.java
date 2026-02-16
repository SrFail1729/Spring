package org.example.hogwarts.controllers;

import org.example.hogwarts.controller.EstudianteController;
import org.example.hogwarts.dto.EstudianteDTO;
import org.example.hogwarts.dto.create.EstudianteCreateDTO;
import org.example.hogwarts.dto.create.MascotaCreateDTO;
import org.example.hogwarts.dto.update.EstudianteUpdateDTO;
import org.example.hogwarts.service.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(EstudianteController.class)
class EstudianteControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EstudianteService estudianteService;

    ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

    private EstudianteCreateDTO estudianteCreateDTO;
    private EstudianteUpdateDTO estudianteUpdateDTO;
    private EstudianteDTO estudianteResponseDTO;

    @BeforeEach
    void setUp(){

        MascotaCreateDTO mascotaCreateDTO = new MascotaCreateDTO();
        mascotaCreateDTO.setNombre("MascotaTest");
        mascotaCreateDTO.setEspecie("Test");

        estudianteCreateDTO = new EstudianteCreateDTO();
        estudianteCreateDTO.setNombre("Test");
        estudianteCreateDTO.setApellido("Potter");
        estudianteCreateDTO.setAnyo(4);
        estudianteCreateDTO.setIdCasa(2);
        estudianteCreateDTO.setFechaNacimiento(LocalDate.of(1983, 11, 4));
        estudianteCreateDTO.setMascota(mascotaCreateDTO);

        estudianteResponseDTO = new EstudianteDTO();
        estudianteResponseDTO.setId(1L);
        estudianteResponseDTO.setNombre("Test Potter");
        estudianteResponseDTO.setCasa("Hufflepuff");
        estudianteResponseDTO.setAnyo(1);

        estudianteUpdateDTO = new EstudianteUpdateDTO();
        estudianteUpdateDTO.setAnyo(3);
        estudianteUpdateDTO.setMascota(null);

    }

    @Test
    void crearEstudianteConMascota()throws Exception{

        when(estudianteService.crearEstudiante(any(EstudianteCreateDTO.class))).thenReturn(estudianteResponseDTO);

        mockMvc.perform(post("/hogwarts/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Test Potter"));

        verify(estudianteService).crearEstudiante(any(EstudianteCreateDTO.class));
    }

    @Test
    void crearEstudianteMascotaInvalida()throws Exception{

        estudianteCreateDTO.getMascota().setEspecie("");

        mockMvc.perform(post("/hogwarts/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isBadRequest());

        verify(estudianteService, never()).crearEstudiante(any());
    }

    @Test
    void actualizarEstudiante()throws Exception{

        estudianteResponseDTO.setAnyo(3);
        estudianteResponseDTO.setMascota(null);

        when(estudianteService.actualizarEstudiante(eq(1L), any(EstudianteUpdateDTO.class)))
                .thenReturn(estudianteResponseDTO);

        mockMvc.perform(put("/hogwarts/estudiantes/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteUpdateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.anyo").value(3))
                .andExpect(jsonPath("$.mascota").value(nullValue()));

        verify(estudianteService).actualizarEstudiante(eq(1L), any(EstudianteUpdateDTO.class));
    }

    @Test
    void eliminarEstudiante() throws Exception{

        doNothing().when(estudianteService).eliminarEstudiante(1L);

        mockMvc.perform(delete("/hogwarts/estudiantes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void crearEstudianteAnyoInvalido() throws Exception{

        estudianteCreateDTO.setAnyo(10);

        mockMvc.perform(post("/hogwarts/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteCreateDTO)))
                .andExpect(status().isBadRequest());

        verify(estudianteService, never()).crearEstudiante(any());
    }

    @Test
    void eliminarAsignaturaConAlumnosDaConfilicto()throws Exception{


        doThrow(new ResponseStatusException(HttpStatus.CONFLICT))
                .when(estudianteService).eliminarEstudiante(1L);

        mockMvc.perform(delete("/hogwarts/estudiantes/1"))
                .andExpect(status().isConflict());

        verify(estudianteService).eliminarEstudiante(1L);
    }
}
