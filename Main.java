import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		File txt = new File("C:\\Users\\jvabr\\OneDrive\\Área de Trabalho\\planilha.txt"); 
		Scanner leiaTexto = new Scanner(System.in);
		Scanner leiaNum = new Scanner(System.in);
		Lista bancodeDados = new Lista();

		String nome, cpf, dataNasc, dtAdmi, cpfAux, statusAux;
		double salario, salarioB = 0;
		LocalDateTime dtRegistroAux = null;
		
		
		Funcionario funcionario = null;
		int pos;
		
		int opcao = 0;
		boolean continuar = true;
		while (continuar) {
			
			System.out.println("1. Cadastrar Funcionário");  
			System.out.println("2. Alterar Funcionário"); 
			System.out.println("3. Excluir Funcionário"); 
			System.out.println("4. Listar Funcionários");
			System.out.println("5. Atualizar salário dos funcionários");
			System.out.println("6. Salário Líquido dos funcionários");
			System.out.println("9. Sair do Sistema"); 
			 
			opcao = leiaNum.nextInt();
			
			
			switch (opcao) {
			
			case 1 :
				System.out.println("=====================================================================");
				System.out.println("Para cadastrar um novo Funcionario, por favor informe seus dados.");
				
				System.out.println("Digite o nome do funcionario:");
				nome = leiaTexto.nextLine();
				
				System.out.println("Digite o Cpf do funcionario:");
				cpf = leiaTexto.nextLine();
				  
				System.out.println("Digite a data de nascimento do funcionario:");
				dataNasc = leiaTexto.nextLine();
				
				System.out.println("Digite a data de admisão do funcionário:");
				dtAdmi = leiaTexto.nextLine();
 
 
				System.out.println("Digite o salario do funcionario:");
				salario = leiaNum.nextInt();
				
				
				
				dtRegistroAux = LocalDateTime.now();
				
				funcionario = new Funcionario(nome, cpf, dataNasc, salario, dtRegistroAux, dtAdmi,EStatus.ATIVO);
				
				bancodeDados.adicionar(funcionario);
				
				
				break;
			case 2: 
				System.out.println("=====================================================================");
				System.out.println("Para alterar os dados de um funcionário{a} digite o CPF dele{a}: ");
				cpfAux = leiaTexto.nextLine(); 
				
				pos = bancodeDados.localizarPosicao(cpfAux); 
				
				System.out.println("Digite corretamente o novo nome: ");
				nome = leiaTexto.nextLine(); 

				System.out.println("Digite corretamente o  Cpf do funcionario:");
				cpf = leiaTexto.nextLine();
				  
				System.out.println("Digite corretamente data de nascimento do funcionario:");
				dataNasc = leiaTexto.nextLine();
 
				System.out.println("Digite corretamente o salario do funcionario:");
				salario = leiaNum.nextInt();
				
				System.out.println("Digite corretamente a data de admisão do funcionário:");
				dtAdmi = leiaTexto.nextLine();
				
				System.out.println("ALTERE O STATUS DO FUNCIONÁRIO: 1 (Ativo) e 2 (Inativo) ");
				statusAux = leiaTexto.nextLine(); 
				if(statusAux.equals("1")){
					statusAux = EStatus.ATIVO.text; 
				} else
					statusAux = EStatus.INATIVO.text;
				funcionario = new Funcionario(nome, cpf, dataNasc, salario, dtRegistroAux, dtAdmi, EStatus.ATIVO);
				bancodeDados.alterar(pos, funcionario);
				break; 	
					
			case 3:
				System.out.println("Digite o CPF para excluí-lo: ");
				cpf = leiaTexto.nextLine(); 
				
				pos = bancodeDados.localizarPosicao(cpf); 
				bancodeDados.excluir(pos);
				break;
			case 4: 	
				System.out.println("NOSSOS FUNCIONÁRIOS:");

				for (int i = 0; i < bancodeDados.tamanho() ; i++) {
					funcionario = bancodeDados.buscarPosFuncionario(i);
					System.out.println(funcionario);
					System.out.println("=====================================================================");
				}
				break;
			case 5: 	
				System.out.println("ATUALIZANDO O SALÁRIO BRUTO DOS FUNCIONÁRIOS: ");
					
				for (int i = 0; i < bancodeDados.tamanho() ; i++) {
					funcionario = bancodeDados.buscarPosFuncionario(i); 
					funcionario.setSalario(Calculadora.novoSalario(funcionario));
					System.out.println("Nome: " + funcionario.getNome() + " - Salário Bruto: " + funcionario.getSalario());
					System.out.println("=====================================================================");
				}
				break;
			case 6: 	
				System.out.println("SALÁRIO LIQUÍDO DOS FUNCIONÁRIOS: ");
					
				for (int i = 0; i < bancodeDados.tamanho() ; i++) {
					funcionario = bancodeDados.buscarPosFuncionario(i); 
					funcionario.setSalario(Calculadora.impostoRenda(funcionario));
					System.out.println("Nome: " + funcionario.getNome() + " - Salário Liquído: " + funcionario.getSalario());
					System.out.println("=====================================================================");
				}
				break;
			case 9 :
				System.out.println("SAINDO DO PROGRAMA");
				continuar = false;
				break;
			default:
				System.out.println("Opção Inválida!");	
			} 
		}
	}
}	
	
