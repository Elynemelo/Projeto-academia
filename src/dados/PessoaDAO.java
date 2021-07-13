package dados;

import java.sql.*;
import java.util.*;

import negocio.Aluno;
import negocio.Professor;

public class PessoaDAO {
	private Connection con = null;

	public PessoaDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	public void adicionaAluno(Aluno a) {

		String sql = "INSERT INTO aluno(nome,cpf,idade,curso) VALUES(?,?,?,?)";
		//System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getNome());			
			stmt.setString(2, a.getCpf());
			stmt.setInt(3, a.getIdade());
			stmt.setString(4, a.getCurso().getNome());
			stmt.execute();
			stmt.close();

			System.out.println("Aluno Salvo com Sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adicionaProfessor(Professor p) {

		String sql = "INSERT INTO professor(nome,cpf,idade,salario) VALUES(?,?,?,?)";
		//System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getNome());			
			stmt.setString(2, p.getCpf());
			stmt.setInt(3, p.getIdade());
			stmt.setDouble(4, p.getSalario());
			stmt.execute();
			stmt.close();

			System.out.println("Professor Salvo com Sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Aluno> getListaAlunos() {

		List<Aluno> alunos = new ArrayList<Aluno>();

		String sql = "SELECT * FROM aluno";
		//String sql = "SELECT * FROM aluno WHERE cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			//stmt.setString(1, numCpf);
			ResultSet rs = stmt.executeQuery();			

			while(rs.next()){				
				Aluno a = new Aluno(rs.getString("nome"),rs.getString("cpf"), rs.getInt("idade"), rs.getString("curso"));
				a.setNome(rs.getString("nome"));  
				a.setCpf(rs.getString("cpf"));			
				a.setIdade(rs.getInt("idade"));				
				a.setNomeCurso(rs.getString("curso"));
				alunos.add(a);
			}

			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}	

	public List<Professor> getListaProf() {

		List<Professor> professores = new ArrayList<Professor>();

		String sql = "SELECT * FROM professor";
		//String sql = "SELECT * FROM aluno WHERE cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			//stmt.setString(1, numCpf);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){				
				Professor p = new Professor(rs.getString("nome"),rs.getString("cpf"), rs.getInt("idade"), rs.getDouble("salario"));
				p.setNome(rs.getString("nome"));  
				p.setCpf(rs.getString("cpf"));			
				p.setIdade(rs.getInt("idade"));
				p.setIdade(rs.getInt("idade"));
				p.setSalario(rs.getDouble("salario"));
				professores.add(p);
			}

			rs.close();
			stmt.close();
			return professores;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}

	public void deleteAluno(String cpf) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM aluno WHERE cpf = ?");
			stmt.setString(1, cpf);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);	
		}
	}

	public void deleteProfessor(String cpf) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM professor WHERE cpf = ?");
			stmt.setString(1, cpf);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);	
		}
	}

	//procura aluno por cpf
	public Aluno procurarAluno(String cpf) {
		Aluno a = new Aluno();
		String sql = "SELECT * FROM aluno WHERE cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){				
				a = new Aluno(rs.getString("nome"),rs.getString("cpf"), rs.getInt("idade"), rs.getString("curso"));
				a.setNome(rs.getString("nome"));  
				a.setCpf(rs.getString("cpf"));			
				a.setIdade(rs.getInt("idade"));				
				a.setNomeCurso(rs.getString("curso"));				
			}		
			rs.close();
			stmt.close();
			if (a.getCpf().equals(null)){
			System.out.println("CPF nao encontrado");
			}
			return a;
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}				
	}
	

	//procura professor por cpf
	public Professor procurarProfessor(String cpf) {
		Professor p = new Professor();		
		String sql = "SELECT * FROM professor WHERE cpf = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){				
				p = new Professor(rs.getString("nome"),rs.getString("cpf"), rs.getInt("idade"), rs.getDouble("salario"));
				p.setNome(rs.getString("nome"));  
				p.setCpf(rs.getString("cpf"));			
				p.setIdade(rs.getInt("idade"));
				p.setIdade(rs.getInt("idade"));
				p.setSalario(rs.getDouble("salario"));				
			}		
			rs.close();
			stmt.close();
			
			if (p.getCpf().equals(null)){
				System.out.println("CPF nao encontrado");
				}
			
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}

}