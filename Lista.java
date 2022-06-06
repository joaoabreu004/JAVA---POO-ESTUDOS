import java.time.format.DateTimeFormatter;

public class Lista {
	private Funcionario[] vetor = new Funcionario[100];
	private int posicao = 0;
	
	public int tamanho(){
		return posicao; 
	}
	
	//MÉTODO ADICIONAR
	public void adicionar(Funcionario funcionario){
		vetor[posicao] = funcionario; 
		posicao++; 
		GravadorArquivo.gravacao(formatarAluno());
	}
	
	
	//MÉTODO ALTERAR
	public void alterar(int pos, Funcionario f) {
		if (pos >= 0 && pos < posicao) {
			vetor[pos] = f;
			GravadorArquivo.gravacao(formatarAluno());
		}
	}
	
	
	//MÉTODO EXCLUIR
	public void excluir(int pos) {
		vetor[pos] = null;
		
		for (int i = pos; i < posicao - 1; i++) {
			vetor[i] = vetor[i + 1];
		}
		vetor[posicao - 1] = null;
		
		posicao--;
		GravadorArquivo.gravacao(formatarAluno());
	}

	//MÉTODO LOCALIZAR	
	public int localizarPosicao(String cpf) {
		
		for (int i = 0; i < posicao; i++) {
			if (vetor[i].getCpf().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
	
	//BUSCAR POSICAO
	public Funcionario buscarPosFuncionario(int posicao){
		return  vetor[posicao];
	}
	
	private String formatarAluno(){
		String funcionaF = "";
		Funcionario fun;
		
		for(int cont = 0; cont < tamanho(); cont++ ) {
			
			fun = vetor[cont]; 
			funcionaF += "Nome: " + fun.getNome() + "[" + fun.getSalario()+ "] - " + " Salário Bruto: " + fun.getSalario() + " - Data de Registro: " + fun.getDtRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\r";  

		}
		return funcionaF;  
	}


}
