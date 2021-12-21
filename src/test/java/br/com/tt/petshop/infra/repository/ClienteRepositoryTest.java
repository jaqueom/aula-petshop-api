package br.com.tt.petshop.infra.repository;

import br.com.tt.petshop.infra.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    //@Autowired
    //private TestEntityManager em;

    @Test
    void deveRetornarListaVazia(){
        List<Cliente> clientes = clienteRepository.findAll();
        Assertions.assertEquals(0, clientes.size());
    }

    @Test
    void deveRetornarClienteFulano(){
        Cliente fulano = new Cliente(2L,"Fulano", LocalDate.now(), "51993333333", "29090223070");
        clienteRepository.save(fulano);
        Cliente ciclano = new Cliente(2L,"Ciclano", LocalDate.now(), "51993334444", "07187388020");
        clienteRepository.save(ciclano);

        Cliente cliente = clienteRepository.findByCpf("29090223070");
        Assertions.assertEquals("Fulano", cliente.getNome());
        Assertions.assertEquals("51993333333", cliente.getTelefone());
        Assertions.assertEquals("29090223070", cliente.getCpf());
    }


    @Test
    void deveRetornarPorCpfcomJpql(){
        Cliente fulano = new Cliente(2L,"Fulano", LocalDate.now(), "51993333333", "29090223070");
        clienteRepository.save(fulano);
        Cliente ciclano = new Cliente(2L,"Ciclano", LocalDate.now(), "51993334444", "07187388020");
        clienteRepository.save(ciclano);

        Cliente fulanoCliente = clienteRepository
                .buscaPorCpfComTelefoneNaoNulo("29090223070")
                .orElseThrow(()-> new RuntimeException("Não retornou o Fulano pelo CPF"));
        Assertions.assertEquals("Fulano", fulanoCliente.getNome());
        Assertions.assertEquals("51993333333", fulanoCliente.getTelefone());
        Assertions.assertEquals("29090223070", fulanoCliente.getCpf());

    }
}
