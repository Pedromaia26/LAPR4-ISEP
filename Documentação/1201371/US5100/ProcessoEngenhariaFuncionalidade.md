US5100
=======================================


# 1. Requisitos

> **Question**: What type of communication do you want, i.e., what are the communications that you want to have between these two. Like AGV Manager says "Take a product" and AGV Digital Twin says "Taken"? Is it something like that? Or am i confused?
>
> **Answer**: 
>The communication must follow the SPOMS2022 protocol. 
>
> **Question**: Regarding the USs 1901,4001, 5001, and 5002, what would you consider its complete state, that is, what would be the criterion to define whether or not this US is functional?
>
> **Answer**: 
>For all of those US, the communication between the two involved components must be implemented in accordance with the SPOMS2022. The requests processing can be somehow mocked. For instance, if processing a request implies saving some data to the database, the component can instead write such data to a log (mocking). Latter, on next sprint, the teams implement the interaction to the database.
>However, it is not advisable mocking everything, namely the components (internal) state. Notice that by mocking you are letting extra effort to the next sprint.   
>Finally, all US must be demonstrable.

# 2. Análise

> Primeiramente, para a realizacao da US5100, decidimos começar por fazer a movimentaçao de um AGV num projeto a parte para conseguirmos perceber mais sobre memoria partilhada
de uma maneira que nao corressemos risco de estragar o projeto de alguma forma. Primeiramente começamos por apenas ter um agv e, numa matriz criada previamente, fazer com que 
ele chegasse ao destino, nao se preocupando com os obstaculos. Posteriormente, fizemos com que ele para ir para o destino tivesse que ter em consideraçao os obstaculos. Por fim,
implementamos memória partilhada com a utilizaçao de varios agvs(varias threads), logo os agvs tinham de ter em consideraçao as posicoes dos mesmos. Apos este algoritmo estar
completamente implementado no projeto auxiliar, decidimos passar para o verdadeiro projeto, onde começamos por construir a matriz dinamicamente retirando os valores da base de
dados. Apos isso fomos colocar na matriz os agvs que ja se encontravam criados na base de dados. Para terminar, criamos um ciclo de modo a que o agv atribuido a uma "order" 
conseguisse fazer o percurso ate aos varios produtos da mesma "order" e no fim voltar para a posicao inicial, lembrando que cada vez que chega a localizacao de um produto,
existe uma pausa de 2 segundos para simular a recolha do mesmo.
Para a verificaçao de obstaculos usamos sensores para verificar a frente, a traseira e as laterais, onde se consegue fazer uma verificao de ate 3 "squares" de distancia, onde
quando detetado a velocidade do mesmo é reduzida ou o agv para por completo. Para a velocidade usamos como velocidade padrao 1 segundo por "square", quando deteta um agv a 3 "squares" 2 segundos por "square",
quando aparece um agv a dois "squares" dele, fica parado por 3 segundos no mesmo "square" e quando aparece um no proximo "square" o agv para por completo ate haver um movimentaçao de outro. 
Para a bateria definimos como valor de perda de bateria, 1 por "square" de modo a haver uma facil demonstracao do modo poupanca tambem criado. O modo poupanca é ativado
quando a bateria do agv chega a 20, reduzindo entao o consumo de bateria para 0.2 por casa, mas reduzindo a velocidade do mesmo para 3 segundos por "square". Quando este entre no
modo poupanca de bateria ele vai apanhar o proximo produto e entao voltar imediatamente para a "Dock" onde, como chegou a dock no modo poupanca, ira começar a carregar. Quando
esta situaçao em que o agv para uma "order" a meio, outro agv fará o resto da sua order. Quando um agv acaba de carregar por completo, automaticamente faz a verificaçao se 
ha alguma order por fazer.
Apos tudo estar pronto numa matriz a correr na consola, decidimos colocar tudo a acontecer online, no "Dashboard", onde o "Warehouse Employee" pode acompanhar o movimento 
dos agvs a todo o momento, atualizando a posicao atual dos agvs de segundo a segundo. Para a colocação online, o Server do dashboard vai mandar um pedido para o digital twin
para aceder a posicao de cada agv, visitando a memoria partilhada, depois de saber as posicoes, converte para html e é colocado online.
Como havia um estado do agv que nao estava a ser utilizado ainda no projeto, decidimos entao definir uma percentagem(40% para motivos de apresentacao) de o agv ao começar a fazer a order "ficar estragado" e 
ser preciso a manutencao do mesmo. Para o fim da manutencao do agv criamos uma opcao no menu do "warehouse employee" para poder informar ao sistema que o agv "ja foi arranjado" e o mesmo automaticamente
inicia a procura por novas "orders" para fazer.

# 3. Design

## 3.1. Realização da Funcionalidade

### Diagrama SD
![US5001_SD](US5100_SD.svg)

## 3.2. Padrões Aplicados
- Controller
- Service
- Repository
- Factory