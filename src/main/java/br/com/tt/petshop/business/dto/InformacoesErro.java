package br.com.tt.petshop.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InformacoesErro {
    private final int codigo;
    private final LocalDateTime dataHora;
    private final String mensagem;

}
