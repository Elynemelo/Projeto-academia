package dados;

import java.util.*;

import negocio.Pessoa;
import negocio.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {

	private List<Pessoa> pessoas;
	
	
	public RepositorioPessoasLista () {
		pessoas = new ArrayList<Pessoa>();
	}
	

	public void inserir(Pessoa x) throws RepositorioException {
		 
		 for(Pessoa p : pessoas) {
			 if(p.getCpf().equals(x.getCpf())) {
				 throw new RepositorioException();
			 }
		 }
		 pessoas.add(x);
	}
		

	public Pessoa procurarString(String numCPF){
		Pessoa procurada = null;
		for (Pessoa pessoa: pessoas) {
			if(pessoa.getCpf().equals(numCPF))
				procurada = pessoa;
		}
		return procurada;
	}


	public void remover(String numCPF) {
		int posicao = -1;
		for (Pessoa pessoa: pessoas) {
			if (pessoa.getCpf().equals(numCPF)) {
				posicao = pessoas.indexOf(pessoa);
				break;
			}
		}
		if (posicao != -1)
			pessoas.remove(posicao);
	}

	public List<Pessoa> listarPessoas(){
		return this.pessoas;
	}

}

