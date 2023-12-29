# API SPRING BOOT FORUM
CURSO DE KOTLIN ALURA<br/>
Projeto spring boot com kotlin<br/>
## Executando o projeto no docker.
1 - Usando linha de comando, entra na dentro do diretório da api.<br/>
`➜ cd forum/`<br/><br/>
2 - Instalar o projeto <b>forum</b>. Usar o comando abaixo.<br/>
`➜ mvn clean install -Pdocker`<br/><br/>
3 - Executar o projeto via docker-compose.<br/>
`➜ docker-compose up -d`<br/>

<b>Outra forma de configuração seria alterando o arquivo Dockerfile.</b>

`ENTRYPOINT [..., "-Dspring.profiles.active=docker", ...]`

1 - Instalar o projeto <b>forum</b>. Usar o comando abaixo.<br/>
`➜ mvn clean install`<br/><br/>
2 - Executar o projeto via docker-compose.<br/>
`➜ docker-compose up -d`<br/><br/>
URL: http://localhost:8089<br/><br/>



### Observações 
* Quando a api fórum for executada dentro do docker ela vai usar a mesma rede do banco de dados, por isso, a mesma deve usar a porta  "3306" que é usada internamente no lugar da porta "3308" e na url deve usar "mysql-forum-db" (traz o benefício de não precisar saber o endereço ip, uma exelente estratégia para ser usado em ambiente produtivo) que é o nome do container no lugar de "localhost". Configuração baseada no arquivo docker-compose. Resumindo a url: "jdbc:mysql://localhost:3308/forum" só deve ser usada em ambiente de desenvolvimento local. ;)

## Que foi abordado nesse projeto
### Camada Web
* Do server-side para o REST
* Lidando com requisições GET
* Lidando com requisições POST
* Lidando com requisições PUT e DELETE
* Tratamento de erros na API

### Camada de persistência
* Spring Data JPA
* Migrations com Flyway
* Filtros, paginação e ordenação
* Cache

### Segurança e infraestrutura
* Falando sobre DevOps
* Segurança com HTTP Basic
* Segurança com JWT
* Profiles
* Docker
* Deploy

### Testes automatizados e documentação de API
* Testes manuais
* Testes de unidade
* Testes de integração
* Testes de API
* Documentando APIs

### Recursos avançados
* Cache com Redis
* Envio de E-Mails
* Relatório com Thymeleaf
* Integração Contínua
* Entrega Contínua
* Deploy com Pipeline
* WebSockets
