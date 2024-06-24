Claro! Aqui está o README melhorado com a adição de informações sobre a utilização do MySQL.

---

# Spring Boot: Desenvolva uma API Rest em Java

Projeto para estudos sobre como desenvolver uma API seguindo o curso da Alura de Spring Boot 3.

- **Trello** com o objetivo inicial do projeto: [Trello Board](https://trello.com/b/O0lGCsKb/api-voll-med)
- **Figma**: [Figma Design](https://www.figma.com/design/N4CgpJqsg7gjbKuDmra3EV/Voll.med)

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **HelloController**: Responsável por responder às requisições GET para o endpoint `/hello` com a mensagem "Hello, World!".

## DTO

Utilização do padrão DTO (Data Transfer Object) para encapsular dados e melhorar a transferência entre camadas da aplicação.

## Pré-requisitos

Para este projeto, são necessários:

- JDK 17
- Maven
- MySQL

## Dependências

### Spring Boot Starter Web

- **Descrição**: Fornece a infraestrutura para construir aplicações web, incluindo RESTful services.
- **Grupo e Artefato**: `org.springframework.boot:spring-boot-starter-web:3.3.1`

### Spring Boot DevTools

- **Descrição**: Oferece ferramentas de desenvolvimento como reinicialização automática, configuração simplificada, entre outras.
- **Grupo e Artefato**: `org.springframework.boot:spring-boot-devtools:3.3.1`

### Lombok

- **Descrição**: Biblioteca para reduzir a verbosidade do código Java, gerando automaticamente getters, setters, construtores, etc.
- **Grupo e Artefato**: `org.projectlombok:lombok:1.18.32`

### Spring Boot Starter Test

- **Descrição**: Inclui bibliotecas para testar aplicações Spring Boot, como JUnit, Hamcrest e Mockito.
- **Grupo e Artefato**: `org.springframework.boot:spring-boot-starter-test:3.3.1`

### MySQL Driver

- **Descrição**: Conector para o banco de dados MySQL.
- **Grupo e Artefato**: `mysql:mysql-connector-java:8.0.32`

## Configuração do MySQL

1. **Instale o MySQL**: Se você ainda não o fez, baixe e instale o MySQL em seu ambiente de desenvolvimento.
2. **Crie um banco de dados**: Crie um banco de dados para a aplicação. Por exemplo:
    ```sql
    CREATE DATABASE vollmed;
    ```
3. **Configure as credenciais no `application.properties`**:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/vollmed
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

## Como Executar

Para executar o projeto localmente:

1. Certifique-se de ter o JDK 17, Maven e MySQL instalados.
2. Clone este repositório.
3. Navegue até o diretório do projeto.
4. Configure as credenciais do MySQL no arquivo `application.properties`.
5. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
6. Acesse `http://localhost:8080/hello` no seu navegador para ver a mensagem "Hello, World!".

## Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.