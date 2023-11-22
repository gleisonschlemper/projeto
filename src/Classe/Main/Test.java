package Classe.Main;

import Classe.BO.PaisBO;
import Classe.DAO.AlunoDAO;
import Classe.DAO.PaisDAO;
import Classe.DTO.Aluno;
import Classe.DTO.Mae;
import Classe.DTO.Matricula;
import Classe.DTO.Pai;
import Classe.DTO.Pais;

public class Test {
	public static void main(String[] args) {
		//System.out.println(PaisDAO.visualizar(new Pais(0, new Mae("Maila"), new Pai("12787980") )).getMae().getSenha());
		System.out.println();
		//System.out.println(AlunoDAO.verificar(new Aluno(new Matricula(0),"dev.schlemper@gmail.com","12345")));
		for(Aluno aluno  : AlunoDAO.listar()) {
			System.out.println(aluno.getEmail());
		}
	}
}
