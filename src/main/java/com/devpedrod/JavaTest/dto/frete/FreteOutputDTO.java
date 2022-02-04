package com.devpedrod.JavaTest.dto.frete;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
public class FreteOutputDTO {
    @Schema(description = "Valor total do frete", example = "77.50")
    private Double vlTotalFrete;
    @JsonFormat(pattern="dd-MM-yyyy")
    @Schema(description = "Data prevista para entrega do produto", example = "14-02-2022")
    private LocalDate dataPrevistaEntrega;
    @Schema(description = "CEP de origem", example = "08090284")
    private String cepOrigem;
    @Schema(description = "CEP do destinatário", example = "07262130")
    private String cepDestino;
}
