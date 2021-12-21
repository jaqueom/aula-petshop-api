package br.com.tt.petshop.business.dto;

import br.com.tt.petshop.infra.model.TipoAnimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class AnimalDetalhes {
    private Long id;
    private TipoAnimal tipo;
    private String nome;
    private LocalDate nascimento;
    private String foto;
    private String nomeTutor;
}
