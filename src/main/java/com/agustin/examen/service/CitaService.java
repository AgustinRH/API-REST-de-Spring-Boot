package com.agustin.examen.service;

import com.agustin.examen.dto.NewCitaDTO;
import com.agustin.examen.error.CitaNotFoundException;
import com.agustin.examen.model.Cita;
import com.agustin.examen.model.Paciente;
import com.agustin.examen.model.Sanitario;
import com.agustin.examen.repository.CitaJpaRepository;
import com.agustin.examen.repository.PacienteJpaRepository;
import com.agustin.examen.repository.SanitarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaJpaRepository citaJpaRepository;
    private final PacienteJpaRepository pacienteJpaRepository;
    private final SanitarioJpaRepository sanitarioJpaRepository;

    public List<Cita> findAll() {
        return citaJpaRepository.findAll();
    }

    public Cita findById(Long id) {
        return citaJpaRepository.findById(id)
                .orElseThrow(() -> new CitaNotFoundException(id));
    }

    public Cita add(NewCitaDTO dto) {
        Paciente paciente = pacienteJpaRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        List<Sanitario> sanitarios = dto.sanitariosIds().stream()
                .map(id -> sanitarioJpaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Sanitario no encontrado con id: " + id)))
                .collect(Collectors.toList());

        Cita nueva = Cita.builder()
                .fechaHora(dto.fechaHora())
                .sintomas(dto.sintomas())
                .paciente(paciente)
                .sanitarios(sanitarios)
                .build();

        return citaJpaRepository.save(nueva);
    }

    public Cita edit(NewCitaDTO dto, Long id) {
        return citaJpaRepository.findById(id)
                .map(cita -> {
                    Paciente paciente = pacienteJpaRepository.findById(dto.pacienteId())
                            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

                    List<Sanitario> sanitarios = dto.sanitariosIds().stream()
                            .map(sid -> sanitarioJpaRepository.findById(sid)
                                    .orElseThrow(() -> new RuntimeException("Sanitario no encontrado con id: " + sid)))
                            .collect(Collectors.toList());

                    cita.setFechaHora(dto.fechaHora());
                    cita.setSintomas(dto.sintomas());
                    cita.setPaciente(paciente);
                    cita.setSanitarios(sanitarios);

                    return citaJpaRepository.save(cita);
                })
                .orElseThrow(() -> new CitaNotFoundException(id));
    }

    public void delete(Long id) {
        if (citaJpaRepository.existsById(id)) {
            citaJpaRepository.deleteById(id);
        } else {
            throw new CitaNotFoundException(id);
        }
    }
}
