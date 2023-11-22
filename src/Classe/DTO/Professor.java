package Classe.DTO;

import java.sql.Date;

public class Professor extends Pessoa{
	private static String cargo = "Professor";
	
	public Professor(String cpf) {
		super(cpf);
	}
	
	public Professor(String cpf, String nome, String sobrenome, int idade, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
	}
	
	public Professor(int codigo, String cpf, String nome, String sobrenome, int idade, String email,String senha, String telefone, Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, email,senha,telefone, cargo, dataNascimento);
		setCodigo(codigo);
	}
	
}
