package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Pais;

public class PaisDAO {
	public static boolean verificar(Pais pais) {	
		 try {
			 Connection conn = Conexao.conectaBanco();
	         String querySelect = "SELECT * FROM tb_pais WHERE (pai_cpf = ? AND mae_cpf = ?) OR pais_codigo = ?"; // Cria o o select dos pais
	         PreparedStatement stmt = conn.prepareStatement(querySelect); 
	         stmt.setString(1, pais.getPai().getCpf()); 
	         stmt.setString(2, pais.getMae().getCpf());
	         stmt.setInt(3, pais.getCodigo()); 
	         ResultSet rs = stmt.executeQuery(); 
	         if (rs.next()) return rs.getInt(1) > 0; 
	        } 
	        catch (SQLException e) {
	        	System.out.println(e.getMessage()); 
	        }
			return false; 
	}
	
	public static boolean cadastrar(Pais pais) {
    	try {	 
    		Connection conn = Conexao.conectaBanco();
			String queryInsertPais = "INSERT INTO tb_pais (pais_email, pais_senha, mae_nome, mae_sobrenome, mae_cpf, mae_idade, mae_telefone, mae_datanascimento, pai_nome, pai_sobrenome, pai_cpf, pai_idade, pai_telefone, pai_datanascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmtInsertPais = conn.prepareStatement(queryInsertPais);
			stmtInsertPais.setString(1, pais.getEmail());
			stmtInsertPais.setString(2, pais.getSenha());
			stmtInsertPais.setString(3, pais.getMae().getNome());
			stmtInsertPais.setString(4, pais.getMae().getSobrenome());
			stmtInsertPais.setString(5, pais.getMae().getCpf());
			stmtInsertPais.setInt(6, pais.getMae().getIdade());
			stmtInsertPais.setString(7, pais.getMae().getTelefone());
			stmtInsertPais.setDate(8,pais.getMae().getDataNascimento());
			stmtInsertPais.setString(9, pais.getPai().getNome());
			stmtInsertPais.setString(10, pais.getPai().getSobrenome());
			stmtInsertPais.setString(11, pais.getPai().getCpf());
			stmtInsertPais.setInt(12, pais.getPai().getIdade());
			stmtInsertPais.setString(13, pais.getPai().getTelefone());
			stmtInsertPais.setDate(14, pais.getPai().getDataNascimento());
			stmtInsertPais.executeUpdate();
		}
		catch (SQLException e) {
			  System.out.println(e.getMessage());
		}	
		return true;
	}
	
	public static Pais visualizar(Pais pais) { 
		 try {
			Connection conn = Conexao.conectaBanco();
		    String querySelect = "SELECT * FROM tb_pais WHERE (pai_cpf = ? AND mae_cpf = ?) OR pais_codigo = ?";	        
		    PreparedStatement stmtQueryPais = conn.prepareStatement(querySelect);      
		    stmtQueryPais.setString(1, pais.getPai().getCpf());
		    stmtQueryPais.setString(2, pais.getMae().getCpf());
		    stmtQueryPais.setInt(3, pais.getCodigo());
		    
		    ResultSet rs = stmtQueryPais.executeQuery();    
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
		        pais.getMae().setDataNascimento(rs.getDate("mae_datanascimento"));
		        pais.getPai().setCpf(rs.getString("pai_cpf"));
		        pais.getPai().setNome(rs.getString("pai_nome"));
		        pais.getPai().setSobrenome(rs.getString("pai_sobrenome"));
		        pais.getPai().setIdade(rs.getInt("pai_idade"));
		        pais.getPai().setEmail(rs.getString("pais_email"));
		        pais.getPai().setSenha(rs.getString("pais_senha"));
		        pais.getPai().setDataNascimento(rs.getDate("pai_datanascimento"));
		        return pais;
		    } 
		 } catch (SQLException e) {
		        System.out.println(e.getMessage());
		 }
		 return pais; 
		}
	
	
	public static boolean alterar(Pais pais) {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        String queryUpdate = "UPDATE tb_pais SET mae_cpf = ?, mae_nome = ?, mae_sobrenome = ?,  mae_idade = ?, mae_telefone = ?, mae_datanascimento = ?, pai_cpf = ?, pai_nome = ?, pai_sobrenome = ?, pai_idade = ?, pai_telefone = ?, pai_datanascimento = ? WHERE pais_codigo = ?";
	        PreparedStatement stmtQueryPais = conn.prepareStatement(queryUpdate);
	        stmtQueryPais.setString(1, pais.getMae().getCpf());
	        stmtQueryPais.setString(2, pais.getMae().getNome());
	        stmtQueryPais.setString(3, pais.getMae().getSobrenome());
	        stmtQueryPais.setInt(4, pais.getMae().getIdade());
	        stmtQueryPais.setString(5, pais.getMae().getTelefone());
	        stmtQueryPais.setDate(6, pais.getMae().getDataNascimento());
	        stmtQueryPais.setString(7, pais.getPai().getCpf());
	        stmtQueryPais.setString(8, pais.getPai().getNome());
	        stmtQueryPais.setString(9, pais.getPai().getSobrenome());
	        stmtQueryPais.setInt(10, pais.getPai().getIdade());
	        stmtQueryPais.setString(11, pais.getPai().getTelefone());
	        stmtQueryPais.setDate(12, pais.getPai().getDataNascimento());
	        stmtQueryPais.setInt(13, pais.getCodigo());
	        stmtQueryPais.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } 
	    
	    return true;
	}
}
