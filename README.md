# 🔗 URL Shortener - Encurtador de URLs

Este é um serviço de encurtamento de URLs desenvolvido com **Java + Spring Boot**, utilizando **MongoDB** como banco de dados e rodando via **Docker**. Ele permite gerar URLs encurtadas e redirecionar os usuários para a URL original.

---

## 🚀 Funcionalidades

- 🔹 **Encurtamento de URL**: Recebe uma URL longa e gera um link encurtado.
- 🔹 **Redirecionamento**: Acessando a URL curta, o usuário é redirecionado para a original.
- 🔹 **Expiração automática**: URLs encurtadas possuem tempo de expiração.
- 🔹 **Armazenamento no MongoDB**: Persiste as URLs encurtadas em banco nao-relacional.
- 🔹 **API RESTful**: Estruturada seguindo boas práticas de desenvolvimento.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data MongoDB
- **MongoDB (via Docker)**
- **Jakarta Servlet**
- **Apache Commons Lang3** (para geração de IDs aleatórios)
- **Docker e Docker Compose**

---

## 📌 Você pode conferir o repositório do front end deste projeto clicando [aqui](https://github.com/victorMarchiDev/curta-link)

### ou se preferir, pode ir diretamente para o site em produção [Curta-Link](https://curta-link.vercel.app/)

