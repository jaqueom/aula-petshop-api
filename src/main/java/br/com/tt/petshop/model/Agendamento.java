package br.com.tt.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity // ENTIDADE
@Table(name = "tb_agendamento")
public class Agendamento {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

   @Column(name = "dataHoraInicio")
   public LocalDateTime dataHoraInicio;

   @Column(name = "dataHoraFim")
   public LocalDateTime dataHoraFim;

   @Column(name = "observacao")
   public String observacoes;

    public Agendamento(long id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String observacoes) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacoes = observacoes;
    }

    Agendamento() {}

    public long getId() {
        return id;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
