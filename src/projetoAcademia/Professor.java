package projetoAcademia;

public class Professor extends Pessoa{

	private double salario;
	
	public Professor(){
		
	}
	
	public Professor(String nome, String cpf, int idade, double salario){
	super(nome, cpf, idade);
	this.salario = salario;	
	
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return "Nome: " + this.getNome() + "\n" + "CPF: "+ this.getCpf() + "\n" + "Idade: " + this.getIdade() +
				"\n" + "Salário: " + this.getSalario();	
		}
	
	
}
