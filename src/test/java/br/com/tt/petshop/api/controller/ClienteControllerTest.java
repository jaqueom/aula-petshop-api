package br.com.tt.petshop.api.controller;

import br.com.tt.petshop.business.dto.ClienteListagem;
import br.com.tt.petshop.business.service.ClienteService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
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

        //String json =
                webclient
                .perform(MockMvcRequestBuilders
                        .get("/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()); //forma de imprimir o retorno sem precisar atribuir a uma string ou a um log
                //.andReturn().getResponse().getContentAsString(); //forma de retornar string para colocar no log

        //LOG.info(json);

    }

    @Test
    void deveCriarERetornarLocation() throws Exception {

        Mockito.when(clienteService.criar(Mockito.any())).thenReturn(Long.valueOf("1"));

        //FORMAS DE CRIAR O JSON PARA TESTAR:
        // 1:

        //Fica feio usar desse jeito, colando o JSON aqui...
        /*
        String body = "{\n" +
                "  \"nome\": \"teste1\",\n" +
                "  \"valor\": 1,\n" +
                "  \"ativo\": true\n" +
                "}";
        */

        // 2:
        //Segunda forma de fazer, com objectMapper:
        /*
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String body = new ObjectMapper().writeValueAsString(
                new ClienteCriacao(1L,"Thor", LocalDate.parse("1987-06-05"), "999999999", "88888888888"));
         */

        // 3:
        // Terceira forma: MAIS recomendada
        JSONObject json = new JSONObject();
        json.put("nome","TesteJaque");
        json.put("cpf","88888888888");
        json.put("telefone","999999999");
        json.put("nascimento","1987-06-05");


        webclient.perform(MockMvcRequestBuilders
                .post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.toString())
        ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().stringValues("location","/clientes/1"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void deveAtualizar() throws Exception{

        JSONObject json = new JSONObject();
        json.put("nome","TesteJaque");
        json.put("telefone","999999999");
        json.put("nascimento","1987-06-05");

        webclient.perform(MockMvcRequestBuilders.put("/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json.toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print());

        // Não deu certo isso:
        //ArgumentCaptor<ClienteAtualizacao> captor = ArgumentCaptor.forClass(ClienteAtualizacao.class); // cria um objeto de captura
        //Mockito.verify(clienteService).atualizar(1L, captor.capture());

    }

    @Test
    void deveDeletar() throws Exception{
        webclient.perform(MockMvcRequestBuilders.delete("/clientes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

        Mockito.verify(clienteService).apagar(1L);
    }
}
