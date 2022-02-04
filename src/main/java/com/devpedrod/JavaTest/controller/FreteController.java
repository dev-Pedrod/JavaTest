package com.devpedrod.JavaTest.controller;

import com.devpedrod.JavaTest.controller.exceptions.Response;
import com.devpedrod.JavaTest.domain.Frete;
import com.devpedrod.JavaTest.dto.frete.FreteInputDTO;
import com.devpedrod.JavaTest.dto.frete.FreteOutputDTO;
import com.devpedrod.JavaTest.service.FreteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/fretes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @ResponseBody
    @Operation(summary = "Consulta todos fretes existentes no banco de dados")
    @ApiResponse(responseCode = "200", description = "Quando a operação é realizada com sucesso",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = Frete.class))}
    )
    @GetMapping("")
    public ResponseEntity<Page<Frete>> getAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(freteService.findAll(pageable));
    }

    @ResponseBody
    @Operation(summary = "Consulta o frete e salva no banco de dados caso já não exista.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quando a operação é realizada com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FreteOutputDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Quando o CEP não é encontrado",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))})
    })
    @PostMapping("")
    public ResponseEntity<FreteOutputDTO> postFrete(@RequestBody FreteInputDTO freteInput) {
        return ResponseEntity.ok(freteService.getFrete(freteInput));
    }
}
