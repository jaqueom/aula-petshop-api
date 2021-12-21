package br.com.tt.petshop.business.service;

import br.com.tt.petshop.business.dto.AnimalCriacao;
import br.com.tt.petshop.business.dto.AnimalDetalhes;
import br.com.tt.petshop.business.dto.AnimalListagem;
import br.com.tt.petshop.business.exception.NaoExisteException;
import br.com.tt.petshop.business.factory.AnimalFactory;
import br.com.tt.petshop.infra.model.Animal;
import br.com.tt.petshop.infra.model.Cliente;
import br.com.tt.petshop.infra.model.TipoAnimal;
import br.com.tt.petshop.infra.repository.AnimaisRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalService {

    private final AnimaisRepository animalRepository;
    private final ClienteService clienteService;

//    public List<AnimalListagem> listar() {
//        return animalRepository.findAll().stream()
//                .map(AnimalFactory::criaAnimalListagem)
//                .collect(Collectors.toList());
//    }

    public AnimalDetalhes buscarPorId(Long id) {
        return animalRepository.findById(id)
                .map(AnimalFactory::criaAnimalDetalhes)
                .orElseThrow(() -> new NaoExisteException("O Animal informado não existe!"));
    }

    public Long criar(AnimalCriacao criacao) {

        String foto = null;
        Cliente tutor = clienteService.buscarEntidadePorId(criacao.getIdTutor());

        Animal animal = AnimalFactory.criaAnimal(criacao, foto, tutor);
        Animal animalSalvo = animalRepository.save(animal);
        return animalSalvo.getId();
    }

    public List<AnimalListagem> listarComFiltros(String nome, LocalDate nascimento, TipoAnimal tipo, int pagina, int tamanho) {

        Animal objetoModelo = Animal.builder().nome(nome).nascimento(nascimento).tipo(tipo).build();

        return animalRepository.findAll(
                Example.of(objetoModelo, ExampleMatcher.matchingAny()), Pageable.ofSize(tamanho).withPage(pagina))
                .stream()
                .map(AnimalFactory::criaAnimalListagem)
                .collect(Collectors.toList()); //OR em todos os campos
    }

//
//    public void apagar(Long id) {
//        animalRepository.findById(id)
//                .ifPresent(animalRepository::delete);
//    }
//
//    public void atualizar(Long id, AgendamentoAtualizacao atualizacao) {
//
//    }
}
