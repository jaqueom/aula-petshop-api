package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProdutoCriacao {

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
    ProdutoCriacao() {}


}
