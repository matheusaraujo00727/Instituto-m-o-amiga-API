package com.example.instituto_mao_amiga_api.Model;


import com.example.instituto_mao_amiga_api.dto.PontoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pontos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false, length = 150)
    private String horario;

    @Column(nullable = false, length = 100)
    private String recebeDistribui;

    private Double latitude;

    private Double longitude;

    public static Ponto toEntity(PontoRequestDTO dto) {
        Ponto ponto = new Ponto();

        ponto.setNome(dto.nome());
        ponto.setEndereco(dto.endereco());
        ponto.setHorario(dto.horario());
        ponto.setRecebeDistribui(dto.recebeDistribui());
        ponto.setLatitude(dto.latitude());
        ponto.setLongitude(dto.longitude());

        return ponto;
    }
}
