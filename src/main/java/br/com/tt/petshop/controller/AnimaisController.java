package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.Animais;
import br.com.tt.petshop.dto.ClienteAtualizacao;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteDetalhes;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.service.AnimaisService;
import br.com.tt.petshop.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animais")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AnimaisController {
    /*
    private final AnimaisService animaisService;

    @GetMapping
    public List<Animais> listar(@RequestParam(required = false) String nome){
        return animaisService.listar(nome);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Animais animal){
        Long idAnimal = animaisService.criar(animal);
        URI location = URI.create("/animais/"+idAnimal);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public Animais buscarPorId(@PathVariable("id") Long id){
        return animaisService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204 - retorno sem body
    public void atualizar(@PathVariable("id") Long id
            , @RequestBody Animais animal){
        animaisService.atualizar(id,animal);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        animaisService.apagar(id);
    }

     */
}
