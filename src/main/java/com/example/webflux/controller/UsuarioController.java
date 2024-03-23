package com.example.webflux.controller;


import com.example.webflux.model.Usuario;
import com.example.webflux.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UsuarioController {


    private final UsuarioServiceImpl userService;

    @Autowired
    public UsuarioController(UsuarioServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<Usuario> save(@RequestBody Usuario usuario) {
        return userService.save(usuario);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<Usuario> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<Usuario> findByName(@RequestParam String name) {
        return userService.findName(name);
    }


}
