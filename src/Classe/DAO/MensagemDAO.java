package Classe.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private static String passwordFrom = "vlrq pyfd gdtn yhve"; // Senha de aplicação
    
    private static final String tabelaRemetente = "tb_mensagem";
    private static final String tabelaDestinatario = "tb_mensagemdestinatario";
    
	public static boolean addRemetente(Mensagem mensagem) {	
		try {
			Date data = new Date();
			mensagem.setDataEnvio(new java.sql.Date(data.getTime()));
			mensagem.setHoraEnvio(new java.sql.Time(data.getTime()));
			Connection conn = Conexao.conectaBanco();
	        String queryInsert = "INSERT INTO "+tabelaRemetente+"(func_codigo, mens_assunto, mens_conteudo, mens_data, mens_hora) VALUES (?, ?, ?, ?,?)";     
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
	    	//e.printStackTrace();
	    }
	    return true;
	}
	
	public static boolean addDestinatario(Mensagem mensagem) throws SQLException {
	    try {
	        Connection conn = Conexao.conectaBanco();

	        for (Matricula aluno : mensagem.getDestinatarios()) {
	            String queryInsert = "INSERT INTO " + tabelaDestinatario + " (mens_codigo, mat_codigo) VALUES (?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(queryInsert);
	            stmt.setInt(1, mensagem.getCodigo());
	            stmt.setInt(2, aluno.getCodigo());
	            stmt.executeUpdate();
	            stmt.close();
	        }
	        conn.close();

	        return true;
	    } catch (SQLException e) {
	        //e.printStackTrace();
	    }

	    return false;
	}
	
	public static Mensagem visualizarMensagemRemetente(Mensagem mensagem) throws SQLException {
		try {
			Connection conn = Conexao.conectaBanco();	
			String querySelect = "select * from "+tabelaRemetente+" where func_codigo = ? AND mens_data = ? AND mens_hora = ?";
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
			// System.out.println(e.getMessage());
	    }
		
		return mensagem;
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
        
        String conteudo = "Prezados Pais e Alunos, <br>"
        				+ "Informamos que "+ mensagem.getConteudo()+"<br> <br>"
        				+ "Atenciosamente, <br>"
                  		+ "Escola: EEB Paulo Cordeiro, <br>"
        				+ mensagem.getRemetente().getCargo()+": "+mensagem.getRemetente().getNome()+" "+mensagem.getRemetente().getSobrenome()+", <br>"
        				+ "E-mail: "+mensagem.getRemetente().getEmail()+", <br>"
        				+ "whatsapp: "+mensagem.getRemetente().getTelefone()+", <br>"
        				+ "Mais informações <a href='https://www.escol.as/235263-eeb-paulo-cordeiro'> Acesse nossa pagina </a>";
        try {
        	for(Matricula matricula : mensagem.getDestinatarios()) {
        		MimeMessage mCorreo = new MimeMessage(mSession);
	            mCorreo.setFrom(new InternetAddress(emailFrom));
	            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(matricula.getAluno().getEmail()));
	            mCorreo.setSubject(mensagem.getAssunto());
	            mCorreo.setText(conteudo, "ISO-8859-1", "html");
	            Transport transport = mSession.getTransport("smtp");
	            transport.connect(emailFrom, passwordFrom);
	            transport.sendMessage(mCorreo, mCorreo.getAllRecipients());
	            transport.close();
        	}

            System.out.println("E-mail enviado com sucesso!");
        } catch (Exception e) {
          //System.out.println(e.getMessage());
        }
        
        return true;
	}

	public static List<Mensagem> consultarMensagensPorDestinatario(Mensagem mensagem) {
	    List<Mensagem> mensagens = new ArrayList<>();

	    try {
	        for (Matricula matricula : mensagem.getDestinatarios()) {
	            Connection conn = Conexao.conectaBanco();
	            String querySelect = "SELECT * FROM " + tabelaRemetente + " tm INNER JOIN " + tabelaDestinatario + " tmd ON tm.mens_codigo = tmd.mens_codigo WHERE mat_codigo = ?";
	            PreparedStatement stmt = conn.prepareStatement(querySelect);
	            stmt.setInt(1, matricula.getCodigo());
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Mensagem novaMensagem = new Mensagem();
	                novaMensagem.addRemetente(new Pessoa(rs.getInt("func_codigo")));
	                novaMensagem.setCodigo(rs.getInt("mens_codigo"));
	                novaMensagem.setAssunto(rs.getString("mens_assunto"));
	                novaMensagem.setConteudo(rs.getString("mens_conteudo"));
	                novaMensagem.setDataEnvio(rs.getDate("mens_data"));
	                novaMensagem.setHoraEnvio(rs.getTime("mens_hora"));
	                mensagens.add(novaMensagem);
	            }

	            conn.close();
	            stmt.close();
	            rs.close();
	        }
	    } catch (SQLException e) {
	        // Tratar a exceção ou registrar o erro
	        //e.printStackTrace();
	    }

	    return mensagens;
	}


	
}