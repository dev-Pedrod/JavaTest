package com.devpedrod.JavaTest.dto.frete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreteInputDTO {
    @NotNull
    @NotBlank
    private Double peso;
    @NotNull
    @NotBlank
    private String cepOrigem;
    @NotNull
    @NotBlank
    private String cepDestino;
    @NotNull
    @NotBlank
    private String nomeDestinatario;
}
