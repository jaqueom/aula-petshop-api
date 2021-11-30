package br.com.tt.petshop.dto;

import java.math.BigDecimal;

public class ProdutoDetalhes {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private boolean ativo;

    public ProdutoDetalhes(Long id, String nome, BigDecimal valor, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
