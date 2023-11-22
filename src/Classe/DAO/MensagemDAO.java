package Classe.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Classe.Conexao.Conexao;
import Classe.DTO.*;

public class MensagemDAO {
	private static String emailFrom = "dev.schlemper@gmail.com"; // Email institucional 
    private static String passwordFrom = "gpxz avkd gewv hmee"; // Senha do email para aplicações
    
	public static boolean addDestinatario(Mensagem mensagem) {	
		try {
			Date data = new Date();
			mensagem.setDataEnvio(new java.sql.Date(data.getTime()));
			mensagem.setHoraEnvio(new java.sql.Time(data.getTime()));
			Connection conn = Conexao.conectaBanco();
	        String queryInsert = "INSERT INTO tb_mensagem (func_codigo, mens_assunto, mens_conteudo, mens_data, mens_hora) VALUES (?, ?, ?, ?,?)";     
	        PreparedStatement stmt = conn.prepareStatement(queryInsert);
	        stmt.setInt(1, mensagem.getRemetente().getCodigo());
	        stmt.setString(2, mensagem.getAssunto());
	        stmt.setString(3, mensagem.getConteudo());
	        stmt.setDate(4, new java.sql.Date(data.getTime()));
	        stmt.setTime(5, new java.sql.Time(data.getTime()));
	        ResultSet rs = stmt.executeQuery();
	        conn.close();
		    stmt.close();
		    rs.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return true;
	}

	public static Mensagem visualizarMensagemDestinatario(Mensagem mensagem) throws SQLException {
		try {
			Connection conn = Conexao.conectaBanco();	
			String querySelect = "select * from tb_mensagem where func_codigo = ? AND mens_data = ? AND mens_hora = ?";
		    PreparedStatement stmt = conn.prepareStatement(querySelect);
		    stmt.setInt(1, mensagem.getRemetente().getCodigo());
		    stmt.setDate(2, (java.sql.Date) mensagem.getDataEnvio());
		    stmt.setTime(3, mensagem.getHoraEnvio());
		    ResultSet rs = stmt.executeQuery();
		     if(rs.next()) {
		    	 mensagem.setCodigo(rs.getInt("mens_codigo"));
		    	 mensagem.getRemetente().setCodigo(rs.getInt("func_codigo"));
		    	 mensagem.setAssunto(rs.getString("mens_assunto"));
		    	 mensagem.setConteudo(rs.getString("mens_conteudo"));
		    	 mensagem.setDataEnvio(rs.getDate("mens_data"));
		    	 mensagem.setHoraEnvio(rs.getTime("mens_hora"));
		     }    
		     conn.close();
		     stmt.close();
		     rs.close();
			return mensagem;
		} catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
		
		return mensagem;
	}
	
	public static boolean addRemetente(Mensagem mensagem) throws SQLException {
	    try {
		    Connection conn = Conexao.conectaBanco();
	        for (Aluno aluno : mensagem.getDestinatarios()) {
	            String queryInsert = "INSERT INTO tb_mensagemDestinatario (mens_codigo, alu_matricula) VALUES (?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(queryInsert);
	            stmt.setInt(1, mensagem.getCodigo());
	            stmt.setInt(2, aluno.getMatricula().getMatricula());
	            ResultSet rs = stmt.executeQuery();
	            conn.close();
	            stmt.close();
	            rs.close();
	        }
	        return true; 
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public static boolean enviarEmail(Mensagem mensagem) {
		 	Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        properties.setProperty("mail.smtp.port", "587");
	        properties.setProperty("mail.smtp.user", emailFrom);
	        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        properties.setProperty("mail.smtp.auth", "true");

	        Session mSession = Session.getDefaultInstance(properties);

	        String conteudoFormatado = "Ola meus queridos(as), <br>"
					        		  + mensagem.getConteudo()+", <br>"
					        		  + "Prof: "+mensagem.getRemetente().getNome()+" "
					        		  +	mensagem.getRemetente().getSobrenome()+", <br>";
	        
	        try {
	        	for(Aluno aluno : AlunoDAO.listar()) {
	        		MimeMessage mCorreo = new MimeMessage(mSession);
		            mCorreo.setFrom(new InternetAddress(emailFrom));
		            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(aluno.getEmail()));
		            mCorreo.setSubject(mensagem.getAssunto());
		            mCorreo.setText(conteudoFormatado, "ISO-8859-1", "html");
		            Transport transport = mSession.getTransport("smtp");
		            transport.connect(emailFrom, passwordFrom);
		            transport.sendMessage(mCorreo, mCorreo.getAllRecipients());
		            transport.close();
	        	}
	            return true;
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        return false;
	}
}
