package com.devpedrod.JavaTest.consumer;

import com.devpedrod.JavaTest.dto.CepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep-consumer", url = "https://viacep.com.br/")
public interface ViaCepConsumer {

    @GetMapping(value = "/ws/{cep}/json")
    CepDTO getCep(@PathVariable("cep") String cep);
}
