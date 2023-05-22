API de Gerenciamento Financeiro - README

Este é um sistema de gerenciamento financeiro que fornece endpoints para realizar transações, obter informações sobre caixas e gerar relatórios. O software é desenvolvido usando a linguagem Java e o framework Spring Boot.
Configuração e Execução

    Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.
    Faça o download do código-fonte do projeto.
    Navegue até o diretório raiz do projeto no terminal.
    Execute o comando ./mvnw spring-boot:run para iniciar o aplicativo.

Endpoints Disponíveis

A seguir estão os endpoints disponíveis no sistema:
1. Transações
Listar todas as transações

Endpoint: GET /transacoes

Este endpoint retorna todas as transações registradas no sistema.
Debitar valor

Endpoint: POST /transacoes/debitar/{id}

Este endpoint permite debitar um valor em um caixa específico. É necessário fornecer os seguintes parâmetros no corpo da solicitação:

    transacao: Um objeto JSON contendo as informações da transação a ser debitada.

Exemplo de corpo da solicitação:

json

{
  "tipo": "débito",
  "valor": 50.00,
  "data": "2023-05-19"
}

Creditar valor

Endpoint: POST /transacoes/creditar/{id}

Este endpoint permite creditar um valor em um caixa específico. É necessário fornecer os seguintes parâmetros no corpo da solicitação:

    transacao: Um objeto JSON contendo as informações da transação a ser creditada.

Exemplo de corpo da solicitação:

json

{
  "tipo": "crédito",
  "valor": 100.00,
  "data": "2023-05-19"
}

2. Caixas
Obter caixa por ID

Endpoint: GET /caixa/{id}

Este endpoint retorna as informações de um caixa específico com base no ID fornecido.
Listar todos os caixas

Endpoint: GET /caixa

#Este endpoint retorna uma lista com todas as informações dos caixas registrados no sistema.
Criar caixa

Endpoint: POST /caixa

Este endpoint permite criar um novo caixa. É necessário fornecer os seguintes parâmetros no corpo da solicitação:

    caixa: Um objeto JSON contendo as informações do caixa a ser criado.

Exemplo de corpo da solicitação:

json

{
  "nome": "Caixa 1",
  "saldo": 500.00
}

3. Relatórios
Obter relatório de saldo diário de um caixa

Endpoint: GET /caixa/{data}/{id}

Este endpoint retorna um relatório de saldo diário para um caixa específico em uma determinada data. É necessário fornecer os seguintes parâmetros na URL da solicitação:

    data: A data para a qual o relatório de saldo diário deve ser gerado no formato "yyyy-MM-dd".
    id: O ID do caixa para o qual o relatório será gerado.

O relatório será retornado no formato JSON, com os seguintes campos:

    data: A data do saldo.
    saldo: O saldo total para o dia.

Implementações futuras

    Implementar uma rotina automatizada para gerar relatórios diários utilizando a anotação @Scheduled do Spring, a fim de evitar a necessidade de solicitar manualmente os relatórios.
    Implementar a geração de arquivos Excel para os relatórios, permitindo uma melhor visualização e análise dos dados.

Notas

    Certifique-se de fornecer os parâmetros corretos nas solicitações, seguindo o formato adequado.
    Todos os endpoints retornarão um código de status HTTP apropriado juntamente com a resposta JSON correspondente.
    Para mais detalhes sobre os modelos de dados e as operações disponíveis, consulte a documentação da API.
