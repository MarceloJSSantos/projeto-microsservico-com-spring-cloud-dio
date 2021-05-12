## Sistema de e-commerce parcial c/ estrutura de microsserviços com Spring Cloud
Repositório com adequações (atualização de dependências) do projeto desenvolvido no curso "Microsserviços em Spring Cloud com Java" da [DIO](https://digitalinnovation.one/)

-----------------------

Neste projeto foi desenvolvido um sistema backend (APIs) de e-commerce parcial (catálogo de produtos e carrinho de compras) usando estrutura de microsserviços com o uso de Spring Cloud.



#### Desenvolvimento

Foram desenvolvidas as seguintes tarefas:

* Configurações iniciais de um projeto com o Spring Boot Initialzr p/cada microsserviço
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados p/ o "Catálogo de Produtos" e do "Carrinho de Compras"
* Configurações p/acesso aos BDs
* Desenvolvimento de algumas operações:
  * Catálogo de Produtos
    * cadastro e leitura de um produto específico (POST e GET)
  *  Carrinho de Compras
    * cadastro, leitura,e de um carrinho c/ seus itens (POST, GET e DELETE)
* Criação do módulo "Config Server" (distribui os arquivos de configurações para os microsserviços de uma mesma fonte)
* Criação do módulo "Service Discovery" (Faz o registros de todos os microsserviços e o balanceamento de carga)
* Criação do módulo "Gateway" (expõe os microsserviços de forma intermediária aos diversos frontends, evitando o acesso direto)



#### Tecnologias e Dependências utilizadas

- Java 11
- Gradle p/ gerenciamento de dependências
- Spring Boot (2.4.5)
  - **Spring Web**
  - **Spring Data Elasticsearch (Access + Driver)**
  - **Spring Data Redis (Access + Driver)** 
  - **Spring Boot Actuator**
  - **Spring Cloud (Config Server e Client, Eureka Server e Client, Gateway, Bootstrap)**
- Git/GitHub para versionamento do código
- Elasticsearch e Redis como banco de dados
- Docker para os ambientes dos BDs



#### Instalação e Execução

Baixar e importar todos os módulos em sua IDE preferida

Após executar todos os módulos, basta apenas abrir os endpoints abaixo:

- Product Catalog
  - Acesso direto ao BD: ``http://192.168.1.87:9200/product/_doc/1``
  - Acesso direto ao serviço: ``http://localhost:8081`` + RECURSO
  - Acesso através do Gateway: ``http://localhost:8080`` + RECURSO

| MÉTODO | RECURSO       | RESULTADO                     |
| ------ | ------------- | ----------------------------- |
| GET    | /product/{id} | retorna um produto específico |
| POST   | /product      | cria um novo produto          |

Exemplo de corpo da requisição POST

```json
{
    "id": 1,
    "name": "TV",
    "amount": 10
}
```

- "Shopping Cart "
  - Acesso direto ao serviço: ``http://localhost:8082`` + RECURSO
  - Acesso através do Gateway: ``http://localhost:8080`` + RECURSO

| MÉTODO | RECURSO    | RESULTADO                                                    |
| ------ | ---------- | ------------------------------------------------------------ |
| GET    | /cart/{id} | retorna um carrinho específico c/ seus itens                 |
| POST   | /cart/1    | Adiciona um item nesso carrinho existente ou cria o carrinho e adiciona |
| DELETE | /CART/1    | remove um carrinho específico e seus itens                   |

Exemplo de corpo da requisição POST

```json
{
    "productId": 1,
    "amount": 1
}
```



#### Melhorias futuras

- Criação do módulo "Circuit Breaker" (ajuda a evitar que os serviços fiquem indisponíveis e que tenha falhas em cascata)

