package br.com.tt.petshop.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClienteAtualizacao {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="nascimento")
    private LocalDate nascimento;

    @Column(name="telefone")
    private String telefone;


    // O JPA/Hibernate usa esse construtor!!
    ClienteAtualizacao() {}

}
