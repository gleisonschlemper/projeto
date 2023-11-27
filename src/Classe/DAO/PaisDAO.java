package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Pais;

public class PaisDAO {
	private static final String tabela = "tb_pais";
	
	public static boolean verificar(Pais pais) {
		 try {
			 Connection conn = Conexao.conectaBanco();
	         String querySelect = "SELECT * FROM "+tabela+" WHERE (pai_cpf = ? AND mae_cpf = ?) OR pais_codigo = ? OR (pais_email = ? AND pais_senha = ?)"; // Cria o o select dos pais
	         PreparedStatement stmt = conn.prepareStatement(querySelect); 
	         stmt.setString(1, pais.getPai().getCpf()); 
	         stmt.setString(2, pais.getMae().getCpf());
	         stmt.setInt(3, pais.getCodigo());  
	         stmt.setString(4, pais.getEmail()); 
	         stmt.setString(5, pais.getSenha());
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
	
	public static Pais visualizar(Pais pais) { 
		 try {
			Connection conn = Conexao.conectaBanco();
		    String query = "SELECT * FROM tb_pais WHERE (pai_cpf = ? AND mae_cpf = ?) OR pais_codigo = ? OR (pais_email = ? AND pais_senha = ?)";	        
		    PreparedStatement stmt = conn.prepareStatement(query);      
		    stmt.setString(1, pais.getPai().getCpf());
		    stmt.setString(2, pais.getMae().getCpf());
		    stmt.setInt(3, pais.getCodigo()); 
		    stmt.setString(4, pais.getEmail()); 
		    stmt.setString(5, pais.getSenha());
		    ResultSet rs = stmt.executeQuery();    
		    if (rs.next()) { 
		        pais.setCodigo(rs.getInt("pais_codigo"));
		        pais.setEmail(rs.getString("pais_email"));
		        pais.setSenha(rs.getString("pais_senha"));
		        pais.getMae().setCpf(rs.getString("mae_cpf"));
		        pais.getMae().setNome(rs.getString("mae_nome"));
		        pais.getMae().setSobrenome(rs.getString("mae_sobrenome"));
		        pais.getMae().setIdade(rs.getInt("mae_idade"));
		        pais.getMae().setEmail(rs.getString("pais_email"));
		        pais.getMae().setSenha(rs.getString("pais_senha"));
		        pais.getMae().setCargo(rs.getString("mae_cargo"));
		        pais.getMae().setTelefone(rs.getString("mae_telefone"));
		        pais.getMae().setDataNascimento(rs.getDate("mae_datanascimento"));
		        pais.getPai().setCpf(rs.getString("pai_cpf"));
		        pais.getPai().setNome(rs.getString("pai_nome"));
		        pais.getPai().setSobrenome(rs.getString("pai_sobrenome"));
		        pais.getPai().setIdade(rs.getInt("pai_idade"));
		        pais.getPai().setCargo(rs.getString("pai_cargo"));
		        pais.getPai().setTelefone(rs.getString("pai_telefone"));
		        pais.getPai().setEmail(rs.getString("pais_email"));
		        pais.getPai().setSenha(rs.getString("pais_senha"));
		        pais.getPai().setDataNascimento(rs.getDate("pai_datanascimento"));
		    } 
	        conn.close();
	        stmt.close();
	        rs.close();
		 } catch (SQLException e) {
			 	//e.printStackTrace();
		 }
		 return pais; 
		}
	
	public static boolean cadastrar(Pais pais) {
    	try {	 
    		Connection conn = Conexao.conectaBanco();
			String queryInsertPais = "INSERT INTO "+tabela+" (pais_email, pais_senha, mae_nome, mae_sobrenome, mae_cpf, mae_idade, mae_telefone, mae_cargo, mae_datanascimento, pai_nome, pai_sobrenome, pai_cpf, pai_idade, pai_telefone, pai_cargo, pai_datanascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(queryInsertPais);
			stmt.setString(1, pais.getEmail());
			stmt.setString(2, pais.getSenha());
			stmt.setString(3, pais.getMae().getNome());
			stmt.setString(4, pais.getMae().getSobrenome());
			stmt.setString(5, pais.getMae().getCpf());
			stmt.setInt(6, pais.getMae().getIdade());
			stmt.setString(7, pais.getMae().getTelefone());
			stmt.setString(8, pais.getMae().getCargo());
			stmt.setDate(9,pais.getMae().getDataNascimento());
			stmt.setString(10, pais.getPai().getNome());
			stmt.setString(11, pais.getPai().getSobrenome());
			stmt.setString(12, pais.getPai().getCpf());
			stmt.setInt(13, pais.getPai().getIdade());
			stmt.setString(14, pais.getPai().getTelefone());
			stmt.setString(15, pais.getPai().getCargo());
			stmt.setDate(16, pais.getPai().getDataNascimento());
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
		return true;
	}
	
	
	
	public static boolean alterar(Pais pais) {
	    try {
	        Connection conn = Conexao.conectaBanco();
	        String queryUpdate = "UPDATE tb_pais SET mae_cpf = ?, mae_nome = ?, mae_sobrenome = ?, mae_idade = ?, mae_telefone = ?, mae_datanascimento = ?, mae_cargo = ?, pai_cpf = ?, pai_nome = ?, pai_sobrenome = ?, pai_idade = ?, pai_telefone = ?, pai_datanascimento = ?, pai_cargo = ? WHERE pais_codigo = ?";
	        PreparedStatement stmtQueryPais = conn.prepareStatement(queryUpdate);
	        stmtQueryPais.setString(1, pais.getMae().getCpf());
	        stmtQueryPais.setString(2, pais.getMae().getNome());
	        stmtQueryPais.setString(3, pais.getMae().getSobrenome());
	        stmtQueryPais.setInt(4, pais.getMae().getIdade());
	        stmtQueryPais.setString(5, pais.getMae().getTelefone());
	        stmtQueryPais.setDate(6, pais.getMae().getDataNascimento());
	        stmtQueryPais.setString(7, pais.getMae().getCargo());
	        stmtQueryPais.setString(8, pais.getPai().getCpf());
	        stmtQueryPais.setString(9, pais.getPai().getNome());
	        stmtQueryPais.setString(10, pais.getPai().getSobrenome());
	        stmtQueryPais.setInt(11, pais.getPai().getIdade());
	        stmtQueryPais.setString(12, pais.getPai().getTelefone());
	        stmtQueryPais.setDate(13, pais.getPai().getDataNascimento());
	        stmtQueryPais.setString(14, pais.getPai().getCargo());
	        stmtQueryPais.setInt(15, pais.getCodigo());
	        int linhasAfetadas = stmtQueryPais.executeUpdate();
	        if (linhasAfetadas > 0) {
	            stmtQueryPais.close();
	            conn.close();
	            return true;
	        }
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    } 
	    
	    return false;
	}

	
	
	
	
}
