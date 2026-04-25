# E-commerce API

Projeto de estudos desenvolvido para aprender na prática os fundamentos do desenvolvimento back-end com Java e Spring Boot. A ideia foi simular os fluxos reais de uma loja virtual — cadastro de produtos, clientes, pedidos e autenticação de usuários.

---

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Data JPA
- Spring Security
- JWT com a biblioteca jjwt 0.13.0
- BCrypt para criptografia de senhas
- MySQL
- SpringDoc OpenAPI para documentação via Swagger UI
- Maven

---

## O que o projeto faz

A API gerencia cinco domínios principais: produtos, categorias, variantes, clientes e pedidos.

Produtos podem ter múltiplas categorias e variantes. Cada pedido é vinculado a um cliente e contém uma lista de itens, onde cada item referencia uma variante específica do produto com quantidade e valor.

A autenticação é feita via JWT. O usuário faz login e recebe um token com validade de uma hora. Todas as rotas são protegidas exceto o cadastro, o login e a listagem de produtos. As senhas são salvas com hash BCrypt e as credenciais do banco e a chave do JWT ficam em variáveis de ambiente do sistema — nada sensível no código.

---

## Estrutura

```
src/main/java/br/com/projeto/ecommerce/
├── controller/      endpoints REST
├── model/           entidades JPA
├── service/         regras de negócio
├── dao/             repositórios Spring Data
└── security/        filtro JWT e configuração do Spring Security
```

---

## Endpoints principais

**Produtos**
- `GET /produtos?p={pagina}` — lista com paginação
- `GET /produtos/search?key={nome}` — busca por palavra-chave
- `POST /produtos` — cadastra produto
- `PUT /produtos/{id}` — atualiza produto

**Clientes**
- `GET /clientes` — lista todos
- `GET /clientes/{id}` — busca por ID
- `GET /clientes/busca?telefone={tel}` — busca por telefone
- `POST /clientes` — cadastra cliente
- `PUT /clientes/{id}` — atualiza cliente

**Pedidos**
- `POST /pedidos` — cria pedido com itens

**Usuário**
- `POST /usuario` — cadastro
- `POST /usuario/login` — login e geração do token JWT

---

