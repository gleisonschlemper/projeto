package Classe.DTO;

import java.sql.Date;

public class Professor extends Pessoa{
	private static final String cargo = "Professor";

	public Professor() {}
	
	public Professor(int codigo) {
		super(codigo);
	}
	
	public Professor(String email, String senha) {
		super(email, senha);
	}
	
	public Professor(int codigo, String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento) {
		super(codigo, cpf, nome, sobrenome, idade, email, senha, telefone, dataNascimento, cargo);
	}
	
	public Professor(String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, email, senha, telefone, dataNascimento, cargo);
	}
}
