package com.example.instituto_mao_amiga_api.config;

import com.example.instituto_mao_amiga_api.Entity.Ponto;
import com.example.instituto_mao_amiga_api.Repository.PontoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CargaInicial {

    @Bean
    CommandLineRunner carregarPontos(PontoRepository repository) {

        return args -> {

            if (repository.count() > 0) {
                return;
            }

            List<Ponto> pontos = List.of(

                    new Ponto(null, "Ponto de Coleta Centro",
                            "Avenida Goiás, 100", "Centro",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ecoponto Jardim América",
                            "Rua C-150, 200", "Jardim América",
                            "Seg a Sex, 8h às 18h", "coleta"),

                    new Ponto(null, "Ponto Verde Vila Nova",
                            "Rua 227, 150", "Vila Nova",
                            "Seg a Sáb, 8h às 17h", "distribuição"),

                    new Ponto(null, "Coleta Sustentável Bueno",
                            "Avenida T-4, 300", "Setor Bueno",
                            "Seg a Sex, 9h às 18h", "coleta"),

                    new Ponto(null, "Reciclagem Campinas",
                            "Avenida 24 de Outubro, 400", "Campinas",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto Solidário Universitário",
                            "Rua 10, 250", "Setor Universitário",
                            "Seg a Sex, 8h às 17h", "distribuição"),

                    new Ponto(null, "Ecoponto Jardim Goiás",
                            "Avenida Jamel Cecílio, 500", "Jardim Goiás",
                            "Seg a Sáb, 8h às 18h", "coleta"),

                    new Ponto(null, "Ponto de Doação Aeroporto",
                            "Avenida São Francisco, 180", "Santa Genoveva",
                            "Seg a Sex, 9h às 17h", "distribuição"),

                    new Ponto(null, "Coleta Recanto do Bosque",
                            "Rua RB-10, 120", "Recanto do Bosque",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto Verde Parque Amazônia",
                            "Avenida Feira de Santana, 220", "Parque Amazônia",
                            "Seg a Sáb, 8h às 17h", "coleta"),

                    new Ponto(null, "Ecoponto Jardim Novo Mundo",
                            "Avenida New York, 350", "Jardim Novo Mundo",
                            "Seg a Sex, 8h às 18h", "coleta"),

                    new Ponto(null, "Doação Setor Oeste",
                            "Rua 9, 180", "Setor Oeste",
                            "Seg a Sex, 9h às 17h", "distribuição"),

                    new Ponto(null, "Coleta Parque Atheneu",
                            "Rua 105, 100", "Parque Atheneu",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto Solidário Finsocial",
                            "Rua VF-15, 200", "Finsocial",
                            "Seg a Sáb, 8h às 17h", "distribuição"),

                    new Ponto(null, "Ecoponto Urias Magalhães",
                            "Avenida Perimetral Norte, 400", "Urias Magalhães",
                            "Seg a Sex, 8h às 18h", "coleta"),

                    new Ponto(null, "Reciclagem Pedro Ludovico",
                            "Avenida Circular, 150", "Pedro Ludovico",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto de Doação Leste Universitário",
                            "Rua 235, 180", "Leste Universitário",
                            "Seg a Sex, 9h às 17h", "distribuição"),

                    new Ponto(null, "Coleta Setor Sul",
                            "Rua 90, 300", "Setor Sul",
                            "Seg a Sáb, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto Verde Alto da Glória",
                            "Avenida São João, 250", "Alto da Glória",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ecoponto Vila Redenção",
                            "Rua 1, 120", "Vila Redenção",
                            "Seg a Sex, 8h às 18h", "coleta"),

                    new Ponto(null, "Doação Jardim Guanabara",
                            "Avenida Vera Cruz, 200", "Jardim Guanabara",
                            "Seg a Sex, 9h às 17h", "distribuição"),

                    new Ponto(null, "Coleta Setor Pedro Ludovico",
                            "Rua 104, 180", "Pedro Ludovico",
                            "Seg a Sex, 8h às 17h", "coleta"),

                    new Ponto(null, "Ponto Solidário Balneário Meia Ponte",
                            "Rua do Comércio, 100", "Balneário Meia Ponte",
                            "Seg a Sáb, 8h às 17h", "distribuição"),

                    new Ponto(null, "Reciclagem Setor Coimbra",
                            "Avenida Castelo Branco, 350", "Setor Coimbra",
                            "Seg a Sex, 8h às 18h", "coleta"),

                    new Ponto(null, "Ponto Verde Nova Suíça",
                            "Avenida T-63, 400", "Nova Suíça",
                            "Seg a Sex, 8h às 17h", "coleta")
            );

            repository.saveAll(pontos);

            System.out.println("Carga inicial de pontos realizada com sucesso!");
        };
    }

}

