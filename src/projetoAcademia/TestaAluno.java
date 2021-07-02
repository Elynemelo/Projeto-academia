package projetoAcademia;

public class TestaAluno {

	public static void main(String[] args) {
	
		
		Curso curso1 = new Curso();
		curso1.setCodigo(001);
		curso1.setNome("Matematica");
		
		Curso curso2 = new Curso();
		curso2.setCodigo (002);
		curso2.setNome("Nutrição");
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Joao");
		aluno1.setCpf("010.777.890-91");
		aluno1.setIdade(20);
		aluno1.setCurso(curso1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Jose");
		aluno2.setCpf("010.131.333-91");
		aluno2.setIdade(35);
		aluno2.setCurso(curso2);
		
		
		
		System.out.println("______________ALUNOS_____________");	
		System.out.println("Nome: " + aluno1.getNome() + "\n" +  "CPF: " + aluno1.getCpf());
		System.out.println ("Idade: " + aluno1.getIdade() + "\n" + "Curso: " + aluno1.getCurso().getNome());
		
		System.out.println("\n" + "Nome: " + aluno2.getNome() + "\n" + "CPF: " + aluno2.getCpf());
		System.out.println ("Idade: " + aluno2.getIdade() + "\n" + "Curso: " + aluno2.getCurso().getNome());
		
		
	}

}
