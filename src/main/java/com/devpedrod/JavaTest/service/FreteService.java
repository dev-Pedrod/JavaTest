package com.devpedrod.JavaTest.service;

import com.devpedrod.JavaTest.consumer.ViaCepConsumer;
import com.devpedrod.JavaTest.domain.Frete;
import com.devpedrod.JavaTest.dto.CepDTO;
import com.devpedrod.JavaTest.dto.frete.FreteInputDTO;
import com.devpedrod.JavaTest.dto.frete.FreteOutputDTO;
import com.devpedrod.JavaTest.repository.FreteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static java.time.LocalDateTime.now;

@Service
public class FreteService {

    @Autowired
    private ViaCepConsumer cepConsumer;
    @Autowired
    private FreteRepository freteRepository;

    @Transactional(readOnly = true)
    public Page<Frete> findAll(Pageable pageable){
        Page<Frete> fretes = freteRepository.findAll(pageable);
        for(Frete x : fretes ){
            x.setDataConsulta(now());
            freteRepository.saveAndFlush(x);
        }
        return fretes;
    }

    @Transactional
    public FreteOutputDTO getFrete(FreteInputDTO freteInput){
        Frete frete = freteRepository.findByCepDestinoAndCepOrigemAndNomeDestinatario(
                freteInput.getCepDestino(), freteInput.getCepOrigem(), freteInput.getNomeDestinatario());
        if (frete != null){
            FreteOutputDTO output = new FreteOutputDTO();
            BeanUtils.copyProperties(frete, output);
            frete.setDataConsulta(now());
            freteRepository.saveAndFlush(frete);
            return output;
        }
        Frete freteNew = new Frete();
        FreteOutputDTO freteOutput = calculateFrete(freteInput);
        BeanUtils.copyProperties(freteOutput, freteNew);
        BeanUtils.copyProperties(freteInput, freteNew);
        freteNew.setDataConsulta(now());
        freteRepository.saveAndFlush(freteNew);
        return freteOutput;

    }

    public FreteOutputDTO calculateFrete(FreteInputDTO freteInput){
        double valorFrete;
        LocalDate dataPrevistaEntrega;

        CepDTO cepOrigem = cepConsumer.getCep(freteInput.getCepOrigem());
        CepDTO cepDestino = cepConsumer.getCep(freteInput.getCepDestino());

        if(cepDestino.getDdd().equals(cepOrigem.getDdd())){
            valorFrete = freteInput.getPeso() / 2;
            dataPrevistaEntrega = now().plusDays(1).toLocalDate();

        } else if(cepDestino.getUf().equals(cepOrigem.getUf()) && !cepDestino.getDdd().equals(cepOrigem.getDdd())) {
            valorFrete = freteInput.getPeso() / 4;
            dataPrevistaEntrega = now().plusDays(3).toLocalDate();
        } else {
            valorFrete = freteInput.getPeso();
            dataPrevistaEntrega = now().plusDays(10).toLocalDate();
        }
        return FreteOutputDTO.builder()
                .vlTotalFrete(valorFrete)
                .dataPrevistaEntrega(dataPrevistaEntrega)
                .cepDestino(cepDestino.getCep())
                .cepOrigem(cepOrigem.getCep()).build();
    }
}
