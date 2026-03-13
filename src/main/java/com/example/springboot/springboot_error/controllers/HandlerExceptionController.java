package com.example.springboot.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboot.springboot_error.models.Error;

@RestControllerAdvice //Esta anotacion le dice Esta clase manejará excepciones de todos los controllers de la aplicación
public class HandlerExceptionController {

    //si ocurre ArithmeticException ejecuta este método
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByzero(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    //ResponseEntity es una clase de Spring Framework que sirve para construir una respuesta HTTP completa.
    //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
}
