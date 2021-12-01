package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    /*
        Criar Repositório com as seguintes consultas (uma utilizando QueryMethod, outra jpql e outra sql):
        * Buscar agendamentos do dia.
        * Buscar agendamentos dos próximos 7 dias. LocalDate.now().minusDays(7);
        * Buscar agendamento por ID.

*/
    //QueryMethod
    Agendamento findById(long id);

    //JPQL
    @Query("select a from Agendamento a where a.dataHoraInicio = :hoje")
    Optional<Agendamento> buscarAgendamentosDoDia(LocalDateTime hoje);

    //SQL
    @Query(nativeQuery = true
            , value = "select * from tb_agendamentos where dataHoraInicio between CURRENT_DATE() AND CURRENT_DATE()+7")
    Optional<Agendamento> buscarAgendamentosProximos7Dias();

}
