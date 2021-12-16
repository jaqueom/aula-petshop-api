package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AnimalCriacao {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final TipoAnimal tipo;
    private final String nome;
    private final LocalDate nascimento;
    private final String foto;
}
