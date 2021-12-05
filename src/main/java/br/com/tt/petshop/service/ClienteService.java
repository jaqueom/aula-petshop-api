package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteAtualizacao;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteDetalhes;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.factory.ClienteFactory;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteListagem> listarClientes(String nome){
        List<Cliente> clientes;
        if (nome == null){
            clientes = clienteRepository.findAll();
        }else{
            clientes = clienteRepository.findByNomeContaining(nome);
        }
        return clientes.stream()
                .map(ClienteFactory::criarClienteListagem)
                .collect(Collectors.toList());
    }

    public ClienteDetalhes buscarPorId(Long id){
        /*
        VERSÃO COMPLETA -- longaaaaaa
        Optional<Cliente> optCliente = clienteRepository.findById(id);

        //quais situações podem acontecer com um optional?

        if (optCliente.isEmpty()){
            //1 - vazio (empty)
            throw new RuntimeException("O cliente informado não existe!");
        }else{
            //2 - com objeto (Cliente) converter para ClienteDetalhes
            ClienteDetalhes clienteDetalhes = ClienteFactory.criarClienteDetalhes(optCliente.get());
            return clienteDetalhes;
        }
         */
        //VERSÃO RESUMIDA (faz a mesma coisa que ali em cima)
        return clienteRepository.findById(id)
                .map(ClienteFactory::criarClienteDetalhes)
                .orElseThrow(()-> new RuntimeException("O cliente informado não existe!"));
    }

    public void criar(ClienteCriacao dto) {
        Cliente cliente = ClienteFactory.criarCliente(dto);
        clienteRepository.save(cliente);
    }

    /*
    public void atualizar(Long id, ClienteAtualizacao dto) {
        Cliente cliente = ClienteFactory.criarCliente(dto);
        clienteRepository.save(cliente);
    }
    */

    public void apagar(Long id) {
        clienteRepository.deleteById(id);
    }
}
