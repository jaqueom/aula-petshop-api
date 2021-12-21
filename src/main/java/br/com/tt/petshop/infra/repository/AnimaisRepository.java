package br.com.tt.petshop.infra.repository;

import br.com.tt.petshop.infra.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaisRepository extends JpaRepository<Animal, Long> {
}
