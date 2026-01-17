package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.MascotaDTO;
import org.example.hogwarts.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {
    public MascotaDTO mascotaDTO(Mascota mascota) {
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setId(mascota.getId_mascota());
        mascotaDTO.setNombre(mascota.getNombre());
        mascotaDTO.setEspecie(mascota.getEspecie());
        mascotaDTO.setEstudiante(mascota.getEstudiante().getNombre());
        return mascotaDTO;
    }
}
