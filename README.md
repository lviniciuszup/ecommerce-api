# E-Commerce API

## 📌 Descrição
Este projeto um sistema de e-commerce, permitindo o cadastro de produtos, clientes.

## ⚙️ Como Rodar o Projeto
1. Clone o repositório:
   ```bash
   git clone <git@github.com:lviniciuszup/ecommerce-api.git>
   ```
2. A API estará disponível em: `http://localhost:8080`

## 📌 Endpoints Disponíveis
### 📦 Produtos
- `GET /produtos` → Retorna a lista de produtos
- `POST /produtos` → Cadastra um novo produto
- `DELETE /produtos/{id}` → Deleta um produto

### 🧑 Clientes
- `POST /clientes` → Cadastra um novo cliente
- `GET /clientes/{cpf}` → Retorna os dados de um cliente pelo CPF
- `PUT /clientes/{cpf}` → Atualiza os dados de um cliente

## 📜 Regras de Negócio
- Não é permitido cadastrar produtos com o mesmo nome.
- O preço do produto deve ser maior que 0.
- A quantidade do produto deve ser maior ou igual a 0.
- Clientes devem possuir um CPF e e-mail únicos e válidos.


