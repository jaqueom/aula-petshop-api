package br.com.tt.petshop.dto;

public class ProdutoListagem {
    private final long id;
    private final String nome;

    public ProdutoListagem(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
