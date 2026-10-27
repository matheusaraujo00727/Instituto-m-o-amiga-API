package com.example.instituto_mao_amiga_api.dto;

import com.example.instituto_mao_amiga_api.Model.Ponto;

import java.util.UUID;

public record PontoResponseDTO (

    UUID pontoId,
    String nome,
    String endereco,
    String horario,
    String recebeDistribui,
    Double latitude,
    Double longitude
) {

        public static PontoResponseDTO toDto(Ponto ponto) {
            return new PontoResponseDTO(
                    ponto.getId(),
                    ponto.getNome(),
                    ponto.getEndereco(),
                    ponto.getHorario(),
                    ponto.getRecebeDistribui(),
                    ponto.getLatitude(),
                    ponto.getLongitude()
            );
        }
    }