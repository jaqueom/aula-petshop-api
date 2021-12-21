package br.com.tt.petshop.business.factory;

import br.com.tt.petshop.business.dto.ClienteCriacao;
import br.com.tt.petshop.business.dto.ClienteDetalhes;
import br.com.tt.petshop.business.dto.ClienteListagem;
import br.com.tt.petshop.infra.model.Cliente;

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
