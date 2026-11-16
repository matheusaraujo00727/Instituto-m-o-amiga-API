
# Instituto Mão Amiga — API

## Sobre o projeto

API REST desenvolvida para o Instituto Mão Amiga, com o objetivo de gerenciar pontos de coleta e distribuição de doações.

O projeto permite cadastrar, consultar, atualizar, excluir e filtrar pontos, além de oferecer paginação e ordenação dos resultados.

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

1. Abra o projeto no IntelliJ IDEA.
2. Aguarde o Maven baixar as dependências.
3. Execute a classe principal da aplicação.
4. A API estará disponível em:

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
| GET | `/api/v1/pontos/filtro` | Filtra, pagina e ordena os pontos |

## Filtro, paginação e ordenação

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

## Validações e respostas HTTP

| Código | Significado |
|---|---|
| 200 | Requisição realizada com sucesso |
| 201 | Registro criado com sucesso |
| 204 | Registro excluído com sucesso |
| 400 | Dados enviados inválidos |
| 404 | Registro não encontrado |

## Evidências dos testes

As capturas de tela dos testes realizados no Swagger serão organizadas na pasta `evidencias`, incluindo:

- Operações CRUD.
- Validações de campos obrigatórios.
- Respostas de erro 400 e 404.
- Filtro por nome e bairro.
- Paginação e ordenação.


<img width="1011" height="697" alt="Captura de tela 2026-11-15 214723" src="https://github.com/user-attachments/assets/dfc4280a-806d-44ee-93bc-13392ac81c4f" />
<img width="1127" height="860" alt="Captura de tela 2026-11-15 214805" src="https://github.com/user-attachments/assets/9463dfa5-f55a-4350-b2aa-4d5db84d8315" />
<img width="1200" height="820" alt="Captura de tela 2026-11-15 215252" src="https://github.com/user-attachments/assets/a379d7ef-a0e3-4f73-9b03-ff5520ae5190" />
<img width="1180" height="920" alt="Captura de tela 2026-11-15 215324" src="https://github.com/user-attachments/assets/87d769a4-80f3-43eb-a10a-cc8ad2fad1f7" />
<img width="1237" height="856" alt="Captura de tela 2026-11-15 215339" src="https://github.com/user-attachments/assets/1fce45fa-5338-4f95-a54c-8944a03e6c75" />
<img width="1322" height="913" alt="Captura de tela 2026-11-15 220907" src="https://github.com/user-attachments/assets/0467fbae-6be1-4af8-93a1-e6917d789c8d" />
<img width="1202" height="880" alt="Captura de tela 2026-11-15 221615" src="https://github.com/user-attachments/assets/7ea47dc9-dcd7-42c8-b269-10c789e76c63" />
<img width="1262" height="916" alt="Captura de tela 2026-11-15 221157" src="https://github.com/user-attachments/assets/7b2faf8c-4851-43f8-8609-2cab3cc43180" />
<img width="1191" height="941" alt="Captura de tela 2026-11-15 221038" src="https://github.com/user-attachments/assets/f0969fc7-d8f5-42c9-803e-cf873ce10cf3" />







