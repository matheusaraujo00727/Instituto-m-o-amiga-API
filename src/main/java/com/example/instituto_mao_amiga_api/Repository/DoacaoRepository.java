package com.example.instituto_mao_amiga_api.Repository;

import com.example.instituto_mao_amiga_api.Entity.Doacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoacaoRepository extends JpaRepository<Doacao, UUID> {

    Page<Doacao> findByTipoItem(
            String tipoItem,
            Pageable pageable
    );
}
