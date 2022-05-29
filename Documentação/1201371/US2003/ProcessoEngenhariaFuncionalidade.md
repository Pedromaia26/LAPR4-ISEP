US2003
=======================================


# 1. Requisitos

> **Question**: Regarding US2003, the development team was wondering if the warehouse employee chooses the intended AGV available to prepare the specific order or if it should be assigned to any AGV available without even asking the warehouse employee.
> 
> **Answer**: 
In the scope of US 2003, the AGV is selected by the warehouse employee from the ones that are available and are able to perform the task.


# 2. Análise

Como um Cliente:
* Eu quero ver/pesquisar o catálogo de produtos e adicionar produtos ao meu carrinho

A interpretação feita deste requisito foi no sentido de o utilizador poder ver todos os produtos do catálogo, ou pesquisar algum produto por brand (Marca) e qualquer uma das três descrições (shortDescription, extendedDescription e technicalDescription), de modo a encontrar o produto que deseja comprar ao seu carrinho de compras, e logo adicioná-lo.
O cliente também pode ver os produtos e a sua quantidade no carrinho. Esta funcionalidade tem dependência nas seguintes US's -> US1001, US1002, US1005, US2001.


# 3. Design

## 3.1. Realização da Funcionalidade

###Diagrama SSD
![US2003_SSD](US2003_SSD.svg)

###Diagrama SD
![US2003_SD](US2003_SD.svg)

## 3.2. Diagrama de Classes

![US2003_CD](US2003_CD.svg)

## 3.3. Padrões Aplicados

- Controller
- Service
- Repository
- Factory