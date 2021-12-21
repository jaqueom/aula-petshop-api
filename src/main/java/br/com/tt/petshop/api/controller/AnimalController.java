package br.com.tt.petshop.api.controller;

import br.com.tt.petshop.business.dto.AnimalCriacao;
import br.com.tt.petshop.business.dto.AnimalDetalhes;
import br.com.tt.petshop.business.dto.AnimalListagem;
import br.com.tt.petshop.infra.model.TipoAnimal;
import br.com.tt.petshop.business.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

//    @GetMapping
//    public List<AnimalListagem> listar(){
//        return animalService.listar();
//    }

    @GetMapping
    public List<AnimalListagem> listarComFiltros(@RequestParam(value = "nome", required = false) String nome,
                                                 @RequestParam(value = "nascimento", required = false) LocalDate nascimento,
                                                 @RequestParam(value = "tipo", required = false) TipoAnimal tipo,
                                                 @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
                                                 @RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho){

        return animalService.listarComFiltros(nome, nascimento, tipo, pagina, tamanho);
    }

    @GetMapping("/{id}")
    public AnimalDetalhes buscarPorId(@PathVariable("id") Long id){
        return animalService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid AnimalCriacao criacao){
        Long id = animalService.criar(criacao);
        String location = String.format("/animais/%d", id);
        return ResponseEntity.created(URI.create(location)).build();
    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void apagar(@PathVariable("id") Long id){
//        animalService.apagar(id);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void atualizar(@PathVariable("id") Long id,
//                          @RequestBody @Valid AnimalAtualizacao atualizacao){
//        animalService.atualizar(id, atualizacao);
//    }
}
