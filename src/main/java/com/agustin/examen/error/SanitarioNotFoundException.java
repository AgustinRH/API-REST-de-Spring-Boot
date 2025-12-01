package com.agustin.examen.error;

public class SanitarioNotFoundException extends RuntimeException {
    public SanitarioNotFoundException(Long id) {
        super("No hay sanitarios con ese ID");
    }
    public SanitarioNotFoundException() {
        super("No hay sanitarios con esos requisitos de búsqueda");
    }
}
