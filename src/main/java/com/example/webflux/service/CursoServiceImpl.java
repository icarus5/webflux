package com.example.webflux.service;

import com.example.webflux.model.Curso;
import com.example.webflux.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoServiceImpl {


    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public Flux<Curso> findByCursoByUsuario(Long idusuario) {
        return cursoRepository.findCursoByIdusuario(idusuario);
    }

    public Flux<Curso> findByName(String name) {
        return cursoRepository.findByName(name);
    }

    public Mono<Curso> save(Curso curso) {
        return cursoRepository.save(curso);
    }

}
