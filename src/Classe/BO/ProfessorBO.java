package Classe.BO;

import Classe.DAO.*;
import Classe.DTO.*;

public class ProfessorBO {
	
	public boolean existe(Professor professor) {
		return ProfessorDAO.verificar(professor);
	}
	
	public Professor visualizar(Professor professor) {
		if(existe(professor)) {
			return ProfessorDAO.visualizar(professor);
		}			
		return professor;
	}
	
	
}
