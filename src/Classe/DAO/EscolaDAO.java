package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.*;


public class EscolaDAO {
	private static final String tabela = "tb_escola"; 
	
	public static Escola visualizar (Escola escola) {
		 try  { // Execução do código corretamente 
			 Connection conn = Conexao.conectaBanco();
	         String querySelect = "SELECT * FROM "+tabela+" where esc_codigo = ?"; // Cria o select do aluno     
	         PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
	         stmt.setInt(1, escola.getCodigo());
		     ResultSet rs = stmt.executeQuery(); // Executa o select
	         if (rs.next()) { // Excuta quantos objetos foram encontrado
	        	escola.setNome(rs.getString("esc_nome"));
	        	escola.setRua(rs.getString("esc_rua")); 
	        	escola.setBairro(rs.getString("esc_bairro"));
	        	escola.setCidade(rs.getString("esc_cidade"));
	        	escola.setTelefone(rs.getString("esc_telefone"));
	        	escola.setEmail(rs.getString("esc_email"));
	         }
	         conn.close();
	         stmt.close();
	         rs.close();
	     } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	    	// e.printStackTrace(); //System.out.println(e.getMessage()); Mensagem de erro 
	     }
		return escola;	
	}
	
	
}
