package com.example.instituto_mao_amiga_api.Service;

import com.example.instituto_mao_amiga_api.Entity.Ponto;
import com.example.instituto_mao_amiga_api.Repository.PontoRepository;
import com.example.instituto_mao_amiga_api.dto.PontoRequestDTO;
import com.example.instituto_mao_amiga_api.dto.PontoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PontoService {

    private final PontoRepository pontoRepository;

    public List<PontoResponseDTO> findAll() {

        return pontoRepository.findAll()
                .stream()
                .map(PontoResponseDTO::toDto)
                .toList();
    }

    public PontoResponseDTO findById(UUID id) {

        Ponto ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ponto não encontrado"
                ));

        return PontoResponseDTO.toDto(ponto);
    }

    public PontoResponseDTO save(PontoRequestDTO dto) {

        Ponto ponto = Ponto.toEntity(dto);

        Ponto pontoSalvo = pontoRepository.save(ponto);

        return PontoResponseDTO.toDto(pontoSalvo);
    }

    public PontoResponseDTO update(UUID id, PontoRequestDTO dto) {

        Ponto ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ponto não encontrado"
                ));

        ponto.setNome(dto.nome());
        ponto.setEndereco(dto.endereco());
        ponto.setBairro(dto.bairro());
        ponto.setHorario(dto.horario());
        ponto.setTipo(dto.tipo());

        Ponto pontoAtualizado = pontoRepository.save(ponto);

        return PontoResponseDTO.toDto(pontoAtualizado);
    }

    public Page<PontoResponseDTO> findAll(Pageable pageable, String filtro) {

        Page<Ponto> pontos;

        if (filtro == null || filtro.isBlank()) {
            pontos = pontoRepository.findAll(pageable);
        } else {
            pontos = pontoRepository.buscarPorFiltro(filtro, pageable);
        }

        return pontos.map(PontoResponseDTO::toDto);
    }

    public void delete(UUID id) {

        Ponto ponto = pontoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ponto não encontrado"
                ));

        pontoRepository.delete(ponto);
    }
}

