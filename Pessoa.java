import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String dataUsuario; 
	private LocalDate dtNascimento; 
	
	//LocalDate localDate6 = LocalDate.parse(dataDigitadaPeloUsuario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	//Construtor
	public Pessoa(String nome, String cpf, String dtUsuario){
		this.nome = nome; 
		this.cpf = cpf; 
		this.dataUsuario = dtUsuario; 
		this.dtNascimento = LocalDate.parse(dataUsuario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public LocalDate getDtNascimento() {
		return dtNascimento;
	}


	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public String getDataUsuario() {
		return dataUsuario;
	}



	public void setDataUsuario(String dataUsuario) {
		this.dataUsuario = dataUsuario;
	}
}