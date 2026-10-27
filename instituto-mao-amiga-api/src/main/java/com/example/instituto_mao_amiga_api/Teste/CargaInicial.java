package com.example.instituto_mao_amiga_api.Teste;

import com.example.instituto_mao_amiga_api.Model.Ponto;
import com.example.instituto_mao_amiga_api.Repository.PontoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CargaInicial {

    @Bean
    CommandLineRunner carregarProdutos(PontoRepository repository){
        return args -> {
            if(repository.count() > 0){
                return;
            }

            List<Ponto> pontos = new ArrayList<>();

            String[] nomes = {

                    "Ponto de Coleta Centro",
                    "Ponto de Coleta Zona Norte",
                    "Ponto de Coleta Zona Sul",
                    "Ponto de Coleta Zona Leste",
                    "Ponto de Coleta Zona Oeste",
                    "Coleta Recicla Mais",
                    "Ecoponto Municipal",
                    "Ponto Verde",
                    "Estação da Reciclagem",
                    "Coleta Sustentável",
                    "Ponto de Coleta Bairro Novo",
                    "Ponto de Coleta Jardim América",
                    "Ponto de Coleta Vila Nova",
                    "Ponto de Coleta São José",
                    "Ponto de Coleta Boa Vista",
                    "Ecoponto Esperança",
                    "Ponto de Coleta Primavera",
                    "Ponto de Coleta Santa Maria",
                    "Ponto de Coleta Industrial",
                    "Ponto de Coleta Universitário",
                    "Reciclagem Cidadã",
                    "Ponto Limpo",
                    "Eco Coleta",
                    "Ponto de Coleta Comunitário",
                    "Central de Reciclagem",
                    "Ponto de Coleta Jardim das Flores",
                    "Ponto de Coleta Planalto",
                    "Ponto de Coleta Liberdade",
                    "Ponto de Coleta São Pedro",
                    "Ponto de Coleta São Paulo",
                    "Ecoponto Reciclar",
                    "Ponto de Coleta Bela Vista",
                    "Ponto de Coleta Alvorada",
                    "Ponto de Coleta Morumbi",
                    "Ponto de Coleta Palmeiras",
                    "Ponto de Coleta Floresta",
                    "Ponto de Coleta Aeroporto",
                    "Ponto de Coleta Rodoviária",
                    "Ponto de Coleta Mercado Municipal",
                    "Ponto de Coleta Parque Central",
                    "Ponto de Coleta Lago Azul",
                    "Ponto de Coleta Industrial Norte",
                    "Ponto de Coleta Industrial Sul",
                    "Ponto de Coleta Santa Clara",
                    "Ponto de Coleta Nova Esperança",
                    "Ponto de Coleta São Francisco",
                    "Ponto de Coleta Bela União",
                    "Ponto de Coleta Recanto Verde",
                    "Ponto de Coleta Vila Rica",
                    "Ponto de Coleta Sustentável"
            };

            for (int i=0; i<50; i++){
                Ponto ponto = new Ponto();

                String nome = nomes[i % nomes.length];

                ponto.setNome(nome + " " + (i + 1));
                ponto.setEndereco("Rua Exemplo, " + (100 + i));
                ponto.setHorario(i < 10
                        ? "08:00 às 17:00"
                        : "09:00 às 18:00");

                ponto.setRecebeDistribui(String.valueOf(BigDecimal.valueOf(i % 2 == 0 ? 1 : 0)));

                ponto.setLatitude(-23.5505 + (i * 0.001));
                ponto.setLongitude(-46.6333 + (i * 0.001));

                pontos.add(ponto);
            }


            repository.saveAll(pontos);
        };

    }

}

