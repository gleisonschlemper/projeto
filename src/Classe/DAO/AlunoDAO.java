package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classe.Conexao.Conexao;
import Classe.DTO.Aluno;

public class AlunoDAO  {
	private static final String tabela = "tb_matriculados";
	
	public static boolean verificar(Aluno aluno) {
		try { // Execução do código corretamente 
        	Connection conn = Conexao.conectaBanco();
            String querySelect = "SELECT * FROM "+tabela+" WHERE mat_cpf = ? OR (mat_email = ? AND mat_senha = ?)"; 
        	PreparedStatement stmt = conn.prepareStatement(querySelect); 
            stmt.setString(1, aluno.getCpf()); 
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getSenha());
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return true;
            }
        } 
        catch (SQLException e) {
        	//System.out.println(e.getMessage()); 
        }
		return false; 
	}
	
	public static boolean Alterar(Aluno aluno) {
		try {
	        Connection conn = Conexao.conectaBanco();
	        String queryInsertMatricula = "UPDATE "+tabela+" SET (mat_nome = ?, mat_sobrenome = ?, mat_email = ?, mat_senha = ?, mat_idade = ?, mat_telefone, mat_datanascimento = ?) WHERE mat_cpf = ?";
	        PreparedStatement stmt = conn.prepareStatement(queryInsertMatricula);
	        stmt.setString(1, aluno.getNome());
	        stmt.setString(2, aluno.getSobrenome());
	        stmt.setString(3, aluno.getEmail());
	        stmt.setString(4, aluno.getSenha());
	        stmt.setInt(5, aluno.getIdade());
	        stmt.setString(6, aluno.getTelefone());
	        stmt.setDate(7, (java.sql.Date) aluno.getDataNascimento());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return true;
            }
	    } catch (SQLException e) {
	        //System.out.println(e.getMessage());
	    }
	    return false;
	}	
	
	public static Aluno visualizar(Aluno aluno) {
        try {
    		Connection conn = Conexao.conectaBanco();	    
    		String queryAluno = "SELECT * FROM "+tabela+" WHERE mat_cpf = ? OR mat_codigo= ? OR (mat_email = ? AND mat_senha = ?)";
            PreparedStatement stmt = conn.prepareStatement(queryAluno);
            stmt.setString(1, aluno.getCpf());
            stmt.setInt(2, aluno.getCodigo());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getSenha());
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {    
                aluno.setCpf(rs.getString("mat_cpf"));
                aluno.setNome(rs.getString("mat_nome"));
                aluno.setSobrenome(rs.getString("mat_sobrenome"));
                aluno.setEmail(rs.getString("mat_email"));
                aluno.setSenha(rs.getString("mat_senha"));
                aluno.setIdade(rs.getInt("mat_idade"));
                aluno.setDataNascimento(rs.getDate("mat_datanascimento"));
                aluno.setTelefone(rs.getString("mat_telefone"));
                aluno.getEndereco().setCodigo(rs.getInt("end_codigo"));
                aluno.getPais().setCodigo(rs.getInt("pais_codigo")); 
            }  
            conn.close();
	        stmt.close();
	        rs.close();
            return aluno; 
        } catch (SQLException e) {
           //System.out.println(e.getMessage());
        }	
    return aluno;
	}
}
