package com.bielsoft.desafioForumHubONE.Exception;

import com.bielsoft.desafioForumHubONE.Exception.dtoExceptions.TituloCadastradoExceptionDTO;
import com.bielsoft.desafioForumHubONE.dtos.BeanValidationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExcetionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<BeanValidationDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<BeanValidationDTO> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new BeanValidationDTO(fieldError.getDefaultMessage(), fieldError.getField()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TituloCadastradoException.class)
    public ResponseEntity<TituloCadastradoExceptionDTO> handleTituloCadastradoException(TituloCadastradoException ex) {
        TituloCadastradoExceptionDTO tituloEx = new TituloCadastradoExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(tituloEx, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNaoEcontradoException.class)
    public ResponseEntity<TituloCadastradoExceptionDTO> handleIdNaoEcontradoException(IdNaoEcontradoException ex) {
        TituloCadastradoExceptionDTO tituloEx = new TituloCadastradoExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(tituloEx, HttpStatus.BAD_REQUEST);
    }
}
