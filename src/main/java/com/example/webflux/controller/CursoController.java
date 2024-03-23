package com.example.webflux.controller;

import com.example.webflux.model.Curso;
import com.example.webflux.model.Usuario;
import com.example.webflux.service.CursoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<Curso> findByName(@RequestParam String name) {
        return cursoService.findByName(name);
    }
}
