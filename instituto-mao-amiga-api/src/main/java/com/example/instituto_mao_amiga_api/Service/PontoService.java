package com.example.instituto_mao_amiga_api.Service;

import com.example.instituto_mao_amiga_api.Model.Ponto;
import com.example.instituto_mao_amiga_api.Repository.PontoRepository;
import com.example.instituto_mao_amiga_api.dto.PontoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class PontoService {

    private final PontoRepository pontoRepository;

    public PontoService(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public Page<PontoResponseDTO> findAll(
            int page, int size, String sort) {

        int tamanho = Math.max(1, Math.min(size, 50));
        int pagina = Math.max(0, page);

        Pageable pageable = PageRequest.of(
                pagina,
                tamanho,
                Sort.by("nome").ascending()
        );

        Page<Ponto> pontos = pontoRepository.findAll(pageable);

        return pontos.map(PontoResponseDTO::toDto);
    }

    public PontoResponseDTO findById(UUID id) {
        Ponto ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ponto não encontrado"
                ));

        return PontoResponseDTO.toDto(ponto);
    }
}

