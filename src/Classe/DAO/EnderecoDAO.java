package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Endereco;

public class EnderecoDAO {
	private static final String tabela = "tb_enderecos";
	
	public static boolean verificar(Endereco endereco) {
	    try {
	    	Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM "+tabela+" WHERE (end_rua = ? AND end_bairro = ? AND end_cidade = ? AND end_casanumero = ? AND end_cep = ?) OR end_codigo = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, endereco.getRua());
	        stmt.setString(2, endereco.getBairro());
	        stmt.setString(3, endereco.getCidade());
	        stmt.setInt(4, endereco.getCasanumero());
	        stmt.setString(5, endereco.getCep());
	        stmt.setInt(6, endereco.getCodigo());
	        ResultSet rs = stmt.executeQuery();
	        if(rs.next()) {
	        	conn.close();
	        	stmt.close();
	        	rs.close();
	        	return true;
	        }
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    }
	    return false;
	}
	
	public static boolean cadastrar(Endereco endereco) {
	     try {
	 	     Connection conn = Conexao.conectaBanco();
	         String queryInsertEndereco = "INSERT INTO "+tabela+" (end_rua, end_bairro, end_cidade, end_casanumero, end_cep) VALUES (?, ?, ?, ?, ?)";
	         PreparedStatement stmt = conn.prepareStatement(queryInsertEndereco);
	         stmt.setString(1, endereco.getRua());
	         stmt.setString(2, endereco.getBairro());
	         stmt.setString(3, endereco.getCidade());
	         stmt.setInt(4, endereco.getCasanumero());
	         stmt.setString(5, endereco.getCep());
	         ResultSet rs = stmt.executeQuery();
		     if(rs.next()) {
		        conn.close();
		        stmt.close();
		        rs.close();
		        return true;
		     }
	       } 
	     catch (SQLException e) {
	    	 //e.printStackTrace();
	     }
	     
	    return false;
	}

	public static Endereco visualizar(Endereco endereco) {
		try {
		     Connection conn = Conexao.conectaBanco();
			 String querySelect = "SELECT * FROM tb_enderecos WHERE (end_rua = ? AND end_bairro = ? AND end_cidade = ? AND end_casanumero = ? AND end_cep = ?) OR end_codigo = ?";
			 PreparedStatement stmt = conn.prepareStatement(querySelect);
			 stmt.setString(1, endereco.getRua());
			 stmt.setString(2, endereco.getBairro());
			 stmt.setString(3, endereco.getCidade());
			 stmt.setInt(4, endereco.getCasanumero());
			 stmt.setString(5, endereco.getCep());
			 stmt.setInt(6, endereco.getCodigo());
			 ResultSet rs = stmt.executeQuery();
			 if(rs.next()) {
				  endereco.setCodigo(rs.getInt("end_codigo"));
				  endereco.setRua(rs.getString("end_rua"));
				  endereco.setBairro(rs.getString("end_bairro"));
				  endereco.setCidade(rs.getString("end_cidade"));
				  endereco.setCasanumero(rs.getInt("end_casanumero"));
				  endereco.setCep(rs.getString("end_cep"));
			 }
			 
			 conn.close();
			 stmt.close();
			 rs.close();
			 return endereco;
			} 
		catch (SQLException e) {
			// System.out.println(e.getMessage());
		}
		
		return endereco;
	}
	
	public static boolean alterar (Endereco endereco) {
		try {
			 Connection conn = Conexao.conectaBanco();
			 String queryUpdateAluno = "UPDATE tb_enderecos SET end_rua = ?, end_bairro = ?, end_cidade = ?, end_casanumero = ?, end_cep = ? WHERE end_codigo = ?";
	         PreparedStatement stmt = conn.prepareStatement(queryUpdateAluno);			
	         stmt.setString(1, endereco.getRua());
	         stmt.setString(2, endereco.getBairro());
	         stmt.setString(3, endereco.getCidade());
	         stmt.setInt(4, endereco.getCasanumero());
	         stmt.setString(5, endereco.getCep());
	         stmt.setInt(6, endereco.getCodigo() );
	         ResultSet rs = stmt.executeQuery();
	         conn.close();
	         stmt.close();
	         rs.close(); 
		}
		catch (SQLException e) {
			//e.printStackTrace();
	    }
        return true;
	}
}
