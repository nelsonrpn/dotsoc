# dotsoc
Simulação de uma "sociedade" de pontos com comportamentos regidos por redes neurais

ERRATA: NA VERDADE NÂO SIMULA NADA POIS EU ABANDONEI ESSE PROJETO ASSIM COMO 100% DE TODOS OS OUTROS QUE JÁ COMECEI

NOTAS SOBRE ARQUITETURA:

Não tenho referencia para arquitetura de redes neurais, portanto implementei uma própria que inicialmente pode não 	ser a mais eficiente, mas facilita o entendimento e a leitura do código.
  
Brain -> Contém a totalidade dos Layers de Neurons do ator
  
Layer -> Contém um conjunto de Neurons e a capacidade de criar sinpases com o Layer posterior, além de ativar todos os neurons contidos nela e realizar o feed foward

Neuron -> Unidade mínima de processamento da rede. Contém os valores de entrada e sinapses que os conectam com neurons de outras camadas

Synapse -> Conecta 2 neurons e contém o peso da relação deles para ativação.
