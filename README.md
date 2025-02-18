E-commerce API
Este projeto é um sistema de e-commerce que permite o cadastro de produtos e clientes, além de realizar operações básicas como consulta, atualização e exclusão.

📌 Descrição
A API foi desenvolvida para gerenciar produtos e clientes de um sistema de e-commerce. Ela permite:

Cadastro, listagem e exclusão de produtos.
Cadastro, consulta e atualização de clientes.

⚙️ Como Rodar o Projeto
Clone o repositório:
git clone git@github.com:lviniciuszup/ecommerce-api.git.

Inicie a aplicação:
mvn spring-boot:run
A API estará disponível em: http://localhost:8080

📌 Endpoints Disponíveis

📦 Produtos
1. Listar Produtos
Método: GET
URL: /produtos
Descrição: Retorna a lista de produtos cadastrados.
Exemplo de Resposta:

[
  {
    "id": 1,
    "name": "Produto A",
    "price": 100.50,
    "quantity": 10
  },
  {
    "id": 2,
    "name": "Produto B",
    "price": 50.00,
    "quantity": 5
  }
]
2. Cadastrar Produto
Método: POST
URL: /produtos
Descrição: Cadastra um novo produto.
Exemplo de Requisição:


{
  "name": "Produto A",
  "price": 100.50,
  "quantity": 10
}
Exemplo de Resposta:


{
  "id": 1,
  "name": "Produto A",
  "price": 100.50,
  "quantity": 10
}
3. Deletar Produto
Método: DELETE
URL: /produtos/{id}
Descrição: Deleta um produto pelo ID.
Exemplo de Resposta:
Status: 204 No Content

🧑 Clientes
1. Cadastrar Cliente
Método: POST
URL: /clientes
Descrição: Cadastra um novo cliente.
Exemplo de Requisição:

{
  "name": "João Silva",
  "cpf": "12345678900",
  "email": "joao.silva@example.com"
}
Exemplo de Resposta:

{
  "id": 1,
  "name": "João Silva",
  "cpf": "12345678900",
  "email": "joao.silva@example.com"
}
2. Consultar Cliente pelo CPF
Método: GET
URL: /clientes/{cpf}
Descrição: Retorna os dados de um cliente pelo CPF.
Exemplo de Resposta:

{
  "id": 1,
  "name": "João Silva",
  "cpf": "12345678900",
  "email": "joao.silva@example.com"
}
3. Atualizar Cliente
Método: PUT
URL: /clientes/{cpf}
Descrição: Atualiza os dados de um cliente.
Exemplo de Requisição:

{
  "name": "João Silva",
  "email": "joao.silva@novoemail.com"
}
Exemplo de Resposta:

{
  "id": 1,
  "name": "João Silva",
  "cpf": "12345678900",
  "email": "joao.silva@novoemail.com"
}
📜 Regras de Negócio
Produtos:

Não é permitido cadastrar produtos com o mesmo nome.
O preço do produto deve ser maior que 0.
A quantidade do produto deve ser maior ou igual a 0.
Clientes:

Clientes devem possuir um CPF e e-mail únicos e válidos.
🛠️ Tecnologias Utilizadas
Java 17
Spring Boot
Maven
H2 Database
