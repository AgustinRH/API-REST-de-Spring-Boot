package com.agustin.examen.repository;

import com.agustin.examen.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteJpaRepository extends JpaRepository<Paciente, Long> {
}
