package Classe.DTO;

import java.sql.Date;

public class Aluno extends Pessoa {
	private Pais pais;
	private Endereco endereco;
	private Escola  escola;
	
	public Aluno() {}
	
	public Aluno (String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento, Pais pais, Endereco endereco, Escola escola) {
		super(cpf, nome, sobrenome, idade, email, senha, telefone, dataNascimento);
		setPais(pais);
		setEndereco(endereco);
		setEscola(escola);
	}
	
	public Aluno(String email, String senha){
		super(email, senha);
	}
	
	public Aluno(String cpf) {
		super(cpf);
	}

	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	} 
	
	
	
}
