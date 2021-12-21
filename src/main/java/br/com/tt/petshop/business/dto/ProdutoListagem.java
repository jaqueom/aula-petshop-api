package br.com.tt.petshop.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProdutoListagem {
    private final long id;
    private final String nome;
    private final Boolean ativo;

}
