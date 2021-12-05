package br.com.tt.petshop.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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

    @Column(name="cpf")
    private String cpf;

    // O JPA/Hibernate usa esse construtor!!
    ClienteAtualizacao() {}

    public ClienteAtualizacao(Long id, String nome, LocalDate nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

}
