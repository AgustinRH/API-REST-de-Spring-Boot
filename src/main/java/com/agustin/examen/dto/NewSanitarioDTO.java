package com.agustin.examen.dto;

import com.agustin.examen.model.Sanitario;

public record NewSanitarioDTO(
        Long id,
        String nombre,
        String especialidad
) {
    public static NewSanitarioDTO of(Sanitario sanitario) {
        return new NewSanitarioDTO(
                sanitario.getId(), sanitario.getNombre(), sanitario.getEspecialidad()
        );
    }
}
