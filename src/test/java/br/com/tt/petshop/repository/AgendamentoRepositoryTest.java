package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Agendamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AgendamentoRepositoryTest {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Test
    void deveRetornarAgendamentosPorId(){
        Agendamento byId = agendamentoRepository.findById(1L);
    }
    //TODO

}
