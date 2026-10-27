package com.example.instituto_mao_amiga_api.Repository;

import com.example.instituto_mao_amiga_api.Model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PontoRepository extends JpaRepository<Ponto, UUID> {
}
