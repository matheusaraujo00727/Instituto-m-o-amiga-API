package com.example.instituto_mao_amiga_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoacaoRequestDTO (

        @NotBlank(message = "O tipo do item é obrigatório")
        String tipoItem,

        @NotNull(message = "A quantidade é obrigatória")
        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Integer quantidade,

        @NotBlank(message = "O ponto de destino é obrigatório")
        String pontoDestino

) {
}
