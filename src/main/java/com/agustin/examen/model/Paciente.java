package com.agustin.examen.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String antecedentes;
}