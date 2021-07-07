package dados;

public class RepositorioException extends Exception{


	private static final long serialVersionUID = 1L;

	public RepositorioException() {
	super ("Já existe um cadastro com este CPF!");
	
	}
}
