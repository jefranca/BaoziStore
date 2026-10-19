# Baozi Store API

API REST didática para clientes, produtos e pedidos usando Java 17, Spring Boot, Spring Data JPA e H2 (MySQL opcional).

## Executar

Requisitos: JDK 17+ e Maven 3.9+.

```bash
mvn spring-boot:run
```

A API fica em `http://localhost:8080`. H2 é em memória, portanto perde os dados ao encerrar. Console: `http://localhost:8080/h2-console`, JDBC URL `jdbc:h2:mem:baozistore`, usuário `sa`, senha vazia.

## Rotas

Todas as rotas têm prefixo `/api` e recebem/retornam JSON.

| Método | Rota | Ação |
|---|---|---|
| POST | `/clientes` | Cadastrar cliente |
| GET | `/clientes` | Listar clientes |
| GET | `/clientes/{id}` | Consultar cliente |
| DELETE | `/clientes/{id}` | Excluir cliente |
| POST | `/produtos` | Cadastrar produto |
| GET | `/produtos` | Listar produtos |
| GET | `/produtos/{id}` | Consultar produto |
| DELETE | `/produtos/{id}` | Excluir produto |
| POST | `/pedidos` | Registrar pedido |
| GET | `/pedidos` | Listar pedidos |
| GET | `/pedidos/{id}` | Consultar pedido |
| DELETE | `/pedidos/{id}` | Excluir pedido |

Cliente exemplo: `{"nome":"SEU_NOME+RU","clienteDesde":"2026-10-19"}`. Produto: `{"nome":"Baozi tradicional","preco":8.50,"estoque":true}`. Pedido: `{"clienteId":1,"produtoId":1,"quantidade":3}`.

Importe a coleção `postman/Baozi-Store.postman_collection.json`. Execute os POSTs antes dos GETs e DELETEs. Substitua `SEU_NOME+RU` pelo seu nome e RU antes de capturar as evidências para o PDF.

No H2 padrão, os dados são temporários. Para MySQL, configure `DB_URL`, `DB_USER` e `DB_PASSWORD` e inicie com `--spring.profiles.active=mysql`.
