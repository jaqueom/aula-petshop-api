package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ProdutoAtualizacao;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController//(@Controlle + @ResponseBody)
@RequestMapping("/produtos")
@Tag(name="Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<ProdutoDetalhes> listar(){
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/status")
    @Operation(description="Consulta produtos por status: ativos ou inativos ou TODOS")
    public List<ProdutoDetalhes> consultarProdutos(//@RequestParam(required = false) String nome,
                                                   @RequestParam(required = false) Status status){
        return produtoService.buscarProdutosPorStatus(status);
    }


    @GetMapping("/{id}")
    public ProdutoDetalhes buscarPorId(
            @PathVariable @Parameter(description = "Representa o ID do Produto") Long id){
        return produtoService.buscaPorId(id);
    }

    //create
    @PostMapping
    public ResponseEntity criarProduto(@RequestBody ProdutoCriacao produto){
        Long idProduto = produtoService.criar(produto);
        URI location = URI.create("/produtos/"+idProduto);
        return ResponseEntity.created(location).build();
    }

    //Update total
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204 - retorno sem body
    public void atualizar(@PathVariable("id") Long id
            , @RequestBody ProdutoAtualizacao produto){
        produtoService.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        produtoService.apagar(id);
    }

}
