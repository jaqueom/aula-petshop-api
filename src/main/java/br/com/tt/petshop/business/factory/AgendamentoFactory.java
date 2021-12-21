package br.com.tt.petshop.business.factory;

import br.com.tt.petshop.business.dto.AgendamentoCriacao;
import br.com.tt.petshop.business.dto.AgendamentoDetalhes;
import br.com.tt.petshop.business.dto.AgendamentoListagem;
import br.com.tt.petshop.infra.model.Agendamento;

public class AgendamentoFactory {

    public static AgendamentoListagem criaAgendamentoListagem(Agendamento agendamento) {
        return new AgendamentoListagem(agendamento.getId(), agendamento.getDataHoraInicio(),
                agendamento.getDataHoraFim());
    }

    public static AgendamentoDetalhes criaAgendamentoDetalhes(Agendamento agendamento) {
        return new AgendamentoDetalhes(agendamento.getId(), agendamento.getDataHoraInicio(),
                agendamento.getDataHoraFim(), agendamento.getObservacoes());
    }

    public static Agendamento criaAgendamento(AgendamentoCriacao criacao) {
        return new Agendamento(null, criacao.getDataHoraInicio(),
                criacao.getDataHoraFim(), criacao.getObservacoes());
    }

}
