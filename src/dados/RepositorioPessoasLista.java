package dados;

import java.util.*;

import negocio.Aluno;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {

	PessoaDAO dao = new PessoaDAO();
	//private List<Pessoa> pessoas = dao.getLista();
	private List<Pessoa> pessoas;
	//private List<Aluno> alunos;
	//private List<Professor> professores;

	public RepositorioPessoasLista () {
		pessoas = new ArrayList<Pessoa>();
		//alunos = new ArrayList<Aluno>();
		//professores = new ArrayList<Professor>();
	}


	public void inserirAluno(Aluno x) throws RepositorioException {

		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(x.getCpf())) {
				throw new RepositorioException();
			}
		}
		pessoas.add(x);
		dao.adicionaAluno(x);
	}

	public void inserirProfessor(Professor x) throws RepositorioException {

		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(x.getCpf())) {
				throw new RepositorioException();
			}
		}
		pessoas.add(x);
		dao.adicionaProfessor(x);
	}		

	public List<Aluno> listAlunos() throws Exception {	
		List<Aluno> a = dao.getListaAlunos();
		return a;
	}	

	public List<Professor> listProfessores() throws Exception {	
		List<Professor> p = dao.getListaProf();
		return p;
	}

	public void removerAluno(String numCPF) throws Exception {		
		dao.deleteAluno(numCPF);
	}


	public void removerProfessor(String numCPF) throws Exception {
		dao.deleteProfessor(numCPF);			
	}

	public Aluno procurarAluno(String numCPF) throws Exception{
		Aluno a = dao.procurarAluno(numCPF);
		return a;
	}

	public Professor procurarProfessor(String numCPF) throws Exception{
		Professor p = dao.procurarProfessor(numCPF);
		return p;
	}	

	public List<Pessoa> listarPessoas(){
		return this.pessoas;
	}
}