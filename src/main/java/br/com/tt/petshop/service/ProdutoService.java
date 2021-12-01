package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.dto.ProdutoListagem;
import br.com.tt.petshop.exception.ItemNaoEncontradoException;
import br.com.tt.petshop.factory.ProdutoFactory;
import br.com.tt.petshop.repository.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoListagem> listarProdutos (){
        return produtoRepository.findAll().stream()
                .map(ProdutoFactory::criarProdutoListagem)
                .collect(Collectors.toList());
    }
    public ProdutoDetalhes buscaPorId(Long id){
        return produtoRepository.findById(id)
                .map(ProdutoFactory::criarProdutoDetalhes)
                .orElseThrow(()-> new ItemNaoEncontradoException("O produto informado não existe!"));
    }
}
