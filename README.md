
# Instituto Mão Amiga — API

## Sobre o projeto

API REST desenvolvida para o Instituto Mão Amiga, com o objetivo de gerenciar pontos de coleta e doações.

O projeto permite cadastrar, consultar, atualizar, excluir e filtrar pontos de coleta e doações, além de oferecer paginação, ordenação e validação dos dados enviados.

A API foi desenvolvida para integrar o aplicativo mobile do Instituto Mão Amiga, centralizando o armazenamento e o gerenciamento das informações.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Lombok
- Bean Validation
- Swagger / OpenAPI
- Maven

## Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/matheusaraujo00727/Instituto-m-o-amiga-API.git
   ```

2. Abra o projeto no IntelliJ IDEA.
3. Aguarde o Maven baixar as dependências.
4. Execute a classe principal da aplicação.
5. A API estará disponível em:

   `http://localhost:8080`

## Banco de dados

O projeto utiliza o banco de dados H2 em modo arquivo, permitindo manter os dados mesmo após reiniciar a aplicação.

Console do H2:

`http://localhost:8080/h2-console`

## Documentação Swagger

A documentação interativa da API pode ser acessada em:

`http://localhost:8080/swagger-ui/index.html`

## Endpoints — Pontos

Base URL:

`/api/v1/pontos`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/v1/pontos` | Lista todos os pontos |
| GET | `/api/v1/pontos/{id}` | Busca um ponto pelo ID |
| POST | `/api/v1/pontos` | Cadastra um ponto |
| PUT | `/api/v1/pontos/{id}` | Atualiza um ponto |
| DELETE | `/api/v1/pontos/{id}` | Exclui um ponto |
| GET | `/api/v1/pontos/filtro` | Filtra e pagina os pontos |

## Filtro e paginação — Pontos

O endpoint `/api/v1/pontos/filtro` permite pesquisar pontos pelo nome ou bairro, sem diferenciar letras maiúsculas e minúsculas.

Parâmetros:

- `filtro`: texto utilizado na pesquisa.
- `page`: número da página, começando em 0.
- `size`: quantidade de registros por página.
- `sort`: campo e direção da ordenação.

Exemplos:

**Listar sem filtro:**
`GET /api/v1/pontos/filtro`

**Pesquisar por nome ou bairro:**
`GET /api/v1/pontos/filtro?filtro=centro`

**Ordenar por bairro:**
`GET /api/v1/pontos/filtro?sort=bairro,asc`

**Acessar a segunda página:**
`GET /api/v1/pontos/filtro?page=1&size=10`

## Endpoints — Doações

Base URL:

`/api/v1/doacoes`

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/api/v1/doacoes` | Lista todas as doações |
| GET | `/api/v1/doacoes/{id}` | Busca uma doação pelo ID |
| POST | `/api/v1/doacoes` | Cadastra uma doação |
| PUT | `/api/v1/doacoes/{id}` | Atualiza uma doação |
| DELETE | `/api/v1/doacoes/{id}` | Exclui uma doação |
| GET | `/api/v1/doacoes/filtro` | Filtra e pagina as doações |

## Filtro e paginação — Doações

O endpoint `/api/v1/doacoes/filtro` permite pesquisar doações pelo tipo de item, sem diferenciar letras maiúsculas e minúsculas.

Parâmetros:

- `filtro`: texto utilizado na pesquisa.
- `page`: número da página, começando em 0.
- `size`: quantidade de registros por página.
- `sort`: campo e direção da ordenação.

A listagem é ordenada por data de criação, da mais recente para a mais antiga.

Exemplos:

**Listar sem filtro:**
`GET /api/v1/doacoes/filtro`

**Pesquisar por tipo de item:**
`GET /api/v1/doacoes/filtro?filtro=alimento`

**Acessar a segunda página:**
`GET /api/v1/doacoes/filtro?page=1&size=10`

## Validações e respostas HTTP

As requisições passam por validações para garantir a integridade dos dados.

| Código | Significado |
|---|---|
| 200 | Requisição realizada com sucesso |
| 201 | Registro criado com sucesso |
| 204 | Registro excluído com sucesso |
| 400 | Dados enviados inválidos |
| 404 | Registro não encontrado |

### Validações de doações

- O tipo do item é obrigatório.
- A quantidade é obrigatória e deve ser maior que zero.
- O ponto de destino é obrigatório.
- O identificador da doação é gerado automaticamente.
- A data de criação é preenchida pela API.

## Dados iniciais

A aplicação possui dados iniciais para facilitar os testes e a demonstração das funcionalidades.

São disponibilizados pontos de coleta e registros de doações para consulta e utilização durante a execução da API.

## Evidências dos testes

As capturas de tela dos testes realizados no Swagger demonstram:

- Operações CRUD de pontos de coleta.
- Operações CRUD de doações.
- Validações de campos obrigatórios.
- Respostas de erro 400 e 404.
- Filtro por nome e bairro dos pontos.
- Filtro por tipo de item das doações.
- Paginação e ordenação dos resultados.

<img width="1202" height="880" alt="Captura de tela 2026-11-15 221615" src="https://github.com/user-attachments/assets/75636447-bbc1-4496-811b-34c4857810cf" />
<img width="1262" height="916" alt="Captura de tela 2026-11-15 221157" src="https://github.com/user-attachments/assets/e05060c0-aef2-4518-99df-fc1323aa6b66" />
<img width="1191" height="941" alt="Captura de tela 2026-11-15 221038" src="https://github.com/user-attachments/assets/1b191a53-38d8-4712-b704-fde4de1c1a3f" />
<img width="1322" height="913" alt="Captura de tela 2026-11-15 220907" src="https://github.com/user-attachments/assets/625534d9-8caa-4116-8ef8-7785c3ff6c34" />
<img width="1237" height="856" alt="Captura de tela 2026-11-15 215339" src="https://github.com/user-attachments/assets/2a2fb357-7824-4329-85e7-e9f6c6f9a22c" />
<img width="1180" height="920" alt="Captura de tela 2026-11-15 215324" src="https://github.com/user-attachments/assets/2bdf8ad7-2a75-481c-a9bf-336ce64810be" />
<img width="1200" height="820" alt="Captura de tela 2026-11-15 215252" src="https://github.com/user-attachments/assets/0ef34f6f-1d9f-4498-8380-49108af6790d" />
<img width="1127" height="860" alt="Captura de tela 2026-11-15 214805" src="https://github.com/user-attachments/assets/ff221a4e-1f5d-464d-8624-8934d65dd194" />
<img width="1011" height="697" alt="Captura de tela 2026-11-15 214723" src="https://github.com/user-attachments/assets/2d456092-a6ec-46f4-adc1-772a0d8dc0d3" />
