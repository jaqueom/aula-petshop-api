package br.com.tt.petshop.factory;

import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.dto.ProdutoListagem;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Produto;

public class ProdutoFactory {
    public static ProdutoListagem criarProdutoListagem (Produto produto) {
        return new ProdutoListagem(produto.getId(), produto.getNome(), produto.isAtivo());
    }


    public static ProdutoDetalhes criarProdutoDetalhes (Produto produto){
        return new ProdutoDetalhes(produto.getId(), produto.getNome(), produto.getValor(), produto.isAtivo());
    }

    public static Produto criarProduto(ProdutoCriacao dto) {
        return new Produto (dto.getId()
                , dto.getNome()
                , dto.getValor()
                , dto.isAtivo());
    }
}
