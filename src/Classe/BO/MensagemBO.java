package Classe.BO;

import java.sql.SQLException;
import Classe.DAO.MensagemDAO;
import Classe.DTO.*;

public class MensagemBO {
	public boolean addMensagemDestinatario(Mensagem mensagem) {	
		return MensagemDAO.addDestinatario(mensagem);
	}

	public Mensagem visualizarMensagemDestinatario(Mensagem mensagem) throws SQLException {
		return MensagemDAO.visualizarMensagemDestinatario(mensagem);
	}
	
	public boolean addMensagenRemetente(Mensagem mensagem) throws SQLException {
		return MensagemDAO.addRemetente(mensagem);
	}
	
	public String addMensagemRemetente(Mensagem mensagem) throws SQLException {
		addMensagemDestinatario(mensagem);
		// Pega a mensagem do destinatario cadastrado no banco 
		Mensagem mensagemComCodigo = visualizarMensagemDestinatario(mensagem);	
		enviarEmail(mensagemComCodigo);
		addMensagenRemetente(mensagemComCodigo);
		return "Mensagem enviado com sucesso!";
	}
	
	public boolean enviarEmail(Mensagem mensagem) {
		 return MensagemDAO.enviarEmail(mensagem);
	}
	

}
