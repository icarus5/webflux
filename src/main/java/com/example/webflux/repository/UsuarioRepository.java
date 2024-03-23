package com.example.webflux.repository;

import com.example.webflux.model.Usuario;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {

    @Query("select * from Usuario a where a.name=:name")
    Flux<Usuario> findbyName(String name);

}
