package com.example.instituto_mao_amiga_api.Controller;

import com.example.instituto_mao_amiga_api.Service.PontoService;
import com.example.instituto_mao_amiga_api.dto.PontoRequestDTO;
import com.example.instituto_mao_amiga_api.dto.PontoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pontos")
@RequiredArgsConstructor
public class PontoController {

    private final PontoService pontoService;

    @GetMapping
    public List<PontoResponseDTO> findAll() {
        return pontoService.findAll();
    }

    @GetMapping("/{id}")
    public PontoResponseDTO findById(@PathVariable UUID id) {
        return pontoService.findById(id);
    }

    @GetMapping("/filtro")
    public Page<PontoResponseDTO> findAll(
            @RequestParam(required = false) String filtro,
            @ParameterObject
            @PageableDefault(
                    size = 10,
                    sort = "nome",
                    direction = Sort.Direction.ASC
            ) Pageable pageable) {

        return pontoService.findAll(pageable, filtro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontoResponseDTO save(
            @RequestBody @Valid PontoRequestDTO dto) {

        return pontoService.save(dto);
    }

    @PutMapping("/{id}")
    public PontoResponseDTO update(
            @PathVariable UUID id,
            @RequestBody @Valid PontoRequestDTO dto) {

        return pontoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        pontoService.delete(id);
    }
}

