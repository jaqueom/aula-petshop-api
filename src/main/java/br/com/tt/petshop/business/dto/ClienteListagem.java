package br.com.tt.petshop.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClienteListagem {

    private final long id;
    private final String nome;
    private final String cpf;

}
