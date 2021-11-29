package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByNomeContaining (String nome);
    List<Produto> findByValorBetween(BigDecimal valor1, BigDecimal valor2);
    List<Produto> findByAtivoFalse();

    //Usando JPQL
    @Query("select pro from Produto pro where pro.ativo = true and pro.nome like %:nome%")
    List<Produto> listarProdutosAtivosPorNome(String nome);

    @Query(nativeQuery = true
            , value = "select * from tb_produto where ativo = true order by valor asc")
    List<Produto> listarProdutosAtivosPorPreco();

    @Query(nativeQuery = true
            , value = "select count(*) from tb_produto where ativo = false")
    long contarProdutosInativos();


}
