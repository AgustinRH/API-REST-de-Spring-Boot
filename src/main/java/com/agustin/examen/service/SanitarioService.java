package com.agustin.examen.service;

import com.agustin.examen.dto.NewSanitarioDTO;
import com.agustin.examen.error.SanitarioNotFoundException; // Tu excepción
import com.agustin.examen.model.Sanitario;
import com.agustin.examen.repository.SanitarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanitarioService {

    private final SanitarioJpaRepository sanitarioJpaRepository;

    public List<Sanitario> findAll() {
        return sanitarioJpaRepository.findAll();
    }

    public Sanitario findById(Long id) {
        // Si no lo encuentra, lanza TU excepción
        return sanitarioJpaRepository.findById(id)
                .orElseThrow(() -> new SanitarioNotFoundException(id));
    }

    public Sanitario add(NewSanitarioDTO dto) {
        Sanitario nuevo = Sanitario.builder()
                .nombre(dto.nombre())
                .especialidad(dto.especialidad())
                .build();
        return sanitarioJpaRepository.save(nuevo);
    }

    public Sanitario edit(NewSanitarioDTO dto, Long id) {
        return sanitarioJpaRepository.findById(id)
                .map(antiguo -> {
                    antiguo.setNombre(dto.nombre());
                    antiguo.setEspecialidad(dto.especialidad());
                    return sanitarioJpaRepository.save(antiguo);
                })
                .orElseThrow(() -> new SanitarioNotFoundException(id)); // Lanza excepción
    }

    public void delete(Long id) {
        if (sanitarioJpaRepository.existsById(id)) {
            sanitarioJpaRepository.deleteById(id);
        } else {
            throw new SanitarioNotFoundException(id); // Lanza excepción
        }
    }
}