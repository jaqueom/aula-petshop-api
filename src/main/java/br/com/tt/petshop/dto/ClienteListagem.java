package br.com.tt.petshop.dto;

public class ClienteListagem {
    private final long id;
    private final String nome;
    private final String cpf;

    public ClienteListagem(long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
