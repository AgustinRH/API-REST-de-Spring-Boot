package com.agustin.examen.dto;

import java.util.List;

public record NewCitaDTO(
        String fechaHora,
        String sintomas,
        Long pacienteId,
        List<Long> sanitariosIds
) {}