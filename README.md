<h1 align="center"> Multi Chat API </h1>

# Resumo do projeto
Este projeto é uma aplicação de chat em tempo real, inspirada no Discord, que permite aos usuários se comunicarem em salas de conversa. A aplicação foi desenvolvida usando Java e Spring Boot para o backend, com comunicação em tempo real habilitada pelo protocolo WebSocket. O MySQL é utilizado como banco de dados para persistir informações de usuários e grupos.

## Pré Requisitos

O que você precisa para instalar o software e como instalá-lo.

- Java 17+
- Mysql
- Maven
- Uma IDE de sua preferência (como IntelliJ IDEA, VS Code ou Eclipse)

## Instalando

Passo a passo que mostram como colocar o ambiente de desenvolvimento em funcionamento.

#### 1- Clonar o Repositório
- Abra seu terminal ou prompt de comando e clone o projeto com o seguinte comando:

```
git clone [URL_DO_SEU_REPOSITORIO]
```

#### 2- Configurar o Banco de Dados

- Abra o MySQL e crie um novo banco de dados.

- Acesse o arquivo src/main/resources/application.properties (ou application.yml) e atualize as configurações de conexão com suas credenciais do MySQL:

```
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

#### 3- Importar e Executar o Projeto na IDE

- Importe o projeto em sua IDE como um projeto Maven.

- Deixe que a IDE resolva e baixe todas as dependências do pom.xml.

- Vá para a classe principal da aplicação (geralmente localizada em src/main/java/) e execute-a fazendo o flyway criar as tabelas no banco de dados.

#### 4- Ver a documentação

- Acesse o caminho correto para acessar a documentação

```
http://localhost:8080/swagger-ui.html
```

## Endpoints
<img width="1112" height="819" alt="image" src="https://github.com/user-attachments/assets/fe30f3fe-7038-4dc9-95aa-a57206e969f9" />

## ✔️ Bibliotecas e tecnologias utilizadas

- ``Java 17``
- ``Spring 3.5.3``
- ``Maven``
- ``Sql``
- ``Flyway``
- ``WebSocket``
- ``SpringDoc``
- ``DevTools``
- ``Spring Security``
- ``Auth0 jwt``

## Autor

* **Pedro Uchôa** - *Dev Back-end Java* - [Github](https://github.com/PedroUchoa)


