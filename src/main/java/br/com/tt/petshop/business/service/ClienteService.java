package br.com.tt.petshop.business.service;

import br.com.tt.petshop.business.client.credito.CreditoApiClient;
import br.com.tt.petshop.business.client.credito.SituacaoCliente;
import br.com.tt.petshop.business.dto.ClienteAtualizacao;
import br.com.tt.petshop.business.dto.ClienteCriacao;
import br.com.tt.petshop.business.dto.ClienteDetalhes;
import br.com.tt.petshop.business.dto.ClienteListagem;
import br.com.tt.petshop.business.exception.NaoExisteException;
import br.com.tt.petshop.business.exception.NegocioException;
import br.com.tt.petshop.business.factory.ClienteFactory;
import br.com.tt.petshop.infra.model.Cliente;
import br.com.tt.petshop.infra.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final CreditoApiClient creditoApiClient;

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
                .orElseThrow(()-> new NaoExisteException("O cliente informado não existe!"));
    }

    /*
    public Long criar(ClienteCriacao dto) {
        Cliente cliente = ClienteFactory.criarCliente(dto);
        clienteRepository.save(cliente);
        return cliente.getId();
    }

     */

    public Long criar(ClienteCriacao clienteCriacao) {

        if (clienteCriacao.getCpf() == null){
            throw new NegocioException("CPF inválido!");
        }

        SituacaoCliente situacao = creditoApiClient.obterSituacaoCredito(clienteCriacao.getCpf());

        log.info("Situação: {}", situacao);

        if(situacao.estaInadimplente()){
            throw new NegocioException("Usuário possui pendências e não pode ser cadastrado!");
        }

        Cliente cliente = ClienteFactory.criarCliente(clienteCriacao);
        Cliente clienteSalvo = clienteRepository.save(cliente);

        return clienteSalvo.getId();
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

    public void atualizar(Long id, ClienteAtualizacao cliente) {

        Cliente clienteASerAtualizado = clienteRepository.findById(id).orElseThrow();

        //SEM LOMBOK:
        /*
        Cliente clienteAtualizado = new Cliente(id
                , cliente.getNome()
                , cliente.getNascimento()
                , cliente.getTelefone()
                , clienteASerAtualizado.getCpf());*/
        //COM LOMBOK:
        Cliente clienteAtualizado = clienteASerAtualizado
                .toBuilder()
                .nome(cliente.getNome())
                .nascimento(cliente.getNascimento())
                .telefone(cliente.getTelefone())
                .build();

        clienteRepository.save(clienteAtualizado);

    }

    /*
    @Transactional - vai fazer todas as operações no mesma conexão
                    dando commit só no final
     */
    @Transactional
    public void atualizar2(Long id, ClienteAtualizacao dto) {
        clienteRepository.findById(id)
                .ifPresent(cliente -> clienteRepository.delete(cliente));

        clienteRepository.save( new Cliente(id,
                dto.getNome(),
                dto.getNascimento(),
                dto.getTelefone(),null));
    }

    public Cliente buscarEntidadePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NegocioException("O cliente não existe!"));
    }
}
