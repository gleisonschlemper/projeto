package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Professor;

public class ProfessorDAO {
	private static final String tabela = "tb_funcionarios";
	
	public static boolean verificar (Professor professor) {
		try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM "+tabela+" WHERE (func_email = ? AND func_senha = ? AND func_cargo ilike 'Professor') OR func_codigo = ? OR func_cpf = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, professor.getEmail());
	        stmt.setString(2, professor.getSenha());
	        stmt.setInt(3, professor.getCodigo());
	        stmt.setString(4, professor.getCpf());
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
	
	
	public static Professor visualizar(Professor professor) {
		try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM "+tabela+" WHERE (func_email = ? AND func_senha = ? AND func_cargo ilike  'Professor') OR func_codigo = ? OR func_cpf = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, professor.getEmail());
	        stmt.setString(2, professor.getSenha());
	        stmt.setInt(3, professor.getCodigo());
	        stmt.setString(4, professor.getCpf());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	professor.setCodigo(rs.getInt("func_codigo"));
	        	professor.setCpf(rs.getString("func_cpf"));
	        	professor.setNome(rs.getString("func_nome"));
	        	professor.setCargo(rs.getString("func_cargo"));
	        	professor.setSobrenome(rs.getString("func_sobrenome"));
	        	professor.setIdade(rs.getInt("func_idade"));
	        	professor.setTelefone(rs.getString("func_telefone"));
	        	professor.setDataNascimento(rs.getDate("func_datanascimento"));
	        	professor.setEmail(rs.getString("func_email"));
	        	professor.setSenha(rs.getString("func_senha"));
	        };
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    } 
		return professor;
	}
	
}
