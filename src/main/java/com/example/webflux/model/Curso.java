package com.example.webflux.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "curso")
public class Curso {

    @Id
    private Long id;

    private String name;

    private int nota;

    private Long idusuario;

}
