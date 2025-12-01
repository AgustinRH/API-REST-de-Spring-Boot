package com.agustin.examen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Sanitario {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String especialidad;

    @JsonIgnore
    @ManyToMany(mappedBy = "sanitarios")
    private List<Cita> citas = new ArrayList<>();
}