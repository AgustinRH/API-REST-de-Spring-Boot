package com.agustin.examen.controller;

import com.agustin.examen.dto.NewSanitarioDTO;
import com.agustin.examen.model.Sanitario;
import com.agustin.examen.service.SanitarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanitarios")
@RequiredArgsConstructor // Inyecta el servicio automáticamente
public class SanitarioController {

    private final SanitarioService sanitarioService;

    // GET: Obtener todos
    @GetMapping
    public ResponseEntity<List<Sanitario>> getAll() {
        return ResponseEntity.ok(sanitarioService.findAll());
    }

    // GET: Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sanitario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sanitarioService.findById(id));
    }

    // POST: Crear
    @PostMapping
    public ResponseEntity<Sanitario> create(@RequestBody NewSanitarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sanitarioService.add(dto));
    }

    // PUT: Editar
    @PutMapping("/{id}")
    public ResponseEntity<Sanitario> update(@PathVariable Long id, @RequestBody NewSanitarioDTO dto) {
        return ResponseEntity.ok(sanitarioService.edit(dto, id));
    }

    // DELETE: Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sanitarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}