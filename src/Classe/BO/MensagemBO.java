package Classe.BO;

import java.sql.SQLException;
import java.util.List;
import Classe.DAO.MensagemDAO;
import Classe.DTO.*;

public class MensagemBO {
	public boolean addMensagemRemetente(Mensagem mensagem) {	
		return MensagemDAO.addRemetente(mensagem);
	}

	public Mensagem visualizarMensagemDestinatario(Mensagem mensagem) throws SQLException {
		return MensagemDAO.visualizarMensagemRemetente(mensagem);
	}
	
	public boolean addMensagensDestinatarios(Mensagem mensagem) throws SQLException {
		return MensagemDAO.addDestinatario(mensagem);
	}
	
	public String addMensagemDestinatario(Mensagem mensagem) throws SQLException {
		addMensagemRemetente(mensagem);
		Mensagem mensagemComCodigo = visualizarMensagemDestinatario(mensagem);	// Pega a mensagem do remetente cadastrado no banco 
		enviarEmail(mensagemComCodigo);
		addMensagensDestinatarios(mensagemComCodigo);
		return "Mensagem enviado com sucesso!";
	}
	
	public boolean enviarEmail(Mensagem mensagem) {
		 return MensagemDAO.enviarEmail(mensagem);
	}
	
	public List <Mensagem> consultarMensagensPorDestinatario(Mensagem mensagem) throws SQLException {
		
		return MensagemDAO.consultarMensagensPorDestinatario(mensagem);
	}

}