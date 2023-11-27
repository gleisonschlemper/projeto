package Classe.BO;

import Classe.DAO.EnderecoDAO;
import Classe.DTO.Endereco;

public class EnderecoBO {
	public boolean exite(Endereco endereco) {
		return EnderecoDAO.verificar(endereco);
	}

	public boolean cadastrar(Endereco endereco) {
		if(exite(endereco)) return false;
		
		return EnderecoDAO.cadastrar(endereco);
	}
	
	public Endereco visualizar(Endereco endereco) {
		if(exite(endereco)) return EnderecoDAO.visualizar(endereco);
			
		return endereco;
	}
	
	public boolean alterar(Endereco endereco) {
		return EnderecoDAO.alterar(endereco);
	}
}
