package Classe.DTO;

import java.sql.Date;

public class Pai extends Pessoa {	
	public Pai() {}
	
	public Pai(String cpf, String nome, String sobrenome, int idade, String telefone, Date dataNascimento, String cargo) {
		super(cpf, nome, sobrenome, idade, telefone, dataNascimento, cargo);
	}
}
