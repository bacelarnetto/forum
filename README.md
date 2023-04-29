# API SPRING BOOT FORUM
CURSO DE KOTLIN ALURA<br/>
projeto spring boot com kotlin<br/>
## Executando o projeto no docker.
1 - Instalar o projeto <b>commons-core-lib</b>. Usar o comando abaixo.<br/>
`➜ mvn clean install`<br/><br/>
2 - Instalar o projeto <b>commons-app-lib</b>. Usar o comando abaixo.<br/>
`➜ mvn clean install`<br/><br/>
3 - Instalar o projeto <b>forum</b>. Usar o comando abaixo.<br/>
`➜ mvn clean install -Pprod`<br/><br/>
4 - Executar o projeto via docker-compose.<br/>
`➜ cd forum/`<br/>
`➜ docker-compose up -d`<br/><br/>
URL: http://localhost:8080<br/><br/>

### Observações
* Quando a api fórum for executada dentro do docker ela vai usar a mesma rede do banco de dados, por isso, a mesma deve usar a porta  "3306" usada internamente no lugar da porta "3308" e na url deve usar "mysql-forum-db" (traz o benefício de não precisar saber o endereço ip, uma exelente estratégia para ser usado em ambiente de produtivo) que é o nome do container no lugar de "localhost". Configuração baseada no arquivo docker-compose. Resumindo a url: "jdbc:mysql://localhost:3308/forum" só deve ser usada em ambiente de desenvolvimento local. ;)
