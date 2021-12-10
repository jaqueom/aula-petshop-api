package br.com.tt.petshop.service;

import br.com.tt.petshop.controller.Status;
import br.com.tt.petshop.dto.ProdutoAtualizacao;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.exception.NaoExisteException;
import br.com.tt.petshop.factory.ProdutoFactory;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDetalhes> listarProdutos (String nome){

        List<Produto> produtos;
        if (nome == null){
            produtos = produtoRepository.findAll();
        }else{
            produtos = produtoRepository.findByNomeContaining(nome);
        }
        return produtos.stream()
                .map(ProdutoFactory::criarProdutoDetalhes)
                .collect(Collectors.toList());

    }

    public ProdutoDetalhes buscaPorId(Long id){
        return produtoRepository.findById(id)
                .map(ProdutoFactory::criarProdutoDetalhes)
                .orElseThrow(()-> new NaoExisteException("O produto informado não existe!"));
    }

    public Long criar(ProdutoCriacao dto) {
        Produto produto = ProdutoFactory.criarProduto(dto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo.getId();
    }

    public void atualizar(Long id, ProdutoAtualizacao produto) {

        //TODO USAR LOMBOK
        Produto produtoAtualizado = new Produto(id
                , produto.getNome()
                , produto.getValor()
                , produto.isAtivo());

        produtoRepository.save(produtoAtualizado);
    }

    public void apagar(Long id) {
        produtoRepository.deleteById(id);
    }


    public List<ProdutoDetalhes> buscarProdutosPorStatus(Status status) {

        List<Produto> produtos;

        if (status.equals(Status.ATIVO)) {
            produtos = produtoRepository.findByAtivoTrue();
        }else if (status.equals(Status.INATIVO)){
            produtos = produtoRepository.findByAtivoFalse();
        }else{
            produtos = produtoRepository.findAll();
        }
        return produtos.stream()
                .map(ProdutoFactory::criarProdutoDetalhes)
                .collect(Collectors.toList());

    }

}
