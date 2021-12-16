package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Animais {
    private final Long id;
    private final TipoAnimal tipo;
    private final String nome;
    private final LocalDate nascimento;
    private final String foto;

}
