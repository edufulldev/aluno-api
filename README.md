# 📘 Criando uma API REST - Gestão de Alunos e Matrículas

Este projeto consiste na criação de uma API RESTful para gerenciar **alunos** e suas respectivas **matrículas**. A aplicação permite cadastrar, consultar, atualizar e remover alunos e suas matrículas de forma simples e rápida.

## 🔧 Funcionalidades

- ✅ Cadastrar um aluno e sua matrícula
- 📋 Listar todos os alunos cadastrados
- 🔍 Listar todas as matrículas de um aluno a partir do seu ID
- ✏️ Atualizar os dados de um aluno
- ❌ Remover um aluno e sua matrícula associada

## 🛠️ Tecnologias utilizadas

- ☕ Java 21
- 🌱 Spring Boot
- 🛢️ H2 Database (banco de dados em memória)
- 🧰 Maven
- 🔁 REST Client (ex: VSCode REST Client ou Postman)

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

📬 Testando os Endpoints

✅ Cadastrar aluno com matrícula
POST http://localhost:8080/alunos

{
  "nome": "Eduardo cesar",
  "telefone": "190",
  "dataNascimento": "1980-09-10",
  "matriculas": [
    {
      "codigoMatricula": "123",
      "nomeCurso": "Java",
      "dataInicio": "2025-07-18"
    }
  ]
}

📋 Listar todos os alunos
GET http://localhost:8080/alunos

🔍 Listar todas as matrículas de um aluno
GET http://localhost:8080/alunos/1/matriculas

Altere o número 1 pelo ID do aluno desejado.

📌 Observações
A aplicação usa H2 como banco em memória, ideal para testes e desenvolvimento local.

As requisições podem ser testadas via REST Client, Postman ou Insomnia.
