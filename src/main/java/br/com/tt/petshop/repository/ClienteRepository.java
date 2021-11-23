package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// @Repository - não precisa colocar quando estender uma interface de jpa
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf (String cpf);
    //findDistinctByCpfOrTelefoneOrderById -- exemplo

}
