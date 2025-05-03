# AgroManage Backend

Back-end da aplicação AgroManage para a gestão financeira de pequenos produtores rurais.

Este repositório contém a API desenvolvida em **Java** com **Spring Boot**

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- PostgreSQL
- Maven

## 📦 Como rodar o projeto

1. Clone o repositório:
  ```bash
  git clone https://github.com/SeuUsuario/agromanage-backend.git
  cd agromanage-backend
  ```
2. Configure o db (applications.properties):
  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/agromanage
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  
  # JWT Secret Key
  agromanage.jwt.secret=sua-chave-secreta
  ```
3. Rodar a aplicação
