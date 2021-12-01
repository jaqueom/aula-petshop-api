package br.com.tt.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // só funciona para bancos relacionais, até agora... // ENTIDADE
@Table(name="tb_produto") // se não coloca nome aqui, assume o nome da classe, mesma coisa nos nomes dos campos
public class Produto {
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
    Produto() {}

    public Produto(Long id, String nome, BigDecimal valor, boolean ativo) {
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
