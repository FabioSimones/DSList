# DSList — Backend (Intensivão Java Spring)

Este é o backend do projeto **DSList**, desenvolvido como parte do **Intensivão Java Spring** da DevSuperior. Ele oferece endpoints REST que permitem consultar jogos e gerenciar suas posições dentro de listas.

---

##  Visão Geral

O objetivo deste projeto é servir como referência de como estruturar uma aplicação backend com Spring Boot, utilizando boas práticas como camadas, DTOs, repositórios com queries nativas, e configuração de múltiplos perfis de ambiente (test, dev, prod) :contentReference[oaicite:1]{index=1}.

---

##  Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web, Data JPA)
- **Banco de dados H2 (teste)** e **PostgreSQL (desenvolvimento/produção)**
- Maven
- Arquivos de configuração (`.properties`)
- CORS configurado via `WebConfig`
- Seed de dados via `import.sql`
- Projeções, queries nativas, endpoints REST

---

##  Estrutura de Perfis (Ambientes)

### **Teste** (`test`)
- Usa **H2 em memória**
- Console H2 ativado e logs SQL visíveis  
- Configurado em `application-test.properties`  
  :contentReference[oaicite:2]{index=2}

### **Desenvolvimento** (`dev`)
- Conexão com **PostgreSQL**
- Detalhes como URL, usuário e senha configurados em `application-dev.properties`
  :contentReference[oaicite:3]{index=3}

### **Produção** (`prod`)
- Usa variáveis de ambiente para parâmetros sensíveis (DB_URL, DB_USERNAME, DB_PASSWORD)
- Configurado em `application-prod.properties`
  :contentReference[oaicite:4]{index=4}

---

##  Modelagem e Seed de Dados

![Modelo de domínio DSList](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

- **Entidades principais**:
  - `Game`, `GameList`, e tabela associativa `Belonging`, que define a posição dos jogos nas listas.
- **Database seeding** com jogos como *Mass Effect Trilogy*, *Red Dead Redemption 2*, *The Witcher 3*, entre outros, inseridos via `import.sql`, com suas posições definidas em `tb_belonging` :contentReference[oaicite:5]{index=5}.

---

##  Repositórios com Queries

- **GameRepository**: Query nativa usando `JOIN` entre jogos e pertencimentos, retornando projeções customizadas (GameMinProjection) para otimizar a listagem dos jogos por lista :contentReference[oaicite:6]{index=6}.
- **GameListRepository**: Query para atualizar a posição de um jogo dentro de uma lista (`UPDATE tb_belonging SET position = ...`) :contentReference[oaicite:7]{index=7}.

---

##  Configuração de CORS

Configurado via `WebConfig`, permitindo requisições de origens como `http://localhost:5173` ou `http://localhost:3000`, visando integração com um frontend separado :contentReference[oaicite:8]{index=8}.

---

##  Como Executar

```bash
# Clone o repositório
git clone https://github.com/devsuperior/dslist-backend.git
cd dslist-backend

# Testes com H2 em memória
./mvnw spring-boot:run -Dspring-boot.run.profiles=test

# Desenvolvimento com PostgreSQL
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

# Produção (variáveis de ambiente configuradas)
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

---
## Teste no Postman

### Busca de game pelo ID:
<img width="1474" height="686" alt="image" src="https://github.com/user-attachments/assets/38a92742-0b6f-4630-84e9-a3f42d1b7eca" />


### Exibindo lista de estilos de games:
<img width="1480" height="663" alt="image" src="https://github.com/user-attachments/assets/b741e601-361c-4545-a7cc-49010d738dc8" />


### Exibindo todos os games da lista:
<img width="1474" height="896" alt="image" src="https://github.com/user-attachments/assets/3e479cee-fe9a-46c4-9678-8fe5c128172f" />


### Buscando lista com filtro por estilo do game:
<img width="1474" height="874" alt="image" src="https://github.com/user-attachments/assets/b57f8d87-9474-4ba1-a9df-b7c68333c844" />


