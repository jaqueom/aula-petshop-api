package br.com.tt.petshop.business.service;

import br.com.tt.petshop.business.dto.ClienteDetalhes;
import br.com.tt.petshop.business.dto.ClienteListagem;
import br.com.tt.petshop.infra.repository.ClienteRepository;
import mock.ClienteMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Liga o "plugin" do Mockito no teste do JUnit
public class ClienteServiceTest {

    //NÃO EXISTE AUTOWIRED, pois é SPRING, e não temos SPRING em testes de serviço
    @InjectMocks // dá NEW nessa classe e injeta os mocks (dependências)
    ClienteService clienteService;

    @Mock // Cria uma "simulaçaõ da dependência
    ClienteRepository clienteRepository;

    @Test
    void deveListarClientes(){
        Mockito
                .when(clienteRepository.findAll())
                .thenReturn(List.of(ClienteMock.theo()));

        //Ação - Act
        List<ClienteListagem> dtos = clienteService.listarClientes("Theo");

        Assertions.assertEquals(1,dtos.size());
        ClienteListagem clientedto = dtos.get(0);
        Assertions.assertEquals("Theo",clientedto.getNome());
        Assertions.assertEquals("29090223070",clientedto.getCpf());
    }

    @Test
    void deveRetornarPorId(){
        Mockito
                .when(clienteRepository.findById(2L))
                .thenReturn(Optional.of(ClienteMock.theo()));

        ClienteDetalhes clienteDetalhes = clienteService.buscarPorId(2L);
        Assertions.assertNotNull(clienteDetalhes);
        Assertions.assertEquals("Theo",clienteDetalhes.getNome());
        Assertions.assertEquals("29090223070",clienteDetalhes.getCpf());
        Assertions.assertEquals("51993333333", clienteDetalhes.getTelefone());
        Assertions.assertEquals(LocalDate.parse("1987-05-06"), clienteDetalhes.getNascimento());

    }

    @Test
    void deveFalharAoBuscarIdInexistente(){
        Mockito
                .when(clienteRepository.findById(999L))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class,
                () -> clienteService.buscarPorId(999L));
    }

}
