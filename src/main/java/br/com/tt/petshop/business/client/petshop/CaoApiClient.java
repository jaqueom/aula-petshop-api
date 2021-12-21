package br.com.tt.petshop.business.client.petshop;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cao-api",
        url = "https://random.dog/woof.json")
public interface CaoApiClient {
    @GetMapping
    String obterUrlFotoCao();

}
