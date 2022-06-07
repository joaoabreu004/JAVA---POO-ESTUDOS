import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
	
	
	private LocalDateTime dtRegistro; 
	private double salario;
	private EStatus status; 
	private String dtAdmissaoTexto;  
	private LocalDate dtAdmissao; 
	
	
	
	//FUNÇÃO
	
	public int tempoServicosMesses(){
		return ((LocalDate.now().getYear() - dtAdmissao.getYear()) * 12) + (LocalDate.now().getMonthValue());
	}
	
	
	
	
	
	
	
	public Funcionario(String nome, String cpf, String dtNascimento, double salario, LocalDateTime dtRegis, String dtAdmi ,EStatus satus) {
		super(nome, cpf, dtNascimento);
		this.dtRegistro = dtRegis; 
		this.salario = salario; 
		this.status = EStatus.ATIVO;
		this.dtAdmissaoTexto = dtAdmi;
		this.dtAdmissao =  LocalDate.parse(dtAdmissaoTexto, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}


	public String getDtAdmissaoTexto() {
		return dtAdmissaoTexto;
	}







	public void setDtAdmissaoTexto(String dtAdmissaoTexto) {
		this.dtAdmissaoTexto = dtAdmissaoTexto;
	}







	public LocalDate getDtAdmissao() {
		return dtAdmissao;
	}







	public void setDtAdmissao(LocalDate dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}







	public LocalDateTime getDtRegistro() {
		return dtRegistro;
	}


	public void setDtRegistro(LocalDateTime dtRegistro) {
		this.dtRegistro = dtRegistro;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public EStatus getStatus() {
		return status;
	}


	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	//SOBRESCRITA
	@Override
	public String toString(){
		getDtNascimento();
		return "NOME: " + getNome() + "\r" 
				+"CPF: " + getCpf() + "\r" 
				+ "SALÁRIO: " + getSalario() + "\r" 
 				+ "DATA DE REGISTRO: " + getDtRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\r" 
				+ "STATUS: " + getStatus();  
  
	}
}
