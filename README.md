Projeto Desafio Coopersystem

Desafio :
Ao se passar uma data para nosso sistema, queremos saber as cotações do dólar na data passada e do dia útil anterior.
Caso se passe uma data inválida ou uma data de um dia não útil, mensagens de erro deverão ser retornadas usando os corretos status do protocolo HTTP.

Comandos (projeto api)
mvn clean package
java -jar target/banco-api-1.0.0.jar

Comandos (projeto banco)
mvn clean package
java -jar target/banco-1.0.0.jar

Comandos (pasta Coopersystem)
docker-compose config
docker-compose up --build

instruções
O swagger da aplicação Banco deve ser passado no formato dd/MM/yyyy, dessa forma é mais agradavel para o usuario.

O swagger da aplicação api deve ser passado da forma MM/dd/yyy, caso queria realizar o teste individualmente. 

Observação: A aplicaçao comunica entre elas, assim não é necessario usar o swagger api, pois o retorno será na aplicação Banco
como manda o desafio.
