package Classe.BO;

import Classe.DAO.*;
import Classe.DTO.*;

public class AlunoBO {
	
	public boolean existe(Aluno aluno) {
		return AlunoDAO.verificar(aluno);
	}
	
	public Aluno visualizar(Aluno aluno) {
		if(existe(aluno)) return AlunoDAO.visualizar(aluno);
		return aluno;
	}

	public String alterarEndereco (Aluno aluno) {
		EnderecoBO enderecoBO = new EnderecoBO();
		if(existe(aluno)) {
			 aluno = visualizar(aluno); //Pega o código do endereco na tabela aluno
			if(enderecoBO.alterar(aluno.getEndereco())) {
				return "Alteração realizado com sucesso!";
			}		
		}
		return "CPF inválido!";
	}
	
	public String alterarPais(Aluno aluno) {
		PaisBO paisBO = new PaisBO();
		
		if(existe(aluno)) {
			aluno = AlunoDAO.visualizar(aluno);  //Pega o código dos pais na tabela aluno
			if(paisBO.alterar(aluno.getPais())) return "Alteração realizado com sucesso!";
		}
		
		return "CPF inválido!";
	}
}
