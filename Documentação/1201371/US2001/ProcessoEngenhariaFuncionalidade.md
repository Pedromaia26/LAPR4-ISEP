US2001
=======================================


# 1. Requisitos

Como um Warehouse Employee:
* Eu quero definir a planta da warehouse através de um ficheiro json

A interpretação feita deste requisito foi no sentido de criar, além de uma warehouse, todos os seus constituintes presentes no ficheiro (agvdock, aisle, row e shelf).
Esta funcionalidade não tem dependências de nenhuma outra US.

# 2. Análise

##Persistência das entidades

Os objetos criados através da importação do ficheiro json foram persistidos, pois no momento da declaração do professor acerca da persistência dos dados, a funcionalidade já se encontrava implementada.

# 3. Design

## 3.1. Realização da Funcionalidade

###Diagrama SSD
![US2001_SSD](US2001_SSD.svg)

###Diagrama SD
![US2001_SD](US2001_SD.svg)

## 3.2. Diagrama de Classes

![US2001_CD](US2001_CD.svg)

## 3.3. Padrões Aplicados

- Controller
- Builder
- Repository
- Factory


