package br.com.tt.petshop.dto;

import java.time.LocalDate;

public class ClienteDetalhes {
    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String cpf;

    public ClienteDetalhes(Long id, String nome, LocalDate nascimento, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }
}
