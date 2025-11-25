# Catálogo de Música Project  
Repositorio: **catalogo-musica-project**

## 🚀 Visão Geral  
Este projeto implementa um sistema de catálogo de músicas, permitindo gerenciar entidades como músicas, artistas, álbuns etc.  
Desenvolvido em Java (versão recente), segue boas práticas de arquitetura, qualidade de código e evolutibilidade.

## 🎯 Objetivos  
- Permitir cadastro, consulta, atualização e remoção (“CRUD”) das entidades principais (música, artista, álbum).  
- Oferecer API RESTful expansível para futuras integrações.  
- Aplicar padrão de camadas (ex: controller, service, repository) para separação de responsabilidades.  
- Código claro, testável e sustentável — apto para evolução e manutenção em nível pleno/sênior.

## 🧩 Tecnologias Utilizadas  
- Java (por ex., Java 21+)  
- Maven (wrapper incluído)  
- Spring Boot (assumido, se já estiver configurado)  
- Lombok para redução de boilerplate  
- JPA/Hibernate ou equivalente (se persistência estiver presente)  
- Camadas bem definidas (controller → service → repository)  
- Mensuração de cobertura de testes, logs estruturados, tratamento de exceções global  

> Obs: Adapte conforme o que realmente está implementado (web framework, banco de dados, etc).

## 📁 Estrutura do Projeto  
├─ .mvn/
├─ src/
│ ├─ main/
│ │ ├─ java/…
│ │ └─ resources/…
│ └─ test/
├─ mvnw, mvnw.cmd
├─ pom.xml
└─ .gitignore

- `src/main/java` → código fonte principal  
- `src/test/java` → testes automatizados  
- `pom.xml` → configurações Maven  
- `mvnw + mvnw.cmd` → wrapper para padronizar versão Maven  

## 🔧 Como Executar  
1. Clone o repositório:  
   ```bash
   git clone https://github.com/ibrunaneves/catalogo-musica-project.git
   cd catalogo-musica-project

2. Compile e execute com Maven:
./mvnw clean install
./mvnw spring-boot:run   # ou conforme configuração de execução

3. Acesse a API (exemplo): http://localhost:8080/api/musicas (ajuste conforme rota real).

4. Para testes:
./mvnw test

✅ Boas Práticas & Qualidade

Métodos com responsabilidade única; nomes expressivos.
Uso de Optional<> para evitar null, streams para manipulação de coleções.
Dependência invertida: camadas de serviço não dependem de detalhes de infraestrutura.
Tratamento global de exceções e respostas padronizadas para API.
Testes unitários e de integração cobrindo cenários críticos (ex: criação, consulta, falhas).

📋 Checklist de Entrega / Evolução

 Endpoint CRUD completo para cada entidade (Música, Artista, Álbum).
 Validações de regra de negócio (ex: não cadastrar música sem artista).
 Paginação e filtro para listagem de músicas.
 Documentação API (Swagger/OpenAPI).
 Segurança (autenticação/autorização) se for evoluir para ambiente produtivo.
 Deploy automatizado (CI/CD) + ambiente de homologação.
