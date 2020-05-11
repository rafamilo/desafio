# Desafio AZ Rafael Camilo
[AZInformática](https://www.azi.com.br/)

##### Como rodar o projeto
  - Faça o clone do repositório
- Usando Docker
  - Libere as portas 5000, 3377 e 8080 do seu sistema.
  - usando o yarn
    - rode o comando ```cd backend && mvn package -DskipTests=true && cd ../ && docker-compose up --build -d && backend && mvn liquibase:migrate && cd ../frontend &&  yarn install && yarn serve``` na pasta raiz do projeto
  - usando o npm 
    - rode o comando ```cd backend && mvn package -DskipTests=true && cd ../ && docker-compose up --build -d && backend && mvn liquibase:migrate && cd ../frontend &&  npm install && npm run serve``` na pasta raiz do projeto
  - pronto!
- Usando apenas o Maven + Mysql + yarn ou npm
  - Abra o arquivo ```src/main/resources/application.properties```
  - Coloque as suas configurações no dataSource
  - entre na pasta backend
  - rode o comando ```mvn spring-boot:run``` 
  - Abra a pasta front-end e rode o comando yarn serve ou npm run serve
 
- Configuração do postman
  - Abra a pasta raíz do projeto e importe o arquivo ```Desafio_AZ.postman_collection.json``` no cli do postman.

##### Como rodar os testes
  - Entre na pasta backend
  - rode o comando mvn test


Obs: trabalhei fds também, então consegui me dedicar somente de madrugada, e não consegui dormir direito, então algumas coisas não ficaram muito bem estruturadas, principalmente no front, que fiz com mais pressa, hoje não poderei dar continuidade no projeto pois em 2 horas preciso voltar pro trabalho, eu calculei que levaria 48 horas para fazer todo o projeto, bem configurado, com authenticação, login e registro. Os testes no front acabei deixando de lado, pra não perder tempo configurando o ambiente de testes, mas iria usar cypress para e2e e jest para TDD. Aproveitei diversos recursos de um outro teste que fiz usando vuejs, que era relativamente parecido, porém todo o código foi feito por mim e claro, por mais que tenha aproveitado alguma coisa, tive que refazer a lógica dos arquivos.
Bem, resumindo, dediquei 24 horas mais ou menos para fazer esse projeto, em horários bem irregulares, então por favor, leve isso em consideração quando for analisar o código. 