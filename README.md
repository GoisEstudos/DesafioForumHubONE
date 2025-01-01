# DesafioForumHubONE

O **DesafioForumHubONE** é uma plataforma de fórum desenvolvida para o desafio proposto pela HubONE. O sistema permite a criação, gerenciamento e interação entre usuários em tópicos diversos, com foco em simplicidade e segurança.

## Requisitos

- **Java 11 ou superior**: Necessário para a execução da aplicação.
- **Gradle**: Ferramenta de automação de build e gerenciamento de dependências.
- **Banco de dados**: H2, MySQL ou PostgreSQL.
- **Postman**: Para testes de API.

## Funcionalidades

- **Autenticação e autorização de usuários**: Sistema de login e controle de acesso.
- **Criação e gerenciamento de tópicos e posts**: Usuários podem criar e gerenciar discussões.
- **Sistema de comentários**: Interação entre usuários em posts.
- **Interface simples e intuitiva**: Facilidade de uso para o usuário final.

## Como Rodar o Projeto

1. **Clone este repositório**:

   ```bash
   git clone https://github.com/GoisEstudos/DesafioForumHubONE.git
   ```

## Como Rodar o Projeto

1. **Navegue até a pasta do projeto**:

   ```bash
   cd DesafioForumHubONE
   ```
   
# DesafioForumHubONE

## Instruções para Rodar a Aplicação

# Como Compilar e Rodar a Aplicação

### Compile e rode a aplicação:

```bash
./gradlew bootRun
```

Acesse a aplicação no navegador em http://localhost:8080.

# Como Testar a API no Postman

Para realizar uma requisição POST com autenticação básica (username:password) no Postman, siga os seguintes passos:

### 1. Escolher o método HTTP:
Selecione o método POST na lista de métodos disponíveis, ao lado da URL.

### 2. Definir a URL:
No campo de URL, insira o endereço do seu endpoint. Exemplo:

```bash
http://localhost:8080/login
```

## 3. Configurar a autenticação básica:
1. Clique na aba **Authorization** (Autorização), que fica abaixo da URL.
2. No menu suspenso **Type**, selecione **Basic Auth**.
3. Nos campos que aparecem, insira:
    - **Username**: o nome de usuário (por exemplo, `username`).
    - **Password**: a senha (por exemplo, `password`).
4. Agora, você pode enviar a requisição e testar o comportamento da API.

## Tecnologias Usadas
- **Spring Boot**: Framework principal para o desenvolvimento do back-end.
- **Spring Security**: Para a implementação de segurança, incluindo autenticação e autorização.
- **H2 Database**: Banco de dados embutido para testes locais.
- **Gradle**: Ferramenta para automação de build e gerenciamento de dependências.
- **Postman**: Ferramenta para testar a API.

## Contribuindo
1. Faça um **fork** deste repositório.
2. Crie uma **branch** para sua feature (exemplo: `git checkout -b feature/nome-da-feature`).
3. **Commit** suas mudanças (exemplo: `git commit -am 'Adiciona nova feature'`).
4. Envie para a **branch** principal (exemplo: `git push origin feature/nome-da-feature`).
5. Crie um novo **Pull Request**.

## Licença
Este projeto está licenciado sob a **MIT License** - veja o arquivo LICENSE para mais detalhes.


