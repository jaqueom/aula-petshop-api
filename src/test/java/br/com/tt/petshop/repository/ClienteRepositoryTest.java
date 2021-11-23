package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.apache.catalina.LifecycleState;
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

    @Test
    void deveRetornarListaVazia(){
        List<Cliente> clientes = clienteRepository.findAll();
        Assertions.assertEquals(0, clientes.size());
    }

    @Test
    void deveRetornarClienteFulano(){
        Cliente fulano = new Cliente(2L,"Fulano", LocalDate.now(), "51993333333");
        clienteRepository.save(fulano);

        List<Cliente> clientes = clienteRepository.findAll();
        Assertions.assertEquals(1, clientes.size());
    }
}
