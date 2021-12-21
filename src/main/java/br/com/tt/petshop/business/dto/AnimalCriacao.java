package br.com.tt.petshop.business.dto;

import br.com.tt.petshop.infra.model.TipoAnimal;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Getter
public class AnimalCriacao {

    @NotNull(message = "Tipo deve ser informado")
    private TipoAnimal tipo;

    @NotBlank(message = "Nome deve ser informado!")
    private String nome;

    @NotNull(message = "Nascimento deve ser informado")
    @PastOrPresent(message = "Nascimento deve estar em data passsada ou presente!")
    private LocalDate nascimento;

    @NotNull(message = "ID Cliente deve ser informado!")
    private Long idTutor;

    @ConstructorProperties({"tipo", "nome", "nascimento", "idTutor"})
    public AnimalCriacao(TipoAnimal tipo, String nome, LocalDate nascimento, Long idTutor) {
        this.tipo = tipo;
        this.nome = nome;
        this.nascimento = nascimento;
        this.idTutor = idTutor;
    }
}
