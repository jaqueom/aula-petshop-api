package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClienteDetalhes {
    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String cpf;

}
