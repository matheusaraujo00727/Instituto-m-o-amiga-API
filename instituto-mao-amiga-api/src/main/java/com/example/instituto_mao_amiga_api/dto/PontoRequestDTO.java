package com.example.instituto_mao_amiga_api.dto;

public record PontoRequestDTO(
        String nome,
        String endereco,
        String horario,
        String recebeDistribui,
        Double latitude,
        Double longitude
) {
}