package com.example.instituto_mao_amiga_api.Controller;

import com.example.instituto_mao_amiga_api.Service.DoacaoService;
import com.example.instituto_mao_amiga_api.dto.DoacaoRequestDTO;
import com.example.instituto_mao_amiga_api.dto.DoacaoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doacoes")
@RequiredArgsConstructor
public class DoacaoController {

    private final DoacaoService doacaoService;

    @GetMapping
    public List<DoacaoResponseDTO> findAll() {
        return doacaoService.findAll();
    }

    @GetMapping("/{id}")
    public DoacaoResponseDTO findById(@PathVariable UUID id) {
        return doacaoService.findById(id);
    }

    @GetMapping("/filtro")
    public Page<DoacaoResponseDTO> findAll(
            @RequestParam(required = false) String filtro,
            @ParameterObject
            @PageableDefault(
                    size = 10,
                    sort = "criadoEm",
                    direction = Sort.Direction.DESC
            ) Pageable pageable) {

        return doacaoService.findAll(pageable, filtro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoacaoResponseDTO save(
            @RequestBody @Valid DoacaoRequestDTO dto) {

        return doacaoService.save(dto);
    }

    @PutMapping("/{id}")
    public DoacaoResponseDTO update(
            @PathVariable UUID id,
            @RequestBody @Valid DoacaoRequestDTO dto) {

        return doacaoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        doacaoService.delete(id);
    }
}
