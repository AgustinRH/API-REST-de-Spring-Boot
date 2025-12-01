package com.agustin.examen.error;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(Long id) {
        super("Paciente con id " + id + " no encontrado");
    }
}
