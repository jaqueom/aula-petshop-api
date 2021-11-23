package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void deveRetornarListaVazia(){
        List<Produto> produtos = produtoRepository.findAll();
        Assertions.assertEquals(0, produtos.size());
    }

    @Test
    void deveRetornarProdutosRacao(){
        insereProdutosParaTestes();

        List<Produto> produtosParaCachorros = produtoRepository.findByNomeContaining("Ração");
        Assertions.assertEquals(3,produtosParaCachorros.size());
        Produto produto = produtosParaCachorros.get(0);
        Assertions.assertEquals("Ração para cachorros", produto.getNome());
        Assertions.assertEquals(BigDecimal.valueOf(142.62d), produto.getValor());
        Assertions.assertTrue(produto.isAtivo());
    }

    @Test
    void deveRetornarProdutosEntreValores(){
        insereProdutosParaTestes();

        List<Produto> produtosAte50Reais = produtoRepository.findByValorBetween(BigDecimal.valueOf(0),BigDecimal.valueOf(50));
        Assertions.assertEquals(1,produtosAte50Reais.size());
        Produto produto = produtosAte50Reais.get(0);
        Assertions.assertEquals("Brinquedo de morder", produto.getNome());
        Assertions.assertEquals(BigDecimal.valueOf(10d), produto.getValor());
        Assertions.assertTrue(produto.isAtivo());
    }

    @Test
    void deveRetornarProdutosInativo(){
        insereProdutosParaTestes();

        List<Produto> produtosInativo = produtoRepository.findByAtivoFalse();
        Assertions.assertEquals(1,produtosInativo.size());
        Produto produto = produtosInativo.get(0);
        Assertions.assertEquals("Ração para porcos", produto.getNome());
        Assertions.assertEquals(BigDecimal.valueOf(199.50d), produto.getValor());
        Assertions.assertFalse(produto.isAtivo());
    }

    private void insereProdutosParaTestes() {
        produtoRepository.save(new Produto(1l, "Ração para cachorros", BigDecimal.valueOf(142.62d), true));
        produtoRepository.save(new Produto(2l, "Ração para gatos", BigDecimal.valueOf(292.99d), true));
        produtoRepository.save(new Produto(3l, "Ração para porcos", BigDecimal.valueOf(199.50d), false));
        produtoRepository.save(new Produto(4l, "Brinquedo de morder", BigDecimal.valueOf(10d), true));
    }
}
