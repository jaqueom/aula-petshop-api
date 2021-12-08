package br.com.tt.petshop.service;


import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.dto.ProdutoListagem;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.repository.ProdutoRepository;
import mock.ClienteMock;
import mock.ProdutoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Liga o "plugin" do Mockito no teste do JUnit
public class ProdutoServiceTest {

    //NÃO EXISTE AUTOWIRED, pois é SPRING, e não temos SPRING em testes de serviço
    @InjectMocks // dá NEW nessa classe e injeta os mocks (dependências)
    ProdutoService produtoService;

    @Mock // Cria uma "simulação da dependência
    ProdutoRepository produtoRepository;

    @Test
    void deveListarProdutos(){
        Mockito
                .when(produtoRepository.findAll())
                .thenReturn(List.of(ProdutoMock.racaoCachorro()
                        , ProdutoMock.racaoGatos()
                        , ProdutoMock.racaoPorcos()));

        //Ação - Act
        List<ProdutoDetalhes> dtos = produtoService.listarProdutos(null);

        Assertions.assertEquals(3,dtos.size());
        ProdutoDetalhes produto = dtos.get(0);
        Assertions.assertEquals("Ração para cachorros",produto.getNome());

    }

    @Test
    void deveRetornarProdutoPorId(){
        Mockito
                .when(produtoRepository.findById(3L))
                .thenReturn(Optional.of(ProdutoMock.racaoPorcos()));

        //Ação - Act
        ProdutoDetalhes produto = produtoService.buscaPorId(3L);

        Assertions.assertEquals(3L, produto.getId());
        Assertions.assertEquals("Ração para porcos",produto.getNome());
        Assertions.assertEquals(BigDecimal.valueOf(199.50d),produto.getValor());
        Assertions.assertEquals(false, produto.isAtivo());
    }

    @Test
    void deveFalharAoBuscarProdutoPorId(){
        Mockito
                .when(produtoRepository.findById(999L))
                .thenReturn(Optional.empty());

        RuntimeException e = Assertions.assertThrows(RuntimeException.class,
                             () -> produtoService.buscaPorId(999L));
        Assertions.assertEquals("O produto informado não existe!",e.getMessage());
    }
}
