package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Administrador;

public class AdministradorDAO {
	private static final String tabela = "tb_funcionarios";
	
	public static boolean verificar(Administrador administrador) {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM "+tabela+" WHERE (func_email = ? AND func_senha = ? AND func_cargo ilike 'Administrador') OR func_codigo = ? OR func_cpf = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, administrador.getEmail());
	        stmt.setString(2, administrador.getSenha());
	        stmt.setInt(3, administrador.getCodigo());
	        stmt.setString(4, administrador.getCpf());
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
	
	
	public static Administrador visualizar(Administrador administrador) {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM "+tabela+" WHERE (func_email = ? AND func_senha = ? AND func_cargo ilike 'Administrador') OR func_codigo = ? OR func_cpf = ?  ";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, administrador.getEmail());
	        stmt.setString(2, administrador.getSenha());
	        stmt.setInt(3, administrador.getCodigo());
	        stmt.setString(4, administrador.getCpf());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            administrador.setCodigo(rs.getInt("func_codigo"));
	            administrador.setCpf(rs.getString("func_cpf"));
	            administrador.setNome(rs.getString("func_nome"));
	            administrador.setCargo(rs.getString("func_cargo"));
	            administrador.setSobrenome(rs.getString("func_sobrenome"));
	            administrador.setIdade(rs.getInt("func_idade"));
	            administrador.setTelefone(rs.getString("func_telefone"));
	            administrador.setDataNascimento(rs.getDate("func_datanascimento"));
	            administrador.setEmail(rs.getString("func_email"));
	            administrador.setSenha(rs.getString("func_senha"));
	        } 
	        conn.close();
	        stmt.close();
	        rs.close();
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    }
	    return administrador;
	}
	
	

}
