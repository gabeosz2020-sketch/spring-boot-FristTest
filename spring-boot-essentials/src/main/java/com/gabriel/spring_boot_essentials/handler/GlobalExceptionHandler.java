package com.gabriel.spring_boot_essentials.handler;

import com.gabriel.spring_boot_essentials.model.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundProductException.class)
    public ResponseEntity<ErroResponse> handleNotFoudProductException(NotFoundProductException ex){


        ErroResponse response = ErroResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleException(NotFoundProductException ex) {

        ErroResponse response = ErroResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }}
