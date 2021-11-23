package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByNomeContaining (String nome);
    List<Produto> findByValorBetween(BigDecimal valor1, BigDecimal valor2);
    List<Produto> findByAtivoFalse();
}
