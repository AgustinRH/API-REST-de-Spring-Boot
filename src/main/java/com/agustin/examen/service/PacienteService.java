package com.agustin.examen.service;

import com.agustin.examen.dto.NewPacienteDTO;
import com.agustin.examen.error.PacienteNotFoundException;
import com.agustin.examen.model.Paciente;
import com.agustin.examen.repository.PacienteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteJpaRepository pacienteJpaRepository;

    public List<Paciente> findAll() {
        return pacienteJpaRepository.findAll();
    }

    public Paciente findById(Long id) {
        return pacienteJpaRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }

    public Paciente add(NewPacienteDTO dto) {
        Paciente nuevo = Paciente.builder()
                .nombre(dto.nombre())
                .antecedentes(dto.antecedentes())
                .build();
        return pacienteJpaRepository.save(nuevo);
    }

    public Paciente edit(NewPacienteDTO dto, Long id) {
        return pacienteJpaRepository.findById(id)
                .map(antiguo -> {
                    antiguo.setNombre(dto.nombre());
                    antiguo.setAntecedentes(dto.antecedentes());
                    return pacienteJpaRepository.save(antiguo);
                })
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }

    public void delete(Long id) {
        if (pacienteJpaRepository.existsById(id)) {
            pacienteJpaRepository.deleteById(id);
        } else {
            throw new PacienteNotFoundException(id);
        }
    }
}
