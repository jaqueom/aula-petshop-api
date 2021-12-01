package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import mock.ProdutoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach // roda antes de cada teste
    void insereProdutosParaTestes() {
        produtoRepository.save(new Produto(1l, "Ração para cachorros",BigDecimal.valueOf(142.62d), true));
        produtoRepository.save(new Produto(2l, "Ração para gatos",BigDecimal.valueOf(292.99d), true));
        produtoRepository.save(new Produto(3l, "Ração para porcos",BigDecimal.valueOf(199.50d), false));
        produtoRepository.save(new Produto(4l, "Brinquedo de morder",BigDecimal.valueOf(10d), true));
    }

    @Test
    void deveRetornarListaCompleta(){
        List<Produto> produtos = produtoRepository.findAll();
        assertEquals(4, produtos.size());
    }

    @Test
    void deveRetornarProdutosRacao(){
        List<Produto> produtosParaCachorros = produtoRepository.findByNomeContaining("Ração");
        assertEquals(3,produtosParaCachorros.size());
        Produto produto = produtosParaCachorros.get(0);
        assertEquals("Ração para cachorros", produto.getNome());
        assertEquals(BigDecimal.valueOf(142.62d), produto.getValor());
        assertTrue(produto.isAtivo());
    }

    @Test
    void deveRetornarProdutosEntreValores(){
        List<Produto> produtosAte50Reais = produtoRepository.findByValorBetween(BigDecimal.valueOf(0),BigDecimal.valueOf(50));
        assertEquals(1,produtosAte50Reais.size());
        Produto produto = produtosAte50Reais.get(0);
        assertEquals("Brinquedo de morder", produto.getNome());
        assertEquals(BigDecimal.valueOf(10d), produto.getValor());
        assertTrue(produto.isAtivo());
    }

    @Test
    void deveRetornarProdutosInativo(){
        List<Produto> produtosInativo = produtoRepository.findByAtivoFalse();
        assertEquals(1,produtosInativo.size());
        Produto produto = produtosInativo.get(0);
        assertEquals("Ração para porcos", produto.getNome());
        assertEquals(BigDecimal.valueOf(199.50d), produto.getValor());
        assertFalse(produto.isAtivo());
    }

    @Test
    void deveBuscarAtivosPorNome(){
        List<Produto> produtos = produtoRepository.listarProdutosAtivosPorNome("Ração");
        assertEquals(2,produtos.size());
        Produto produto = produtos.get(0);
        assertEquals("Ração para cachorros", produto.getNome());
        assertEquals(BigDecimal.valueOf(142.62d), produto.getValor());
        assertTrue(produto.isAtivo());
    }

    @Test
    void deveBuscarProdutosAtivosPorPreco(){
        List<Produto> produtos = produtoRepository.listarProdutosAtivosPorPreco();
        assertEquals(3,produtos.size());
        Produto produto = produtos.get(0);
        assertEquals("Brinquedo de morder", produto.getNome());
        assertEquals(BigDecimal.valueOf(10d), produto.getValor());
        assertTrue(produto.isAtivo());
    }

    @Test
    void deveContarProdutosInativos(){
        long qntProdutosInativos = produtoRepository.contarProdutosInativos();
        assertEquals(1,qntProdutosInativos);
    }
}
