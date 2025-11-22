# 🔗 ShorterUrl API

## 📝 Descrição

**ShorterUrl** é uma API RESTful robusta e performática desenvolvida para encurtar URLs longas, gerando códigos curtos e exclusivos que redirecionam o usuário para o destino original.

O backend foi construído com **Java + Spring Boot**, utilizando **MongoDB** como banco NoSQL para garantir alta performance e escalabilidade na persistência de URLs e estatísticas.

---

## ✨ Funcionalidades

- 🔹 **Encurtamento de URL** — Converte URLs longas em códigos curtos e fáceis de compartilhar  
- 🔹 **Redirecionamento Inteligente** — Retorna o usuário à URL original utilizando *HTTP 302 Found*  
- 🔹 **Estatísticas de Uso** — Exibe o número de cliques realizados em cada link  
- 🔹 **CRUD Completo** — Criar, visualizar, atualizar e deletar URLs encurtadas  

---

## 🚀 Tecnologias Utilizadas

| Categoria       | Tecnologia             | Versão |
|-----------------|-------------------------|--------|
| Linguagem       | Java                    | 17+    |
| Framework       | Spring Boot             | 3.x    |
| Banco de Dados  | MongoDB                 | Qualquer versão recente |
| Build Tool      | Maven                   | Qualquer versão recente |
| Outros          | Spring Data MongoDB, Lombok | — |

---

## 🛠️ Pré-requisitos

Antes de iniciar, você precisa ter instalado:

- **JDK 17+**
- **Apache Maven**
- **MongoDB** (local ou via Docker)

---

## 💻 Instalação

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/dmarqss/ShorterUrl.git
cd ShorterUrl
```

2️⃣ Configurar o Banco de Dados (MongoDB)

Edite o arquivo:
```bash
src/main/resources/application.properties
```
Exemplo:
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/shorterurl-db
```
Certifique-se de que o MongoDB está rodando.
3️⃣ Executar o Projeto

Compilar:
```bash
mvn clean install
```
Rodar a aplicação:
```bash
mvn spring-boot:run
```
A API ficará disponível em:

http://localhost:8080

🚀 Endpoints da API

| Operação               | Método   | URL                            | Descrição                                                                               |
| ---------------------- | -------- | ------------------------------ | --------------------------------------------------------------------------------------- |
| Criar URL curta        | `POST`   | `/urlShorter`                  | Cria uma nova URL curta. Deve passar no body: `{ "url": "<url original>" }`             |
| Obter URL original     | `GET`    | `/urlShorter/{shortUrl}`       | Retorna a URL original correspondente à `shortUrl`.                                     |
| Atualizar URL          | `PUT`    | `/urlShorter/{shortUrl}`       | Atualiza a URL original de uma `shortUrl` existente. Body: `{ "newUrl": "<nova URL>" }` |
| Deletar URL curta      | `DELETE` | `/urlShorter/{shortUrl}`       | Deleta a URL curta especificada.                                                        |
| Estatísticas de acesso | `GET`    | `/urlShorter/{shortUrl}/stats` | Retorna informações sobre uso da URL curta (por exemplo, número de acessos).            |



✍️ Autor

Desenvolvido por @dmarqss

📜 Licença

Este projeto está licenciado sob a licença MIT.
Consulte o arquivo LICENSE para mais detalhes.
