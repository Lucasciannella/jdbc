## Gestao de Curso API 

Api para cadastro e gestão de Cursos e turmas para funcionários da sua empresa.

### Inicialização & execução:

Tecnologias necessárias:

-  JDK 17
- Maven
- IDE (opcional)
- Docker (Indico Docker desktop para usuários de Windows)

Instruções:

Abaixo o arquivo docker-compose.yaml onde temos a configuração genérica para rodar a aplicação. Caso queira escalar essa aplicação para um ambiente de produção é recomendável ajustar as mesmas para garantir a segurança.

```yaml
version: '3.1'
services:
  db:
    image: mysql
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - linkedrh_data:/var/lib/mysql

volumes:
  linkedrh_data:
```

Com o docker instalado em sua maquina você vai precisar rodar na pasta raiz do projeto os seguintes comandos:

- Para baixar a imagem do SGBD e inicializar o container:

  ```shell
  docker-compose up 
  ```

- Caso queira verificar se o container foi inicializado:

  ```shell
  docker-compose ps
  ```

  

Após fazer o clone do projeto e iniciar o container Docker chegou a hora de rodar aplicação, podemos utilizar de uma ide para isto ou rodando o comando:

```shell
mvn spring-boot:run
```



Todas as configurações foram feitas, a aplicação esta rodando logo você pode acompanhar a documentação dos endpoints [clicando aqui]( http://localhost:8080/swagger-ui/index.html#)

![](https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExODkyOWUzNjRmZWQ4OGFlMjM5NTg1ODRkZWQ0NDVkOWM2ZWQ3MjA1MiZjdD1n/sGOyrLb6ImzpVcDiTl/giphy.gif)





### Notas:

Utilizei do framework Flyway para versionar e auxiliar as migrations do banco de dados.

Eu incrementaria  a aplicação com  Handlers para  tratar as exceções e utilizaria o spring validation para validar a entrada de dados na api.



### OBS

Como não foi escopo do projeto criar endpoints para funcionários criei esse script para adicionar alguns a base de dados:

```sql
INSERT INTO FUNCIONARIO (nome,CPF,nascimento,cargo,admissao,status) VALUES ("RICARDO VIFNOTTO LOPEZ","25149383090", "1988-04-20","CEO","2005-03-23",1);
INSERT INTO FUNCIONARIO (nome,CPF,nascimento,cargo,admissao,status) VALUES ("MARIA MAGALHAES BASTOS","09422417031", "1968-04-20","SEO","2005-07-02",1);
INSERT INTO FUNCIONARIO (nome,CPF,nascimento,cargo,admissao,status) VALUES ("JOSÉ MARTINEZ MELO","84681151009", "1998-04-20","DESENVOLVEDOR","2020-05-02",1);
INSERT INTO FUNCIONARIO (nome,CPF,nascimento,cargo,admissao,status) VALUES ("MEL GARCIA AMOEDO","67622407046", "1999-01-20","ANALISTA DE SISTEMAS","2022-02-22",1);
INSERT INTO FUNCIONARIO (nome,CPF,nascimento,cargo,admissao,status) VALUES ("MARINA SILVA COSTA","68585301007", "2000-03-02","TECH LEADER","2021-07-13",1);
```

