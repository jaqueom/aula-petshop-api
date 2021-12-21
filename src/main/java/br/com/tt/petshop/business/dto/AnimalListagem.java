package br.com.tt.petshop.business.dto;

import br.com.tt.petshop.infra.model.TipoAnimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnimalListagem {
    private Long id;
    private TipoAnimal tipo;
    private String nome;
}
