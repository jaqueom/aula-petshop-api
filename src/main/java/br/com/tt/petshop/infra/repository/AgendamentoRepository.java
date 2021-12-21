package br.com.tt.petshop.infra.repository;

import br.com.tt.petshop.infra.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
