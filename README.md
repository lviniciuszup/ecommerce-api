# E-commerce API

Este projeto é um sistema de e-commerce que permite o cadastro de produtos e clientes, além de realizar operações básicas como consulta, atualização e exclusão.

---

## 📌 Descrição

A API foi desenvolvida para gerenciar produtos e clientes de um sistema de e-commerce. Ela permite:

- **Produtos**: Cadastro, listagem e exclusão.
- **Clientes**: Cadastro, consulta e atualização.

---

## ⚙️ Como Rodar o Projeto

1. **Clone o repositório:**  
   ```bash
   git clone git@github.com:lviniciuszup/ecommerce-api.git
   ```

2. **Acesse o diretório do projeto:**  
   ```bash
   cd ecommerce-api
   ```

3. **Inicie a aplicação:**  
   ```bash
   mvn spring-boot:run
   ```

4. **A API estará disponível em:**  
   [http://localhost:8080](http://localhost:8080)

---

## 📌 Endpoints Disponíveis

### 📦 Produtos

#### 📜 Listar Produtos
- **Método:** `GET`
- **URL:** `/produtos`
- **Descrição:** Retorna a lista de produtos cadastrados.
- **Exemplo de Resposta:**
  ```json
  [
    { "id": 1, "name": "Produto A", "price": 100.50, "quantity": 10 },
    { "id": 2, "name": "Produto B", "price": 50.00, "quantity": 5 }
  ]
  ```

#### ➕ Cadastrar Produto
- **Método:** `POST`
- **URL:** `/produtos`
- **Descrição:** Cadastra um novo produto.
- **Exemplo de Requisição:**
  ```json
  { "name": "Produto A", "price": 100.50, "quantity": 10 }
  ```
- **Exemplo de Resposta:**
  ```json
  { "id": 1, "name": "Produto A", "price": 100.50, "quantity": 10 }
  ```

#### ❌ Deletar Produto
- **Método:** `DELETE`
- **URL:** `/produtos/{id}`
- **Descrição:** Deleta um produto pelo ID.
- **Exemplo de Resposta:** `Status: 204 No Content`

---

### 🧑 Clientes

#### ➕ Cadastrar Cliente
- **Método:** `POST`
- **URL:** `/clientes`
- **Descrição:** Cadastra um novo cliente.
- **Exemplo de Requisição:**
  ```json
  { "name": "João Silva", "cpf": "12345678900", "email": "joao.silva@example.com" }
  ```
- **Exemplo de Resposta:**
  ```json
  { "id": 1, "name": "João Silva", "cpf": "12345678900", "email": "joao.silva@example.com" }
  ```

#### 🔍 Consultar Cliente pelo CPF
- **Método:** `GET`
- **URL:** `/clientes/{cpf}`
- **Descrição:** Retorna os dados de um cliente pelo CPF.
- **Exemplo de Resposta:**
  ```json
  { "id": 1, "name": "João Silva", "cpf": "12345678900", "email": "joao.silva@example.com" }
  ```

#### 🔄 Atualizar Cliente
- **Método:** `PUT`
- **URL:** `/clientes/{cpf}`
- **Descrição:** Atualiza os dados de um cliente.
- **Exemplo de Requisição:**
  ```json
  { "name": "João Silva", "email": "joao.silva@novoemail.com" }
  ```
- **Exemplo de Resposta:**
  ```json
  { "id": 1, "name": "João Silva", "cpf": "12345678900", "email": "joao.silva@novoemail.com" }
  ```

---

## 📜 Regras de Negócio

### 📦 Produtos:
- Não é permitido cadastrar produtos com o mesmo nome.
- O preço do produto deve ser maior que `0`.
- A quantidade do produto deve ser maior ou igual a `0`.

### 🧑 Clientes:
- Clientes devem possuir um CPF e e-mail únicos e válidos.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Maven**
- **H2 Database**

