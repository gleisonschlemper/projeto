package Classe.BO;

import Classe.DAO.PaisDAO;
import Classe.DTO.Pais;

public class PaisBO {
	
	public boolean existe(Pais pais) {
		return PaisDAO.verificar(pais);
	}
	
	public boolean cadastrar(Pais pais) {
		if(existe(pais)) return false;
		
		return PaisDAO.cadastrar(pais);
	}
	
	public Pais visualizar(Pais pais) {
		if(existe(pais)) return PaisDAO.visualizar(pais);
		
		return pais;
	}
	
	public boolean alterar(Pais pais) {
		return PaisDAO.alterar(pais);
	}

	// FAZER
	public boolean deleter(Pais pais) {
		return false;
	}
}
