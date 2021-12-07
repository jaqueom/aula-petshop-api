package br.com.tt.petshop.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

public class ProdutoAtualizacao {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="valor")
    private BigDecimal valor;
    @Column(name="ativo")
    private boolean ativo;

    // O JPA/Hibernate usa esse construtor!!
    ProdutoAtualizacao() {}

    public ProdutoAtualizacao(Long id, String nome, BigDecimal valor, boolean ativo) {
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
