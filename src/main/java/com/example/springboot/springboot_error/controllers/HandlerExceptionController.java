package com.example.springboot.springboot_error.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.springboot.springboot_error.models.Error;

@RestControllerAdvice // Esta anotacion le dice Esta clase manejará excepciones de todos los controllers de la aplicación
public class HandlerExceptionController {

    // si ocurre ArithmeticException ejecuta este método
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByzero(Exception ex) {
        Error error = new Error(); 
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // ResponseEntity es una clase de Spring Framework que sirve para construir una respuesta HTTP completa.
        
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrada");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> numberFormatException(NumberFormatException ex) {
        
        Map<String,Object> error = new HashMap<>();
        error.put("date",new Date().toString());
        error.put("error","numero invalido o incorrecto,no tiene formato de digito!");
        error.put("message",ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

}
