package Classe.BO;

import Classe.DAO.EscolaDAO;
import Classe.DTO.Escola;

public class EscolaBO {
	public Escola visualizar(Escola escola) {
		return EscolaDAO.visualizar(escola);
	}
}
