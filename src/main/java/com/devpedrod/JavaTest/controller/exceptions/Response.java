package com.devpedrod.JavaTest.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {

    private LocalDateTime timeStamp;
    @Schema(example = "NOT_FOUND")
    private HttpStatus status;
    @Schema(example = "404")
    private int statusCode;
    @Schema(example = "Object not found")
    private String message;
    @Schema(example = "/api/v1/fretes")
    private String path;
}
