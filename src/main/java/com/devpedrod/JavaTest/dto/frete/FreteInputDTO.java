package com.devpedrod.JavaTest.dto.frete;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreteInputDTO {
    @Schema(description = "Peso da encomenda em kg", example = "34.50")
    private Double peso;
    @Schema(description = "CEP de origem", example = "08090284")
    private String cepOrigem;
    @Schema(description = "CEP do destinatário", example = "07262130")
    private String cepDestino;
    @Schema(description = "Nome do destinatário", example = "João Pedro")
    private String nomeDestinatario;
}
