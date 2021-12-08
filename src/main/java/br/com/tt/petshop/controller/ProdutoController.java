package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ClienteAtualizacao;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteDetalhes;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.dto.ProdutoAtualizacao;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.dto.ProdutoDetalhes;
import br.com.tt.petshop.dto.ProdutoListagem;
import br.com.tt.petshop.service.ClienteService;
import br.com.tt.petshop.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoDetalhes> listarProdutos(@RequestParam(required = false) String nome){
        return produtoService.listarProdutos(nome);
    }

    @GetMapping("/{status}")
    public List<ProdutoDetalhes> consultarProdutosPorStatus(@PathVariable String status){
        return produtoService.buscarPorStatus(status);
    }

    @GetMapping("/{id}")
    public ProdutoDetalhes buscarPorId(@PathVariable("id") Long id){
        return produtoService.buscaPorId(id);
    }

    //create
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
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
