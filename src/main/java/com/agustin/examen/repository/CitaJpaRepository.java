package com.agustin.examen.repository;

import com.agustin.examen.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaJpaRepository extends JpaRepository<Cita, Long> {
}
