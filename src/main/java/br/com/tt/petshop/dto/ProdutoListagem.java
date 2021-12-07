package br.com.tt.petshop.dto;

public class ProdutoListagem {
    private final long id;
    private final String nome;
    private final Boolean ativo;

    public ProdutoListagem(long id, String nome, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
