package Classe.DTO;

import java.sql.Date;

public class Administrador extends Pessoa {
	private static final String cargo = "Administrador";

	public Administrador() {}
	
	public Administrador(int codigo) {
		super(codigo);
	}
	
	public Administrador(String cpf){
		super(cpf);
	}
	
	public Administrador(String email, String senha){
		super(email, senha);
	}
	
	public Administrador(int codigo, String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento) {
		super(codigo, cpf, nome, sobrenome, idade, email, senha, telefone, dataNascimento, cargo);
	}
	
	public Administrador(String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, email, senha, telefone, dataNascimento, cargo);
	}
}
