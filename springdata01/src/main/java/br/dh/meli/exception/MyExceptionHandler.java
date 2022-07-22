package br.dh.meli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .fields("id")
                        .fieldsMessages("id não encontrado")
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
