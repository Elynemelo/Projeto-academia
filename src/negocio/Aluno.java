package negocio;

public class Aluno extends Pessoa{

	 private String nome;
	 private String cpf;
	 private int idade;
	 private Curso curso;
	 private String nomeCurso;
	
		public Aluno() {
			
		}
		
		public Aluno(String nome, String cpf, int idade, Curso curso) {
			super(nome,cpf, idade);
			this.nome=nome;
			this.cpf=cpf;
		    this.idade=idade;
		    this.curso=curso;
		}
		
		//construtor usado no dao, setar nome do curso recuperado do banco
		public Aluno(String nome, String cpf, int idade, String ncurso) {
			super(nome,cpf, idade);
			this.nome=nome;
			this.cpf=cpf;
		    this.idade=idade;
		    this.nomeCurso=ncurso;
		}		
		
		public String getNome() {
		return nome;
		
		}
		
		//get usado no dao, recuperar nome do curso que está no aluno
		public String getNomeCurso() {
		return nomeCurso;
		
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

		//set usado no dao, setar nome do curso recuperado do banco
		public void setNomeCurso(String cursoNome) {
			this.nomeCurso = cursoNome;
		}
		
		public String toString() {
			return "Nome: " + this.getNome() + "\n" + "CPF: "+ this.getCpf() + "\n" + "Idade: " + this.getIdade() +
					"\n" + this.getCurso();	
			}
		
		
}