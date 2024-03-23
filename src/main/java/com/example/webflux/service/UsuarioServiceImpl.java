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

    private final CursoServiceImpl cursoServiceImpl;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CursoServiceImpl cursoServiceImpl) {
        this.usuarioRepository = usuarioRepository;
        this.cursoServiceImpl = cursoServiceImpl;
    }


    public Mono<Usuario> save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll()
                .flatMap(user -> cursoServiceImpl.findByCursoByUsuario(user.getId())
                        .collectList().map(cursos -> {
                            user.setCursos(cursos);
                            return user;
                        }));
    }

    public Flux<Usuario> findName(String name) {
        return usuarioRepository.findbyName(name)
                .flatMap(user -> cursoServiceImpl.findByCursoByUsuario(user.getId())
                        .collectList().map(curso -> {
                            user.setCursos(curso);
                            return user;
                        }));
    }


}
