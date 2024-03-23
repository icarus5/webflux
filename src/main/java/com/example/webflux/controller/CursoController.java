package com.example.webflux.controller;

import com.example.webflux.model.Curso;
import com.example.webflux.service.CursoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/curso")
public class CursoController {


    private final CursoServiceImpl cursoService;

    public CursoController(CursoServiceImpl cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Curso> save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }
}
