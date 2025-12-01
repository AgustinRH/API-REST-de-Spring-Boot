package com.agustin.examen.repository;

import com.agustin.examen.model.Sanitario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SanitarioJpaRepository extends JpaRepository<Sanitario, Long> {
    Optional<Sanitario> findById(Long id);
    @Transactional
    void deleteById(Long id);
}
