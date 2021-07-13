package dados;

import java.util.List;
import java.util.Scanner;
import negocio.Aluno;
import negocio.Curso;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class Teste {

	public static void main(String[] args) throws RepositorioException {
		Scanner input = new Scanner(System.in);
		//RepositorioPessoasArray rep = new RepositorioPessoasArray(20);
		RepositorioPessoas rep = new RepositorioPessoasLista();		
		int opcao = 0;
		//PessoaDAO daoInicial = new PessoaDAO();
		//List<Pessoa> listaPessoas = daoInicial.getLista();

		do {
			System.out.println("         =======================================");
			System.out.println("         |     1 - Inserir ALUNO                |");
			System.out.println("         |     2 - Inserir PROFESSOR            |");
			System.out.println("         |     3 - Listar ALUNOS                |");
			System.out.println("         |     4 - Listar PROFESSORES           |");
			System.out.println("         |     5 - Procurar ALUNO pelo CPF      |");
			System.out.println("         |     6 - Procurar PROFESSOR pelo CPF  |");			
			System.out.println("         |     7 - Remover ALUNO                |");
			System.out.println("         |     8 - Remover PROFESSOR            |");
			System.out.println("         |     0 - Sair                         |");
			System.out.println("         =======================================\n");
			opcao = Integer.parseInt(input.nextLine());
			//opcao = input.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("Insira um nome: ");				
				String nome = input.nextLine();				
				System.out.println("Insira um cpf: ");				
				String cpf = input.nextLine();	
				System.out.println("Insira uma idade: ");				
				int idade = Integer.parseInt(input.nextLine());				
				System.out.println("Insira o código do Curso: ");
				int codCurso = Integer.parseInt(input.nextLine());		
				System.out.println("Insira o nome do Curso:");
				String nomeCurso = input.nextLine();
				Curso curso1 = new Curso(codCurso, nomeCurso);				
				Aluno aluno = new Aluno();	
				aluno.setNome(nome);
				aluno.setCpf(cpf);
				aluno.setIdade(idade);
				aluno.setCurso(curso1);
				try {
					rep.inserirAluno(aluno);
				} catch(RepositorioException e) {
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}				
				break;

			case 2:
				System.out.println("Insira um nome: ");			
				String nomeProf = input.nextLine();	
				System.out.println("Insira um cpf: ");
				String cpfProf = input.nextLine();				
				System.out.println("Insira uma idade: ");				
				int idadeProf = Integer.parseInt(input.nextLine());				
				System.out.println("Insira o valor do Salário:");
				int salarioProf = Integer.parseInt(input.nextLine());	
				Professor professor = new Professor();
				professor.setNome(nomeProf);
				professor.setCpf(cpfProf);
				professor.setIdade(idadeProf);
				professor.setSalario(salarioProf);	
				try {
					rep.inserirProfessor(professor);
				} catch(RepositorioException e) {
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}				
				break;

			case 3:
				//System.out.println("Digite o CPF que deseja PROCURAR: ");				
				//String cpfProcuraAluno = input.next();				
				try {
					List<Aluno> listAlunos = rep.listAlunos();					
					if(listAlunos.size() > 0) {
						System.out.println("----> Lista atual de Alunos: ");
						for(Aluno a : listAlunos) {
							a.toString();
							System.out.println("Nome: "+a.getNome());
							System.out.println("CPF: "+a.getCpf());
							System.out.println("Idade"+a.getIdade());
							System.out.println("Curso: "+a.getNomeCurso());
						}
					}else {
						System.out.println("Nenhum cadastro encontrado!");
					}
				} catch(Exception e) {					
					System.out.println("Foi encontrado um erro!");
					e.printStackTrace();
				}
				break;

			case 4:
				//System.out.println("Digite o CPF que deseja PROCURAR: ");				
				//String cpfProcuraProfessor = input.next();

				try {
					List<Professor> listProfessores = rep.listProfessores();
					if(listProfessores.size() > 0) {
						System.out.println("----> Lista atual de Professores: ");					
						for(Professor p : listProfessores) {
							p.toString();
							System.out.println(p);
						}
					}else {
						System.out.println("Nenhum cadastro encontrado!");
					}
				} catch(Exception e) {					
					System.out.println("Foi encontrado um erro!");
					e.printStackTrace();
				}
				break;

			case 5:

				System.out.println("Digite o CPF do ALUNO que deseja PROCURAR: ");								
				String procuraCpfAluno = input.nextLine();				
				try {
					Aluno a = rep.procurarAluno(procuraCpfAluno);
					if(a != null) {
						System.out.println("Nome: "+a.getNome());
						System.out.println("CPF: "+a.getCpf());
						System.out.println("Idade"+a.getIdade());
						System.out.println("Curso: "+a.getNomeCurso());
					}
				} catch(Exception e) {				
					System.out.println("CPF não encontrado!");
					e.printStackTrace();
				}											
				break;
				
			case 6:

				System.out.println("Digite o CPF do PROFESSOR que deseja PROCURAR: ");
				String procuraCpfProf = input.nextLine();
				try {
					Professor p = rep.procurarProfessor(procuraCpfProf);
					if(p != null) {
						System.out.println("Nome: "+p.getNome());
						System.out.println("CPF: "+p.getCpf());
						System.out.println("Idade"+p.getIdade());
						System.out.println("Salário: "+p.getSalario());
					}
				} catch(Exception e) {				
					System.out.println("CPF não encontrado!");
					e.printStackTrace();
				}											
				break;
				
			case 7:				
				System.out.println("Digite o CPF do ALUNO que deseja REMOVER: ");								
				String procuradoRemoverAluno = input.nextLine();				
				try {
					rep.removerAluno(procuradoRemoverAluno);
					System.out.println("Cadastro excluido com sucesso!");
				} catch(Exception e) {				
					System.out.println("CPF não encontrado!");
					e.printStackTrace();
				}								
				break;

			case 8:

				System.out.println("Digite o CPF do PROFESSOR que deseja REMOVER: ");								
				String procuradoRemoverProf = input.nextLine();				
				try {
					rep.removerProfessor(procuradoRemoverProf);
					System.out.println("Cadastro excluido com sucesso!");
				} catch(Exception e) {				
					System.out.println("CPF não encontrado!");
				}								
				break;

			case 0:
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