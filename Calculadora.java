
public class Calculadora{
	
	
	private static double salarioAlterado = 0;   
	
	public static double getSalarioAlterado() {
	return salarioAlterado;
	}

	public static void setSalarioAlterado(double salarioAlterado) {
		Calculadora.salarioAlterado = salarioAlterado;
	}

	public static double novoSalario(Funcionario f){
		int tempoServico = f.tempoServicosMesses();
		
		if(tempoServico < 36){
			double salarioBruto = f.getSalario(); 
			salarioBruto += salarioBruto * 0.01;
			salarioAlterado = salarioBruto;
		} else if (tempoServico >= 36 && tempoServico < 60) {
			double salarioBruto = f.getSalario();
			salarioBruto += salarioBruto * 0.03;
			salarioAlterado = salarioBruto;
		} else if(tempoServico >= 60) {
			double salarioBruto = f.getSalario();
			salarioBruto += salarioBruto * 0.05;
			salarioAlterado = salarioBruto;
		}
		
		return salarioAlterado; 
	}
	
	public static double impostoRenda(Funcionario f) { 
		double salarioLiquido = salarioAlterado; 
		if ( salarioLiquido < 2000) {
			 salarioAlterado -=  salarioLiquido * 0.10; 	
		} else if( salarioLiquido >= 2000 &&  salarioLiquido < 5000){
			 salarioAlterado -=  salarioLiquido * 0.15; 
		} else if( salarioAlterado >= 5000){
			salarioAlterado -= salarioLiquido * 0.20; 
		}
		
		return salarioAlterado; 
	}
}
