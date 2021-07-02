package projetoAcademia;

public class TestaRepAluno {

	public static void main(String[] args) {
	
		RepositorioPessoasArray rep = new RepositorioPessoasArray(20);
		
		Curso curso1 = new Curso(001, "Matemática");
		Curso curso2 = new Curso(002,"Nutrição");
		Curso curso3 = new Curso(003, "Análise e Desenvolvimento de Sistemas");
		
		//inserir pessoa
		Aluno aluno1 = new Aluno("Maria Eduarda", "100.888.900-00", 30, curso3);
		rep.inserir(aluno1);
		
		Aluno aluno2 = new Aluno("Rita Maria", "205.768.234-20", 27, curso2);
		rep.inserir(aluno2);
		
		Aluno aluno3 = new Aluno("Joao", "010.777.890-91", 22, curso1 );
		rep.inserir(aluno3);
		
		Professor p1 = new Professor ("José Augusto", "300.400.500-80" , 40, 2500);
		rep.inserir(p1);
		//qtd de pessoas no repositorio
		System.out.println("Total de Pessoas:" + RepositorioPessoasArray.getTotalDePessoas());
		
		//procurar pessoa
		Pessoa procurado = rep.procurarString("300.400.500-80");
		System.out.println ("Nome: " + procurado.getNome()  +" CPF: " + procurado.getCpf());
		
		
		//remover pessoa
		procurado = rep.procurarString("205.768.234-20");
		if (procurado == null) {
			System.out.println("CPF não encontrado!");
		}else {
			rep.remover("205.768.234-20");
			System.out.println("Nome: " + procurado.getNome() + " CPF: " + procurado.getCpf() + " removido com sucesso!" + "\n");
			
			System.out.println("Total de Pessoas:" + RepositorioPessoasArray.getTotalDePessoas());
		}
		
		
		//toString
		System.out.println(aluno1.toString() + "\n");
		
		System.out.println(aluno2.toString() + "\n");
		
		System.out.println(aluno3.toString() + "\n");
		
		System.out.println(p1.toString() + "\n");
	}
	

}
