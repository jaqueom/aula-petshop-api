package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//(@Controlle + @ResponseBody)
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteListagem> listarClientes(@RequestParam(required = false) String nome){
        return clienteService.listarClientes(nome); //TODO nome
    }
    /*
    @GetMapping("/{id}")
    public ClienteDetalhes buscarPorId(@PathVariable("id") Long id){
        return null;
    }
    */

    //create
    @PostMapping
    public void criarCliente(@RequestBody ClienteCriacao cliente){
        clienteService.criar(cliente);
    }

    //Update parcial
    //Update total
    /*
    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") Long id
                        , @RequestBody ClienteAtualizacao cliente){
        clienteService.atualizar(id,cliente);
    }
    */

    //Delete
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        clienteService.apagar(id);
    }
}
