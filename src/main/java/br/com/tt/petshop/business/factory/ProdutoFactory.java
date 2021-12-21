package br.com.tt.petshop.business.factory;

import br.com.tt.petshop.business.dto.ProdutoCriacao;
import br.com.tt.petshop.business.dto.ProdutoDetalhes;
import br.com.tt.petshop.business.dto.ProdutoListagem;
import br.com.tt.petshop.infra.model.Produto;

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
