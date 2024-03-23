package com.example.webflux.service;

import com.example.webflux.model.Usuario;
import com.example.webflux.repository.CursoRepository;
import com.example.webflux.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;

    private final CursoRepository cursoRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }


    public Mono<Usuario> save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll()
                .flatMap(user -> cursoRepository.findCursoByIdusuario(user.getId())
                .collectList().map(cursos -> {
                    user.setCursos(cursos);
                    return user;
                }));
    }

    public Flux<Usuario> findName(String name) {
        return usuarioRepository.findbyName(name).flatMap(user -> cursoRepository.findCursoByIdusuario(user.getId()).map(curso -> {
            user.getCursos().add(curso);
            return user;
        }));
    }


}
