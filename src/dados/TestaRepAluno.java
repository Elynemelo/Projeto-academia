package dados;


import java.util.Scanner;

import negocio.Aluno;
import negocio.Curso;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class TestaRepAluno {

	public static void main(String[] args) throws RepositorioException {
		Scanner input = new Scanner(System.in);
		//RepositorioPessoasArray rep = new RepositorioPessoasArray(20);
		RepositorioPessoas rep = new RepositorioPessoasLista();		
		int opcao = 0;

		do {
			System.out.println("         =============================");
			System.out.println("         |     1 - Inserir ALUNO      |");
			System.out.println("         |     2 - Inserir PROFESSOR  |");
			System.out.println("         |     3 - Procurar           |");
			System.out.println("         |     4 - Remover            |");		
			System.out.println("         |     0 - Sair               |");
			System.out.println("         =============================\n");
			opcao = input.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Insira um nome: ");			
				String nome = input.next();	
				System.out.println("Insira um cpf: ");
				String cpf = input.next();	
				System.out.println("Insira uma idade: ");			
				int idade = input.nextInt();
				System.out.println("Insira o código do Curso ");
				int codCurso = input.nextInt();				
				System.out.println("Insira o nome do Curso:");
				String nomeCurso = input.next();
				Curso curso1 = new Curso(codCurso, nomeCurso);				
				Aluno aluno = new Aluno();	
				aluno.setNome(nome);
				aluno.setCpf(cpf);
				aluno.setIdade(idade);
				aluno.setCurso(curso1);
				try {
				rep.inserir(aluno);
				} catch(RepositorioException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
				}
				System.out.println("######Lista atual de pessoas: "+ ((RepositorioPessoasLista)rep).listarPessoas());
				break;
			
			case 2:
				System.out.println("Insira um nome: ");			
				String nomeProf = input.next();	
				System.out.println("Insira um cpf: ");
				String cpfProf = input.next();				
				System.out.println("Insira uma idade: ");				
				int idadeProf = input.nextInt();				
				System.out.println("Insira o valor do Salário:");
				int salarioProf = input.nextInt();	
				Professor professor = new Professor();
				professor.setNome(nomeProf);
				professor.setCpf(cpfProf);
				professor.setIdade(idadeProf);
				professor.setSalario(salarioProf);	
				try {
				rep.inserir(professor);
				} catch(RepositorioException e) {
					//e.printStackTrace();
					System.out.println(e.getMessage());
					}
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasLista)rep).listarPessoas());
				break;
			
			case 3:
				System.out.println("Digite o cpf que deseja PROCURAR: ");				
				String cpfProcura = input.next();
				//try{
				Pessoa p = rep.procurarString(cpfProcura);
				if(p != null) {
					System.out.println("CPF encontrado!");
					System.out.println(p.toString());
				} else {
					System.out.println("CPF não encontrado!");
				}
				break;
			
			case 4:
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasLista)rep).listarPessoas());
				System.out.println("Digite o cpf que deseja REMOVER: ");								
				String procuradoRemover = input.next();				
				rep.remover(procuradoRemover);
				System.out.println("CPF removido: "+procuradoRemover);
				System.out.println("######Lista atual de pessoas: "+((RepositorioPessoasLista)rep).listarPessoas());
				System.out.println("-- FIM --");
				break;
			
			default:
				System.out.println("Opção: "+ opcao);
				System.out.println("Opção Inválida!");
				break;
			}			
		} while (opcao != 0);
		input.close();
	}
}