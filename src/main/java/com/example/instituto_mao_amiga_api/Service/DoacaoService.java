package com.example.instituto_mao_amiga_api.Service;

import com.example.instituto_mao_amiga_api.Entity.Doacao;
import com.example.instituto_mao_amiga_api.Repository.DoacaoRepository;
import com.example.instituto_mao_amiga_api.dto.DoacaoRequestDTO;
import com.example.instituto_mao_amiga_api.dto.DoacaoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;

    public List<DoacaoResponseDTO> findAll() {
        return doacaoRepository.findAll()
                .stream()
                .map(DoacaoResponseDTO::new)
                .toList();
    }

    public DoacaoResponseDTO findById(UUID id) {
        Doacao doacao = buscarDoacao(id);

        return new DoacaoResponseDTO(doacao);
    }

    public Page<DoacaoResponseDTO> findAll(
            Pageable pageable,
            String filtro
    ) {

        Page<Doacao> doacoes;

        if (filtro == null || filtro.isBlank()) {
            doacoes = doacaoRepository.findAll(pageable);
        } else {
            doacoes = doacaoRepository
                    .findByTipoItem(
                            filtro,
                            pageable
                    );
        }

        return doacoes.map(DoacaoResponseDTO::new);
    }

    public DoacaoResponseDTO save(DoacaoRequestDTO dto) {

        Doacao doacao = new Doacao();

        doacao.setTipoItem(dto.tipoItem());
        doacao.setQuantidade(dto.quantidade());
        doacao.setPontoDestino(dto.pontoDestino());
        doacao.setCriadoEm(LocalDateTime.now());

        Doacao salva = doacaoRepository.save(doacao);

        return new DoacaoResponseDTO(salva);
    }

    public DoacaoResponseDTO update(
            UUID id,
            DoacaoRequestDTO dto
    ) {

        Doacao doacao = buscarDoacao(id);

        doacao.setTipoItem(dto.tipoItem());
        doacao.setQuantidade(dto.quantidade());
        doacao.setPontoDestino(dto.pontoDestino());

        Doacao atualizada = doacaoRepository.save(doacao);

        return new DoacaoResponseDTO(atualizada);
    }

    public void delete(UUID id) {
        Doacao doacao = buscarDoacao(id);

        doacaoRepository.delete(doacao);
    }

    private Doacao buscarDoacao(UUID id) {
        return doacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Doação não encontrada"
                ));
    }
}
