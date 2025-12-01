package com.agustin.examen.error;

public class CitaNotFoundException extends RuntimeException {
    public CitaNotFoundException(Long id) {
        super("Cita no encontrada con id: " + id);
    }
}
