package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ProdutoAtualizacao;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.dto.ProdutoListagem;
import br.com.tt.petshop.exception.ItemNaoEncontradoException;
import br.com.tt.petshop.factory.ClienteFactory;
import br.com.tt.petshop.factory.ProdutoFactory;
import br.com.tt.petshop.model.Cliente;
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

    public List<ProdutoListagem> listarProdutos (String nome){

        List<Produto> produtos;
        if (nome == null){
            produtos = produtoRepository.findAll();
        }else{
            produtos = produtoRepository.findByNomeContaining(nome);
        }
        return produtos.stream()
                .map(ProdutoFactory::criarProdutoListagem)
                .collect(Collectors.toList());

    }

    public ProdutoDetalhes buscaPorId(Long id){
        return produtoRepository.findById(id)
                .map(ProdutoFactory::criarProdutoDetalhes)
                .orElseThrow(()-> new ItemNaoEncontradoException("O produto informado não existe!"));
    }

    public Long criar(ProdutoCriacao dto) {
        Produto produto = ProdutoFactory.criarProduto(dto);
        produtoRepository.save(produto);
        return produto.getId();
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

    public void buscarPorStatus(String status) {
        if (status.equals("ativos")){
            produtoRepository.findByAtivoTrue();
        }else {
            produtoRepository.findByAtivoFalse();
        }
    }
}
