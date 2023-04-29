# forum
CURSO DE KOTLIN ALURA<br/>
projeto spring boot com kotlin<br/>
## Executando o projeto no docker.
1 - Instalar o projeto <b>commons-core-lib</b>. Usar o comando abaixo.<br/>
`mvn clean install`<br/><br/>
2 - Instalar o projeto <b>commons-app-lib</b>. Usar o comando abaixo.<br/>
`mvn clean install`<br/><br/>
3 - Instalar o projeto <b>forum</b>. Usar o comando abaixo.<br/>
`mvn clean install -Pprod`<br/><br/>
4 - Executar o projeto via docker-compose.<br/>
`cd forum/docker/`<br/>
`docker-compose up`<br/><br/>
URL: http://localhost:8080<br/><br/>

### Observações
* A api fórum vai quando for executada dentro do docker ela usar a mesma rede do banco de dados, por isso, a mesma deve usar a porta interna "3306" no lugar de "3308" e na url usar "mysql-forum-db"
que é o nome do container no lugar de "localhost". Configuração baseada no arquivo docker-compose. Resumindo a url: "jdbc:mysql://localhost:3308/forum" só deve ser usada em ambiente de desenvolvimento local. ;)
