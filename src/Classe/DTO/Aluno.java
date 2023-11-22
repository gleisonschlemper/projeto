package Classe.DTO;

import java.sql.Date;
import java.util.ArrayList;

public class Aluno extends Pessoa {
	private Pais pais;
	private Matricula matricula;
	private Endereco endereco;
	private ArrayList <Matricula> matriculas = new ArrayList<>();
	private ArrayList <Mensagem> mensagens = new ArrayList<>();
    
	 // Seta informações importante para encontrar o aluno
    public Aluno(String cpf, String nome, String sobrenome, int idade,String telefone, String email, String senha,Date nascimento, Matricula matricula) {
    	 super(cpf,nome,sobrenome,idade,nascimento);
    	 setEmail(email);
    	 setSenha(senha);
    	 addMatricula(matricula);
    	 setTelefone(telefone);
    }  
       
    // Seta somente CPF do aluno 
    public Aluno(String cpf) {
    	 super(cpf);
    }
    
    public Aluno(Matricula matricula) {
    	addMatricula(matricula);
    }
    
    public Aluno(Matricula matricula, String email, String senha) {
    	addMatricula(matricula);
    	setEmail(email);
    	setSenha(senha);
    }
    
    // Seta somente CPF e Matricula do aluno 
    public Aluno(Matricula matricula,String cpf) {
    	 super(cpf);
    	 addMatricula(matricula);
    }
      
    public Endereco getEndereco() {
		return endereco;
	}

	public void addEndereco (Endereco endereco) {
		this.endereco = endereco;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public ArrayList <Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas (Matricula matriculaAluno) {
		this.matriculas.add(matriculaAluno);
	}
    
    public ArrayList <Mensagem> getMensagens() {
		return this.mensagens;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}

    public void addPais(Pais pais) {
    	this.pais = pais;
    }
    
    public Pai verPai() {
    	return this.pais.getPai();
    }
    
    public Mae verMae() {
    	return this.pais.getMae();
    }
    
    public String nomeDaMae () {
    	return this.verMae().getNome();
    }

	public Matricula getMatricula() {
		return matricula;
	}

	public void addMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
