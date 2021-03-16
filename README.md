# Desafio DBServer - Mentoria Banrisul
## Testes automatizados de API

Estes *Script* foi desenvolvido para o desafio de testes automatizados da mentoria do time **DBserver-Banrisul**, tem por objetivo testar e validar casos de uso para a API [**VIACEP**](https://viacep.com.br/)

### PRÉ REQUISITOS 

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas ou dependências: 

* [Git](https://git-scm.com)
* [Java](https://www.java.com/pt-BR/)
* [JDK 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
* [JUnit 5](https://junit.org/junit5/)
* [Gradle](https://gradle.org/)
* [REST-assured](https://rest-assured.io/)
* [Allure Test Report](http://allure.qatools.ru/)

Além disto é bom ter uma IDE Java para trabalhar com o código como por exemplo o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) ou [Ecplipse](https://www.eclipse.org/downloads/) dentre outras.

### EXECUÇÃO

* Abra o projeto "mentoria-time-banrisul-segundo-desafio"
* Navegar até o pacote src/test/java/testCases/viaCep
* No package viaCep clicar com o botão direito
* Clicar no menu "Run 'Tests in testCases"

### GERAÇÃO DE RELATÓRIO - ALLURE

* Apos executar os testes, verificar se foram gerados os arquivos no pacote "build/allure-results
* Caso positivo, abrir o terminal (da IDE ou do sistema operacional)
* Digitar o comando "alure server build/allure-results" sem as aspas
* O relatório irá abrir no navegador padrão em formato HTML

### CENÁRIOS DE TESTE

**URL**: https://viacep.com.br/ws/91060900/json

* Cenário 1: Consulta CEP Válido \
  **Dado que** o usuário insere um CEP válido \
  **Quando** o serviço é consultado \
  **Então** é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge 

* Cenário 2: Consulta CEP inexistente \
  **Dado** que o usuário insere um CEP que não exista na base dos Correios \
  **Quando** o serviço é consultado \
  **Então** é retornado um atributo erro 

* Cenário 3: Consulta CEP com formato inválido \
  **Dado que** o usuário insere um CEP com formato inválido \
  **Quando** o serviço é consultado \
  **Então** é retornado uma mensagem de erro

* Cenário Extra: Criar um cenário que verifique o retorno do serviço abaixo: \
  **URL**: https://viacep.com.br/ws/RS/Gravatai/Barroso/json  
