package com.example.instituto_mao_amiga_api.dto;

import com.example.instituto_mao_amiga_api.Entity.Doacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record DoacaoResponseDTO (

        UUID id,
        String tipoItem,
        Integer quantidade,
        String pontoDestino,
        LocalDateTime criadoEm

) {

    public DoacaoResponseDTO(Doacao doacao) {
        this(
                doacao.getId(),
                doacao.getTipoItem(),
                doacao.getQuantidade(),
                doacao.getPontoDestino(),
                doacao.getCriadoEm()
        );
    }
}
