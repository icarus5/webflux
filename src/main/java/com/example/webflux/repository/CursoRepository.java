package com.example.webflux.repository;


import com.example.webflux.model.Curso;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CursoRepository extends ReactiveCrudRepository<Curso, Long> {


    Flux<Curso> findCursoByIdusuario(Long idusuario);

}
