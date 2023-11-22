package Classe.DTO;

import java.sql.Date;

public class Administrador extends Pessoa {
	private static String cargo = "Administrador";
	
	public Administrador(int codigo) {
		super(codigo);
	}
	
	public  Administrador(int codigo, String email, String senha) {
		setCodigo(codigo);
		setEmail(email);
		setSenha(senha);
	}
	
	public Administrador(int codigo, String cpf, String nome, String sobrenome, int idade, String email,String senha, String telefone, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, email,senha,telefone, cargo, dataNascimento);
		setCodigo(codigo);
	}
	
	public Administrador(String cpf, String nome, String sobrenome, int idade, String email,String senha, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}
}
