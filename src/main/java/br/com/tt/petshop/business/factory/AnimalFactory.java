package br.com.tt.petshop.business.factory;

import br.com.tt.petshop.business.dto.AnimalCriacao;
import br.com.tt.petshop.business.dto.AnimalDetalhes;
import br.com.tt.petshop.business.dto.AnimalListagem;
import br.com.tt.petshop.infra.model.Animal;
import br.com.tt.petshop.infra.model.Cliente;

public class AnimalFactory {
    public static AnimalListagem criaAnimalListagem(Animal animal){
        return new AnimalListagem(animal.getId(), animal.getTipo(), animal.getNome());
    }

    public static AnimalDetalhes criaAnimalDetalhes(Animal animal) {
        return AnimalDetalhes.builder()
                .id(animal.getId())
                .nome(animal.getNome())
                .foto(animal.getFoto())
                .tipo(animal.getTipo())
                .nascimento(animal.getNascimento())
                .nomeTutor(animal.getTutor().getNome())
                .build();
    }

    public static Animal criaAnimal(AnimalCriacao criacao, String foto, Cliente tutor) {
        return new Animal(null, criacao.getTipo(),
                criacao.getNome(), criacao.getNascimento(),
                foto, tutor);
    }
}
