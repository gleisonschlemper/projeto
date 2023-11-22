package Classe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classe.Conexao.Conexao;
import Classe.DTO.Aluno;
import Classe.DTO.Endereco;
import Classe.DTO.Mae;
import Classe.DTO.Matricula;
import Classe.DTO.Mensagem;
import Classe.DTO.Pai;
import Classe.DTO.Pais;

public class AlunoDAO {
	public static boolean verificar(Aluno aluno) {		
        try { // Execução do código corretamente 
        	Connection conn = Conexao.conectaBanco();
            String querySelect = "SELECT * FROM tb_alunos WHERE (alu_cpf = ?) OR (alu_matricula = ?) OR (alu_email = ? AND alu_senha = ?)"; 
        	PreparedStatement stmt = conn.prepareStatement(querySelect); 
            stmt.setString(1, aluno.getCpf()); 
            stmt.setInt(2, aluno.getMatricula().getMatricula()); 
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getSenha());
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {
                stmt.close();
                rs.close();
                conn.close();
                return true;
            }
        } 
        catch (SQLException e) {
        	System.out.println(e.getMessage()); 
        }
		return false; 
    }
	
	public static boolean cadastrar(Aluno aluno) {
		try {
			Connection conn = Conexao.conectaBanco();
	        String queryInsertAluno = "INSERT INTO tb_alunos (alu_cpf, alu_nome, alu_sobrenome, alu_email, alu_senha, alu_idade, alu_telefone, alu_datanascimento, alu_datamatricula,end_codigo, pais_codigo) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(queryInsertAluno);
	        stmt.setString(1, aluno.getCpf());
	        stmt.setString(2, aluno.getNome());
	        stmt.setString(3, aluno.getSobrenome());
	        stmt.setString(4, aluno.getEmail());
	        stmt.setString(5, aluno.getSenha());
	        stmt.setInt(6, aluno.getIdade());
	        stmt.setString(7, aluno.getTelefone() );
	        stmt.setDate(8, aluno.getDataNascimento());
	        stmt.setDate(9, aluno.getMatricula().getDataMatricula());    
	        stmt.setInt(10,aluno.getEndereco().getCodigo());
	        stmt.setInt(11, aluno.getPais().getCodigo());
	        ResultSet rs = stmt.executeQuery();
	        conn.close();
	        stmt.close();
	        rs.close();
		 } catch (SQLException e) {
		    System.out.println(e.getMessage());
		 }
		
    	return true;
    }
	
	public static List <Mensagem> visualizarMensagem(Aluno aluno) {
		List <Mensagem> mensagens = new ArrayList<>(); // Array de alunos
		 try {
	    		Connection conn = Conexao.conectaBanco();	    
	    		String query = "select * from tb_mensagemDestinatario inner join tb_mensagem on  tb_mensagemDestinatario.mens_codigo = tb_mensagem.mens_codigo where alu_matricula = ?";
	    		
	    		 PreparedStatement stmt = conn.prepareStatement(query);
	 	        stmt.setInt(1, aluno.getMatricula().getMatricula());
	            
	            ResultSet rs = stmt.executeQuery(); 
	            while(rs.next()) {    
	                Mensagem mensagem = new Mensagem(
	                		rs.getString("mens_assunto"),
	                		rs.getString("mens_conteudo"),
	                		rs.getDate("mens_data"),
	                		rs.getTime("mens_hora")	
	                	);
	                
	                mensagem.getRemetente().setCodigo(rs.getInt("func_codigo"));
	                mensagens.add(mensagem);
	            }  
	            conn.close();
		        stmt.close();
		        rs.close();
	        } catch (SQLException e) {
	           System.out.println(e.getMessage());
	        }	
		
		return mensagens;
		
	}
	
	public static Aluno visualizar(Aluno aluno) {
	        try {
	    		Connection conn = Conexao.conectaBanco();	    
	    		String queryAluno = "SELECT * FROM tb_alunos WHERE alu_cpf = ? OR alu_matricula = ? OR (alu_email = ? AND alu_senha = ?)";
	            PreparedStatement stmt = conn.prepareStatement(queryAluno);
	            stmt.setString(1, aluno.getCpf());
	            stmt.setInt(2, aluno.getMatricula().getMatricula());
	            stmt.setString(3, aluno.getEmail());
	            stmt.setString(4, aluno.getSenha());
	            ResultSet rs = stmt.executeQuery(); 
	            if (rs.next()) {    
	                aluno.setCpf(rs.getString("alu_cpf"));
	                aluno.setNome(rs.getString("alu_nome"));
	                aluno.setSobrenome(rs.getString("alu_sobrenome"));
	                aluno.setEmail(rs.getString("alu_email"));
	                aluno.setSenha(rs.getString("alu_senha"));
	                aluno.setIdade(rs.getInt("alu_idade"));
	                aluno.setDataNascimento(rs.getDate("alu_datanascimento"));
	                aluno.getMatricula().setMatricula(rs.getInt("alu_matricula"));
	                aluno.getMatricula().setDataMatricula(rs.getDate("alu_datamatricula"));
	                aluno.setTelefone(rs.getString("alu_telefone"));
	                aluno.getEndereco().setCodigo(rs.getInt("end_codigo"));
	                aluno.getPais().setCodigo(rs.getInt("pais_codigo")); 
	            }  
	            conn.close();
		        stmt.close();
		        rs.close();
                return aluno; 
	        } catch (SQLException e) {
	           System.out.println(e.getMessage());
	        }	
	    return aluno;
	}
	 
	 public static boolean alterar(Aluno aluno) {
		     try {
		    	 Connection conn = Conexao.conectaBanco();
		         String queryUpdateAluno = "UPDATE tb_alunos SET alu_nome = ?, alu_sobrenome = ?, alu_email = ?, alu_idade = ?, alu_datanascimento = ? WHERE alu_cpf = ? AND alu_matricula = ?";
		         PreparedStatement stmt = conn.prepareStatement(queryUpdateAluno);
		         stmt.setString(1, aluno.getNome());
		         stmt.setString(2, aluno.getSobrenome());
		         stmt.setString(3, aluno.getEmail());
		         stmt.setInt(4, aluno.getIdade());
		         stmt.setDate(5, aluno.getDataNascimento());
		         stmt.setString(6, aluno.getCpf());
		         stmt.setInt(7, aluno.getMatricula().getMatricula());
		         stmt.setString(8, aluno.getTelefone() );
		         stmt.executeUpdate();
		         conn.close();
		         stmt.close();
		     }
		     catch (SQLException e) {
		         System.out.println(e.getMessage());
		     }
		 
		return false;
	 }	
	 
	public static List <Aluno> listar() { // Função de Listar alunos da escola
	     List <Aluno> alunos = new ArrayList<>(); // Array de alunos
	     try  { // Execução do código corretamente 
			 	Connection conn = Conexao.conectaBanco();
	            String querySelect = "SELECT * FROM tb_alunos"; // Cria o select do aluno     
	        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
	            ResultSet rs = stmt.executeQuery(); // Executa o select
	            while (rs.next()) { // Excuta quantos objetos foram encontrado
	            	Aluno aluno = new Aluno( // Cria o objeto Aluno com os dados do banco de dados 
	            			rs.getString("alu_cpf"),  // Seta o CPF 
	                		rs.getString("alu_nome"), // Seta o nome 
	                		rs.getString("alu_sobrenome"),  // Seta o Sobrenome
	                 		rs.getInt("alu_idade"), // Seta a idade 
	                 		rs.getString("alu_telefone"),
	                		rs.getString("alu_email"),  // Seta o email 
	                		rs.getString("alu_senha"), // Seta a senha           
	                		rs.getDate("alu_datanascimento"), // Seta data de nacimento 
	                		new Matricula(rs.getInt("alu_matricula"),rs.getDate("alu_datamatricula"))
	                );
	            	aluno.addEndereco(new Endereco(rs.getInt("end_codigo")));
	            	aluno.addPais(new Pais(rs.getInt("pais_codigo"), new Mae(), new Pai()));   	
	            	alunos.add(aluno);  // Seta o indece onde pode ser encontrada objeto na memória RAM 
	            }
	            conn.close();
	            rs.close();
	        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
	            System.out.println(e.getMessage()); // Mensagem de erro 
	        }
	        return alunos; // Retorna Array de Alunos da escola 
	  }
}
