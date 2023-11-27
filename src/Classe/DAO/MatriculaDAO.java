package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Classe.Conexao.Conexao;
import Classe.DTO.*;


public class MatriculaDAO {
	
	private static final String tabela = "tb_matriculados";
	
	public boolean verificar (Matricula matricula) {		
        try { 
        	Connection conn = Conexao.conectaBanco();
            String query = "SELECT * FROM "+tabela+" WHERE (mat_cpf = ?) OR (mat_codigo = ?) OR (mat_email = ? AND mat_senha = ?)"; 
            PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setString(1, matricula.getAluno().getCpf());
	        stmt.setInt(2, matricula.getCodigo());
	        stmt.setString(3, matricula.getAluno().getEmail());
	        stmt.setString(4, matricula.getAluno().getSenha());
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return true;
            }
        } 
        catch (SQLException e) {
        	//e.printStackTrace();
        }
		return false; 
    }

	public static boolean cadastrar(Matricula matricula) {
	    try {
	        Connection conn = Conexao.conectaBanco();
	        String queryInsertMatricula = "INSERT INTO "+tabela+" (mat_cpf, mat_nome, mat_sobrenome, mat_email, mat_senha, mat_idade, mat_datanascimento, mat_datamatricula, mat_horamatricula, mat_telefone, end_codigo, pais_codigo) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(queryInsertMatricula);
	        stmt.setString(1, matricula.getAluno().getCpf());
	        stmt.setString(2, matricula.getAluno().getNome());
	        stmt.setString(3, matricula.getAluno().getSobrenome());
	        stmt.setString(4, matricula.getAluno().getEmail());
	        stmt.setString(5, matricula.getAluno().getSenha());
	        stmt.setInt(6, matricula.getAluno().getIdade());
	        stmt.setDate(7,(java.sql.Date) matricula.getAluno().getDataNascimento());
	        stmt.setDate(8,(java.sql.Date) matricula.getDataMatricula());
	        stmt.setTime(9, (java.sql.Time) matricula.getHoraMatricula());
	        stmt.setString(10, matricula.getAluno().getTelefone());
	        stmt.setInt(11, matricula.getAluno().getEndereco().getCodigo());
	        stmt.setInt(12, matricula.getAluno().getPais().getCodigo());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return true;
            }
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    }
	    return false;
	}
	

	public static List <Matricula> listarComAluno(){
		 List <Matricula> matriculasComAlunos = new ArrayList<>(); // Array de alunos
	     try  { // Execução do código corretamente 
			 	Connection conn = Conexao.conectaBanco();
	            String querySelect = "SELECT * FROM "+tabela; // Cria o select do aluno     
	        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
	            ResultSet rs = stmt.executeQuery(); // Executa o select
	            while (rs.next()) { // Excuta quantos objetos foram encontrado
	            	Matricula matricula = new Matricula(rs.getInt("mat_codigo"),rs.getDate("mat_datamatricula"),rs.getTime("mat_horamatricula"));
	            	Aluno aluno = new Aluno( // Cria o objeto Aluno com os dados do banco de dados 
	            			rs.getString("mat_cpf"),  // Seta o CPF 
	                		rs.getString("mat_nome"), // Seta o nome 
	                		rs.getString("mat_sobrenome"),  // Seta o Sobrenome
	                 		rs.getInt("mat_idade"), // Seta a idade 
	                		rs.getString("mat_email"),  // Seta o email 
	                		rs.getString("mat_senha"), // Seta a senha         
	                		rs.getString("mat_telefone"),
	                		rs.getDate("mat_datanascimento"), // Seta data de nacimento 
	                		PaisDAO.visualizar(new Pais(rs.getInt("pais_codigo"), new Mae(), new Pai())),
	                		EnderecoDAO.visualizar(new Endereco(rs.getInt("end_codigo"))),
	                		EscolaDAO.visualizar(new Escola())
	                );                 	
	            	matricula.setAluno(aluno);
	            	matriculasComAlunos.add(matricula);
	            }
	            conn.close();
	            stmt.close();
	            rs.close();
	        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	        	//e.printStackTrace();
	        }
	        return matriculasComAlunos; // Retorna Array de Alunos da escola 
	}
	
	public Matricula visulizarAlunoCompletoPorMatricula(Matricula matricula) {
	     try  { // Execução do código corretamente 
			 Connection conn = Conexao.conectaBanco();
	         String querySelect = "SELECT * FROM "+tabela+" where (mat_cpf = ?) OR (mat_codigo = ?) OR (mat_email = ? AND mat_senha = ?)"; // Cria o select do aluno     
	         PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
	         stmt.setString(1, matricula.getAluno().getCpf());
		     stmt.setInt(2, matricula.getCodigo());
		     stmt.setString(3, matricula.getAluno().getEmail());
		     stmt.setString(4, matricula.getAluno().getSenha());
		     ResultSet rs = stmt.executeQuery(); // Executa o select
	         if (rs.next()) { // Excuta quantos objetos foram encontrado
	            	matricula.setCodigo(rs.getInt("mat_codigo"));
	            	matricula.setDataMatricula(rs.getDate("mat_datamatricula"));
	            	matricula.setHoraMatricula(rs.getTime("mat_horamatricula"));
	            	Aluno aluno = new Aluno( // Cria o objeto Aluno com os dados do banco de dados 
	            			rs.getString("mat_cpf"),  // Seta o CPF 
	                		rs.getString("mat_nome"), // Seta o nome 
	                		rs.getString("mat_sobrenome"),  // Seta o Sobrenome
	                 		rs.getInt("mat_idade"), // Seta a idade 
	                		rs.getString("mat_email"),  // Seta o email 
	                		rs.getString("mat_senha"), // Seta a senha         
	                		rs.getString("mat_telefone"),
	                		rs.getDate("mat_datanascimento"), // Seta data de nacimento 
	                		PaisDAO.visualizar(new Pais(rs.getInt("pais_codigo"), new Mae(), new Pai())), // Seta infformações dos pais
	                		EnderecoDAO.visualizar(new Endereco(rs.getInt("end_codigo"))), // Seta informações de endereco
	                		EscolaDAO.visualizar(new Escola()) // Seta informações da escola
	                ); 
	            	matricula.setAluno(aluno);
	            }
	            conn.close();
	            stmt.close();
	            rs.close();
	        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	        	//e.printStackTrace();
	        }
	        return matricula; // Retorna Array de Alunos da escola 
	}
	
	// Array de matriculas que tenha a mesma matricula passado no parâmetro 
	public static List <Matricula> consultarAlunosPorMatricula(Matricula matricula){
		 List <Matricula> matriculas = new ArrayList<>(); // Array de alunos
	     try  { // Execução do código corretamente 
			 	Connection conn = Conexao.conectaBanco();
			 	String querySelect = "SELECT * FROM "+tabela+" WHERE mat_codigo = ?"; // Cria o select do aluno     
			 	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
			 	stmt.setInt(1, matricula.getCodigo());
			 	ResultSet rs = stmt.executeQuery(); // Executa o select
	         	while (rs.next()) { // Excuta quantos objetos foram encontrado
	        		 matricula.setCodigo(rs.getInt("mat_codigo"));
	        		 matricula.setDataMatricula(rs.getDate("mat_datamatricula"));
	        		 matricula.setHoraMatricula(rs.getTime("mat_horamatricula"));
	        		 matriculas.add(matricula);
	            }
	            conn.close();
	            stmt.close();
	            rs.close();
	        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	        	//e.printStackTrace();
	        }
	     return matriculas; // Retorna Array de Alunos da escola 
	}
	
}
