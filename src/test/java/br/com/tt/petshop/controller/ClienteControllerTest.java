package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.service.ClienteService;
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

import java.util.List;

@WebMvcTest(controllers = ClienteController.class)
class ClienteControllerTest {

    //anotação para gerar log
    static final Logger LOG = LoggerFactory.getLogger(ClienteControllerTest.class);

    @Autowired
    MockMvc webclient;

    /*
     * @MockBean: Usem só em teste do Spring
     * Nos demais continue usando só @Mock
     */
    @MockBean
    ClienteService clienteService;

    @Test
    void deveRetornarListaVazia() throws Exception {
        webclient
                .perform(MockMvcRequestBuilders
                        .get("/clientes"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void deveRetornarDoisClientes() throws Exception {
        Mockito.when(clienteService.listarClientes(null))
                .thenReturn(List.of(
                          new ClienteListagem(1L,"Thor", "88888888888")
                        , new ClienteListagem(2L, "Mulher Maravilha", "99999999999")));

        String json = webclient
                .perform(MockMvcRequestBuilders
                        .get("/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        LOG.info(json);

    }

}
