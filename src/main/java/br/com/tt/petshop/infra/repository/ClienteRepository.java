package br.com.tt.petshop.infra.repository;

import br.com.tt.petshop.infra.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// @Repository - não precisa colocar quando estender uma interface de jpa
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf (String cpf);
    //findDistinctByCpfOrTelefoneOrderById -- exemplo

    //JPQL - valida em tempo de startup igual ao query method
    @Query("select c from Cliente c where c.cpf = :cpf and c.telefone is not null")
    Optional<Cliente> buscaPorCpfComTelefoneNaoNulo(String cpf);

    //SQL - o Spring não valida em tempo de startup
    @Query(nativeQuery = true, value = "select * from tb_cliente cli where cli.cpf=:cpf and cli.telefone is not null")
    Cliente buscaPorCpfComTelefoneNaoNuloSql(String cpf);

    List<Cliente> findByNomeContaining(String nome);
}
