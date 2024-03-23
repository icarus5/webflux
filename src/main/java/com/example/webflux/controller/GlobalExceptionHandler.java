package com.example.webflux.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorGeneric>> handleAllExceptions(Exception ex, ServerWebExchange exchange) {
        // Aquí puedes personalizar la respuesta basada en el tipo de excepción
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON).body(new ErrorGeneric(ex.getMessage(), LocalDateTime.now())));
    }

    @Getter
    @Setter
    public class ErrorGeneric {
        private String mesage;
        private LocalDateTime timeStamp;

        public ErrorGeneric(String mesage, LocalDateTime timeStamp) {
            this.mesage = mesage;
            this.timeStamp = timeStamp;
        }
    }

}
