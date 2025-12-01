package com.agustin.examen.controller;

import com.agustin.examen.dto.NewPacienteDTO;
import com.agustin.examen.model.Paciente;
import com.agustin.examen.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    // Obtener todos los pacientes
    @GetMapping
    public List<Paciente> getAll() {
        return pacienteService.findAll();
    }

    // Obtener un paciente por id
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody NewPacienteDTO dto) {
        Paciente paciente = pacienteService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    }

    // Editar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody NewPacienteDTO dto) {
        try {
            Paciente actualizado = pacienteService.edit(dto, id);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Borrar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
