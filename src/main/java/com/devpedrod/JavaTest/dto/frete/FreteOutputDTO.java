package com.devpedrod.JavaTest.dto.frete;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
public class FreteOutputDTO {
    private Double vlTotalFrete;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataPrevistaEntrega;
    private String cepOrigem;
    private String cepDestino;
}
