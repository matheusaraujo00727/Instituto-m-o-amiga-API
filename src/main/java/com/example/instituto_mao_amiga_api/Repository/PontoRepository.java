package com.example.instituto_mao_amiga_api.Repository;

import com.example.instituto_mao_amiga_api.Entity.Ponto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PontoRepository extends JpaRepository<Ponto, UUID> {

    @Query("""
        SELECT p FROM Ponto p
        WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :filtro, '%'))
        OR LOWER(p.bairro) LIKE LOWER(CONCAT('%', :filtro, '%'))
    """)
    Page<Ponto> buscarPorFiltro(
            @Param("filtro") String filtro,
            Pageable pageable
    );
}

