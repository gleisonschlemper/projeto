package Classe.BO;

import java.util.List;

import Classe.DAO.AlunoDAO;
import Classe.DAO.EnderecoDAO;
import Classe.DAO.MensagemDAO;
import Classe.DAO.PaisDAO;
import Classe.DTO.Aluno;
import Classe.DTO.Endereco;
import Classe.DTO.Mensagem;
import Classe.DTO.Pais;

public class AlunoBO {
	
	public boolean existe(Aluno aluno) {
		return AlunoDAO.verificar(aluno);
	}
	
	public Aluno visualizar(Aluno aluno) {
		if(existe(aluno)) return AlunoDAO.visualizar(aluno);
	
		return aluno;
	}
	
	public Aluno visualizarCompleto(Aluno aluno) {
		EnderecoBO enderecoBO = new EnderecoBO();
		PaisBO paisBO = new PaisBO();
		Aluno alunoCompleto = visualizar(aluno);
		
		Endereco endereco = enderecoBO.visualizar(aluno.getEndereco());
		Pais pais = paisBO.visualizar(aluno.getPais());
		alunoCompleto.addEndereco(endereco);
		alunoCompleto.addPais(pais);
		return alunoCompleto;
	}
	
	public boolean alterar(Aluno aluno) {
		if(existe(aluno)) return AlunoDAO.alterar(aluno);

		return false;
	}
	
	public String cadastrar(Aluno aluno) {
		if(existe(aluno)) return "Aluno já cadastrado!";
			
		EnderecoBO enderecoBO = new EnderecoBO();
		PaisBO paisBO = new PaisBO();
		
		enderecoBO.cadastrar(aluno.getEndereco());
		paisBO.cadastrar(aluno.getPais());
		
		
		Endereco endereco = enderecoBO.visualizar(aluno.getEndereco());
		Pais pais = paisBO.visualizar(aluno.getPais());
		
		if(endereco.getCodigo() == 0) return "Problema no cadastro do Endereço!";
		if(pais.getCodigo() == 0) return "Problema no cadastro dos pais!";
		
		aluno.addEndereco(endereco);
		aluno.addPais(pais);
		
		AlunoDAO.cadastrar(aluno);
		
		return "Cadastro realizado com sucesso!";
    }
	
	public List <Aluno> listar(){
		return AlunoDAO.listar();
	}
	
	public static List <Aluno> listarCompleto() {
		
		List <Aluno> alunos = AlunoDAO.listar();
		for (Aluno aluno : alunos) {
			aluno.addEndereco(EnderecoDAO.visualizar(aluno.getEndereco()));
			aluno.addPais(PaisDAO.visualizar(aluno.getPais()));
		}
		return alunos;
	}
	
	public String alterarEndereco (Aluno aluno) {
		EnderecoBO enderecoBO = new EnderecoBO();
		
		if(existe(aluno)) {
			Aluno alunoNovo = visualizar(aluno);
			if(enderecoBO.alterar(alunoNovo.getEndereco())) return "Alteração realizado com sucesso!";
		}
		
		return "CPF inválido!";
	}
	
	public List <Mensagem> visualizarMensagens(Aluno aluno){
		return AlunoDAO.visualizarMensagem(aluno);
	}
	
	
	public String alterarPais(Aluno aluno) {
		AlunoBO alunoBO = new AlunoBO();
		EnderecoBO enderecoBO = new EnderecoBO();
		
		if(existe(aluno)) {
			Aluno alunoNovo = AlunoDAO.visualizar(aluno);  
			if(PaisDAO.alterar(alunoNovo.getPais())) return "Alteração realizado com sucesso!";
		}
		
		return "CPF inválido!";
	}
}
