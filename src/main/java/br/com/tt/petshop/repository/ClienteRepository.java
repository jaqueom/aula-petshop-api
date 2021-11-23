package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
