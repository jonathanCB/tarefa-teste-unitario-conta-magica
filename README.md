# Tarefa_TesteUnitario-ContaMagica
Relatório está compartilhado no Google Drive. É só clicar no link ao lado ->
Jonathan, Alisson, Josias
Estratégia de testes utilizadas
- Particionamento do espaço de entrada
  Consiste em identificar as variáveis de entrada.
  Nós usamos a técnica de valor limite para cada partição nos testes onde o saldo da conta está entre 0 e 50.000.
- Cobertura Lógica
  Utilizada quando o comportamento de um sistema é descrito através de predicados.
  Utilizamos cobertura lógica para fazer os testes de depósito nas contas com saldo igual a 0 e contas com saldo maior ou igual a 50.000.
- Cobertura de Grafos
  Visando conseguir cobrir todas as rotinas do programa.  
Exercício:
- A verificação de “upgrade” da conta se dá via operação de depósito, e não é possível que um cliente faça “upgrade” diretamente de “Silver” para “Platinum” em uma única operação, portanto, a conta tem de ser GOLD para poder passar para PLATINUM.
SILVER (0) = [1 – 49.999] (Sem rendimentos);
GOLD (1) = [50.000 – 199.999] (Cada depósito rende 1% do valor depositado);
PLATINUM (3) = [200.000 – ∞] (Cada depósito rende 2,5% do valor depositado);

Nossos casos de teste para depósitos em contas com saldo >= 0 && < 50.000 onde o status da conta = SILVER:
P1 = [1, 49999] -> testar {0, 30.000, 49.999} //Conta SILVER 
P2 = [50000, 199999] -> testar {50.000, 199.999} //Conta GOLD
P3 = [200000, ∞] -> testar {200.000, 999.999} //Conta GOLD
P4 = [-∞] //Registro inválido (número negativo)

Nossos casos de teste para depósitos em contas com saldo >= 50.000, onde o status da conta = GOLD:
P5 = [50000, 199999] -> testar {100, 148.000} //Conta GOLD
P6 = [200000, ∞] -> testar {150.000, 999.999} //Conta PLATINUM
P7 = [-∞] -> testar {-1, -9999}//Registro inválido (número negativo)
Nossos casos de teste para depósitos em contas com saldo >= 50.000, onde o status da conta = GOLD:
P8 = [200000, ∞] -> testar {100, 500000} //Conta PLATINUM

Nossos casos de teste para saques em contas com saldo >= 100.000 onde o status da conta = PLATINUM:
P1 = [100000, ∞] -> testar {400.000, 900.000} //Conta PLATINUM
P2 = [25000, 99999] -> testar {900.001, 975.000} //Conta GOLD
P3 = [0, 24999] -> testar {975.001, 1.000.000} //Conta GOLD
P4 = [-∞, +∞] -> testar {-9999, -1, 2.000.000} //Registro inválido (número negativo ou saldo insuficiente)
Nossos casos de teste para saques em contas com saldo < 75.000, onde o status da conta = GOLD:
P5 = [25000, 99999] -> testar {50.000} //Conta GOLD
P6 = [0, 49999] -> testar {52.001, 75.000} //Conta SILVER

Obs:  Devido a meu problema com a pasta "jacoco" para a utilização do CodeCoverage, não consegui usá-lo para verificar a cobertura de código.
A pasta jacoco simplesmente não foi criada pelo meu Maven e pesquisando não consegui achar outra forma de utilizá-lo.

Link da tarefa no GitHub: https://github.com/jonathanCB/Tarefa_TesteUnitario-ContaMagica
Link para o relatório completo com os casos de teste e resultados esperados: https://drive.google.com/file/d/1bt8Ej9ejPxe3yyPYi6b6RQ_1mTP5RIoe/view
