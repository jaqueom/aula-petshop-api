package br.com.tt.petshop.api.handler;

import br.com.tt.petshop.business.dto.InformacoesErro;
import br.com.tt.petshop.business.exception.NaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ClienteJaExisteHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NaoExisteException.class)
    public InformacoesErro tratarErro(NaoExisteException e){
        return new InformacoesErro(403, LocalDateTime.now(), e.getMessage());
    }

}
