package br.com.tt.petshop.api.controller;

import br.com.tt.petshop.business.dto.ProdutoDetalhes;
import br.com.tt.petshop.business.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

    static final Logger LOG = LoggerFactory.getLogger(ClienteControllerTest.class);

    @Autowired
    MockMvc webclient;

    @MockBean
    ProdutoService produtoService;

    @Test
    void deveRetornarListaVazia() throws Exception {
        webclient
                .perform(MockMvcRequestBuilders
                        .get("/produtos"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void deveRetornarDoisProdutos() throws Exception {
        Mockito.when(produtoService.listarProdutos(null))
                .thenReturn(List.of(
                          new ProdutoDetalhes(1L, "Ração", BigDecimal.valueOf(142.62d), true)
                        , new ProdutoDetalhes(2L, "Brinquedo", BigDecimal.valueOf(10.6), false)));

        String json = webclient
                .perform(MockMvcRequestBuilders
                        .get("/produtos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        LOG.info(json);

    }
}
