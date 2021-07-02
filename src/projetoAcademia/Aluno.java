package projetoAcademia;

public class Aluno extends Pessoa{

	 private String nome;
	 private String cpf;
	 private int idade;
	 private Curso curso;
	
		public Aluno() {
			
		}
		
		public Aluno(String nome, String cpf, int idade, Curso curso) {
			super(nome,cpf, idade);
			this.nome=nome;
			this.cpf=cpf;
		    this.idade=idade;
		    this.curso=curso;
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
		
		
		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public Curso getCurso() {
			return curso;
		}

		public void setCurso(Curso curso) {
			this.curso = curso;
		}
	
		public String toString() {
			return "Nome: " + this.getNome() + "\n" + "CPF: "+ this.getCpf() + "\n" + "Idade: " + this.getIdade() +
					"\n" + curso;	
			}
		
		
}