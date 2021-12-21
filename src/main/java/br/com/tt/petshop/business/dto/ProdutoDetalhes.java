package br.com.tt.petshop.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProdutoDetalhes {

    private final Long id;
    private final String nome;
    private final BigDecimal valor;
    private final boolean ativo;

}
