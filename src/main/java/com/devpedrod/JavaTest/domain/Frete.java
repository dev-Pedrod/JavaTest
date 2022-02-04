package com.devpedrod.JavaTest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frete {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Schema(description = "Identificador do frete", example = "1")
    private Long id;
    
    @Schema(description = "Peso da encomenda em kg", example = "34.50")
    private Double peso;

    @Schema(description = "CEP de origem", example = "08090284")
    private String cepOrigem;

    @Schema(description = "CEP do destinatário", example = "07262130")
    private String cepDestino;

    @Schema(description = "Nome do destinatário", example = "João Pedro")
    private String nomeDestinatario;

    @Schema(description = "Valor total do frete", example = "77.50")
    private Double vlTotalFrete;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Schema(description = "Data prevista para entrega do produto", example = "14-02-2022")
    private LocalDate dataPrevistaEntrega;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    @Schema(description = "Data da última consulta", example = "13-02-2022")
    private LocalDateTime dataConsulta;
}
