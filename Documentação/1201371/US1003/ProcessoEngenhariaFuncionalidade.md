US1003
=======================================

# 1. Requisitos

Como um Sales Clerk:
* Eu quero registar um cliente

A interpretação feita deste requisito foi no sentido de criar um Cliente na aplicação, com o seu respetivo cargo na hierarquia das roles do sistema.
Esta funcionalidade não tem dependências de nenhuma outra US.

# 2. Análise

##Campo de identificação

Após uma pesquisa relativamente ao atributo mais indicado para identificar o cliente, decidimos que o VAT seria o campo mais fiável para servir de identificador do mesmo.

##Criação de um user

Além de, como na US diz, criar um cliente, é necessário criar um User (ClientUser) no sistema para que este possa usufruir do sistema, podendo dar login no mesmo.

##Localização geográfica do cliente

A localização geográfica assumida em todo o projeto é Portugal. Ou seja, aquando da criação do cliente, os campos, como por exemplo código postal e número de telemóvel, são requeridos no padrão português.

# 3. Design

## 3.1. Realização da Funcionalidade

###Diagrama SSD
![US1003_SSD](US1003_SSD.svg)

###Diagrama SD
![US1003_SD](US1003_SD.svg)

## 3.2. Diagrama de Classes

![US1003_CD](US1003_CD.svg)

## 3.3. Padrões Aplicados

- Controller
- Builder
- Repository
- Factory

# 4. Implementação

Na US 1003, depois de o sales clerk fazer login no sistema e selecionar a opção de registar o customer, este vai ter de inserir os dados do customer, desde o username, até ao número de telefone, para além disto tem também a opção de inserir campos não obrigatórios, tais como a data de nascimento ou as moradas. Após a inserção os dados são enviados para o controller onde temos dois repositórios, o de systemuser e o de clientuser, onde primeiramente vamos dar “save” ao system user( campos como username, email, etc) e posteriormente o client user(campos como o vat, phone numeber, etc) . Para garantir que ambos são inseridos se acontecer algum erro, criamos uma transação antes do primeiro save, e damos comit no fim do segundo. Antes de fazer o save os dados são enviados para um builder, onde criam o objeto que eventualmente vai levar “save”.

# 4. Observações

Como dito anteriormente, dicidimos que o VAT seria o atributo identificador do cliente, mas o mais correto deveria ser um campo gerado. Alteração a fazer no Sprint C.