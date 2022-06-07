# LISTA DE REGISTRO DE FUNCIONÁRIOS: 


ENUNCIADO: 

O sistema deve permitir a manipulação de vários Funcionário;
O sistema deve permitir a gravação dos Funcionário em arquivo texto;
O sistema deve verificar e abrir o arquivo texto para recarregar os
registros no sistema;

Abstract Pessoa
-String nome;
-String cpf;
-LocalDate dtNascimento;

Funcionario
-LocalDateTime dtRegistro;
-EStatus status; (ATIVO, INATIVO)
-double salario;
public int tempoServicoMeses(){}

@override
public String toString() - Nome: XXXXXX[CPF] - Salário Bruto: XXXXX

Calculadora
-public static double novoSalario(Funcionario f);
Se tempoServico < 3 anos = 1%
Se tempoServico >= 3 anos e < 5 anos = 3%
Se tempoServico >= 5 anos = 5%

- public static double impostoRenda(Funcionario f);
Se Salario < 2000 = 10% Imposto
Se Salario >= 2000 e < 5000 = 15% Imposto
Se Salario >= 5000 = 20% Imposto

MainTeste
Deve conter um Menu com as seguintes opções:
1.Cadastrar Funcionário;
2.Alterar Funcionário;
3.Excluir Funcionário;
4.Listar Funcionários;
5.Atualizar Salario de Todos os Funcionários;
6.Listar pagamento líquido de Todos os Funcionários; (Nome: e Salário Líquido)
