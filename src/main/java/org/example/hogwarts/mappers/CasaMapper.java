package org.example.hogwarts.mappers;

import org.example.hogwarts.dto.CasaDTO;
import org.example.hogwarts.model.Casa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CasaMapper {
    @Autowired
    private ProfesorMapper profesorMapper;

    public CasaDTO casaToCasaDTO(Casa casa) {
        CasaDTO casaDTO = new CasaDTO();
        casaDTO.setId(casaDTO.getId());
        casaDTO.setNombre(casa.getNombre());
        casaDTO.setFundador(casa.getFundador());
        casaDTO.setFantasma(casa.getFantasma());
        if (casa.getJefe() != null) {
            casaDTO.setJefe(profesorMapper.profesorDTO(casa.getJefe()));
        }
        if (casa.getEstudiantes() != null) {
            casaDTO.setEstudiantes(
                    casa.getEstudiantes().stream()
                            .map(estudiante -> estudiante.getNombre()+" "+estudiante.getApellido())
                            .toList()
            );
        }

        return casaDTO;
    }
}
