package br.com.tt.petshop.client.petshop;

import br.com.tt.petshop.client.credito.SituacaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cao-api",
        url = "https://random.dog/woof.json")
public interface CaoApiClient {
    @GetMapping
    String obterUrlFotoCao();

}
