package com.example.instituto_mao_amiga_api.Controller;

import com.example.instituto_mao_amiga_api.Service.PontoService;
import com.example.instituto_mao_amiga_api.dto.PontoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pontos")
@RequiredArgsConstructor
public class PontoController {

    private final PontoService pontoService;

    @GetMapping
    public Page<PontoResponseDTO> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "nome,asc") String sort) {

        return pontoService.findAll(page, size, sort);
    }

    @GetMapping("/{id}")
    public PontoResponseDTO findById(@PathVariable UUID id) {
        return pontoService.findById(id);
    }
}

