O projeto é uma aplicação Java que implementa um sistema de gerenciamento de vendas, clientes e produtos. A seguir, uma descrição detalhada dos principais componentes e funcionalidades do projeto:

### Estrutura do Projeto

#### Pacotes Principais
- `br.com.gpaiva.dao`: Contém as classes de acesso a dados (DAO) que interagem com o banco de dados.
- `br.com.gpaiva.domain`: Define as entidades do domínio, como `Cliente`, `Produto` e `Venda`.
- `br.com.gpaiva.exceptions`: Define exceções personalizadas para o tratamento de erros específicos.
- `br.com.gpaiva.services`: Contém as classes de serviço que encapsulam a lógica de negócios.
- `br.com.gpaiva.services.generic`: Define interfaces e classes genéricas para os serviços.
- `br.com.gpaiva`: Contém classes de teste para validar a funcionalidade do sistema.

### Principais Classes e Interfaces

#### DAO (Data Access Object)
- `ClienteDAO`, `ProdutoDAO`, `VendaDAO`: Implementam a interface `IGenericDAO` para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados.
- `ClienteDaoMock`, `ProdutoDaoMock`: Implementações mock para testes unitários.

#### Domain
- `Cliente`: Representa um cliente com atributos como CPF, nome, endereço, etc.
- `Produto`: Representa um produto com atributos como código, nome, descrição, valor, etc.
- `Venda`: Representa uma venda, contendo informações sobre o cliente, produtos, valor total, status, etc.

#### Exceptions
- `DAOException`, `MaisDeUmRegistroException`, `TableException`, `TipoChaveNaoEncontradaException`, `TipoElementoNaoConhecidoException`: Exceções personalizadas para diferentes cenários de erro.

#### Services
- `ClienteService`, `ProdutoService`: Implementam a lógica de negócios para clientes e produtos, respectivamente.
- `GenericService`: Classe abstrata que fornece implementação básica para os serviços.
- `IClienteService`, `IProdutoService`: Interfaces que definem os métodos de serviço para clientes e produtos.

### Funcionalidades Principais

#### Gerenciamento de Clientes
- Cadastrar, alterar, excluir e consultar clientes.
- Buscar todos os clientes cadastrados.

#### Gerenciamento de Produtos
- Cadastrar, alterar, excluir e consultar produtos.
- Buscar todos os produtos cadastrados.

#### Gerenciamento de Vendas
- Criar, alterar, excluir e consultar vendas.
- Adicionar e remover produtos de uma venda.
- Calcular o valor total da venda.
- Finalizar e cancelar vendas.

### Testes
- `ClienteDAOTest`, `ProdutoDAOTest`, `VendaDAOTest`: Testes unitários para validar as operações de DAO.
- `ClienteServiceTest`, `ProdutoServiceTest`: Testes unitários para validar a lógica de negócios dos serviços.
- `AllTests`: Suite de testes que agrupa todos os testes unitários.

### Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **JUnit**: Framework para testes unitários.
- **JDBC**: API para conexão com o banco de dados.

### Observações
- O projeto utiliza uma abordagem orientada a objetos, com forte encapsulamento e separação de responsabilidades.
- As exceções personalizadas ajudam a tratar erros específicos de forma mais clara e controlada.
- Os testes unitários garantem a qualidade e a confiabilidade do código.

---
## Contribuições

Sinta-se à vontade para contribuir com melhorias. Faça um fork do projeto, crie uma branch para sua feature e envie um pull request.

---