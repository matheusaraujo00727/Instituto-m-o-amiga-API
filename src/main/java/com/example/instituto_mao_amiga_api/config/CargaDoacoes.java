package com.example.instituto_mao_amiga_api.config;

import com.example.instituto_mao_amiga_api.Entity.Doacao;
import com.example.instituto_mao_amiga_api.Repository.DoacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class CargaDoacoes {

    @Bean
    CommandLineRunner carregarDoacoes(DoacaoRepository repository) {

        return args -> {

            if (repository.count() > 0) {
                return;
            }

            List<Doacao> doacoes = List.of(

                    new Doacao(
                            null,
                            "Cesta básica",
                            5,
                            "Centro",
                            LocalDateTime.now().minusDays(3)
                    ),

                    new Doacao(
                            null,
                            "Roupas",
                            12,
                            "Jardim América",
                            LocalDateTime.now().minusDays(2)
                    ),

                    new Doacao(
                            null,
                            "Alimentos",
                            20,
                            "Setor Oeste",
                            LocalDateTime.now().minusDays(1)
                    ),

                    new Doacao(
                            null,
                            "Brinquedos",
                            8,
                            "Vila Nova",
                            LocalDateTime.now()
                    ),

                    new Doacao(
                            null,
                            "Material escolar",
                            15,
                            "Setor Bueno",
                            LocalDateTime.now()
                    )
            );

            repository.saveAll(doacoes);

            System.out.println("Carga inicial de doações realizada com sucesso!");
        };
    }
}
