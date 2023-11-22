package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Conexao.Conexao;
import Classe.DTO.Administrador;

public class AdministradorDAO {
	public static boolean verificar(Administrador administrador) {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM tb_funcionarios WHERE (func_email = ? AND func_senha = ?) OR func_codigo = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, administrador.getEmail());
	        stmt.setString(2, administrador.getSenha());
	        stmt.setInt(3, administrador.getCodigo());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) return true;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } 
	    return false;
	}
	
	
	public static Administrador visualizar(Administrador administrador) {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        String querySelect = "SELECT * FROM tb_funcionarios WHERE (func_email = ? AND func_senha = ?) OR func_codigo = ?";
	        PreparedStatement stmt = conn.prepareStatement(querySelect);
	        stmt.setString(1, administrador.getEmail());
	        stmt.setString(2, administrador.getSenha());
	        stmt.setInt(3, administrador.getCodigo());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            administrador.setCodigo(rs.getInt("func_codigo"));
	            administrador.setCpf(rs.getString("func_cpf"));
	            administrador.setNome(rs.getString("func_nome"));
	            administrador.setSobrenome(rs.getString("func_sobrenome"));
	            administrador.setIdade(rs.getInt("func_idade"));
	            administrador.setDataNascimento(rs.getDate("func_datanascimento"));
	            administrador.setEmail(rs.getString("func_email"));
	            administrador.setSenha(rs.getString("func_senha"));
	        } 
	        conn.close();
	        stmt.close();
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return administrador;
	}

	
	
}
