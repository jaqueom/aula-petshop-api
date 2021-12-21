package br.com.tt.petshop.business.service;

import br.com.tt.petshop.business.dto.AgendamentoAtualizacao;
import br.com.tt.petshop.business.dto.AgendamentoCriacao;
import br.com.tt.petshop.business.dto.AgendamentoDetalhes;
import br.com.tt.petshop.business.dto.AgendamentoListagem;
import br.com.tt.petshop.business.exception.NaoExisteException;
import br.com.tt.petshop.business.factory.AgendamentoFactory;
import br.com.tt.petshop.infra.model.Agendamento;
import br.com.tt.petshop.infra.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public List<AgendamentoListagem> listar() {
        return agendamentoRepository.findAll().stream()
                .map(AgendamentoFactory::criaAgendamentoListagem)
                .collect(Collectors.toList());
    }

    public AgendamentoDetalhes buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .map(AgendamentoFactory::criaAgendamentoDetalhes)
                .orElseThrow(() -> new NaoExisteException("O Agendamento informado não existe!"));
    }

    public Long criar(AgendamentoCriacao criacao) {
        Agendamento agendamentoSalvo = agendamentoRepository.save(AgendamentoFactory.criaAgendamento(criacao));
        return agendamentoSalvo.getId();
    }

    public void apagar(Long id) {
        agendamentoRepository.findById(id)
                .ifPresent(agendamentoRepository::delete);
    }

    public void atualizar(Long id, AgendamentoAtualizacao atualizacao) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new NaoExisteException("Não existe tal agendamento!"));

        Agendamento agendamentoAlterado = agendamento.toBuilder() //crio um "builder" copiando todas as informações originais
                .dataHoraInicio(atualizacao.getDataHoraInicio()) //altero as informações que quero.. uma a uma
                .dataHoraFim(atualizacao.getDataHoraFim())
                .observacoes(agendamento.getObservacoes())
                .build(); //converter de volta pra um agendamento, mas com os dados alterados...

        agendamentoRepository.save(agendamentoAlterado);
    }
}
