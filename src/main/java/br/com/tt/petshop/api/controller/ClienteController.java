package br.com.tt.petshop.api.controller;

import br.com.tt.petshop.business.dto.ClienteAtualizacao;
import br.com.tt.petshop.business.dto.ClienteCriacao;
import br.com.tt.petshop.business.dto.ClienteDetalhes;
import br.com.tt.petshop.business.dto.ClienteListagem;
import br.com.tt.petshop.business.service.ClienteService;
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

@RestController//(@Controlle + @ResponseBody)
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteListagem> listarClientes(@RequestParam(required = false) String nome){
        return clienteService.listarClientes(nome); //TODO nome
    }

    //create
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity criarCliente(@RequestBody ClienteCriacao cliente){
        Long idCliente = clienteService.criar(cliente);
        URI location = URI.create("/clientes/"+idCliente);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ClienteDetalhes buscarPorId(@PathVariable("id") Long id){
        return clienteService.buscarPorId(id);
    }

    //Update total
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204 - retorno sem body
    public void atualizar(@PathVariable("id") Long id
                        , @RequestBody ClienteAtualizacao cliente){
        clienteService.atualizar(id,cliente);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        clienteService.apagar(id);
    }
}
