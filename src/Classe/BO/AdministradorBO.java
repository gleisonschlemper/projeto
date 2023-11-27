package Classe.BO;

import Classe.DAO.AdministradorDAO;
import Classe.DTO.Administrador;

public class AdministradorBO {
	public boolean existe(Administrador administrador) {
		return AdministradorDAO.verificar(administrador);
	}
	
	public Administrador visualizar(Administrador administrador) {
		if(existe(administrador)) {
			return AdministradorDAO.visualizar(administrador);
		}	
		
		return administrador;
	}
	
}
