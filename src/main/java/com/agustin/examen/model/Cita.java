package com.agustin.examen.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaHora;
    private String sintomas;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;


    @ManyToMany
    @JoinTable(
            name = "sanitario_cita",
            joinColumns = @JoinColumn(name = "cita_id"),
            inverseJoinColumns = @JoinColumn(name = "sanitario_id")
    )
    private List<Sanitario> sanitarios = new ArrayList<>();

}