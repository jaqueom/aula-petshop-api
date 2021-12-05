package br.com.tt.petshop.factory;

import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteDetalhes;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Cliente;

public class ClienteFactory {
    public static ClienteListagem criarClienteListagem (Cliente cliente){
        return new ClienteListagem(cliente.getId(), cliente.getNome(), cliente.getCpf());
    }

    public static ClienteDetalhes criarClienteDetalhes(Cliente cliente){
        return new ClienteDetalhes(cliente.getId(), cliente.getNome(), cliente.getNascimento(), cliente.getTelefone(), cliente.getCpf());
    }

    public static Cliente criarCliente(ClienteCriacao dto) {
        return new Cliente (dto.getId()
                          , dto.getNome()
                          , dto.getNascimento()
                          , dto.getTelefone()
                          , dto.getCpf());
    }
}
