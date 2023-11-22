package Classe.DTO;

import java.sql.Date;

public class Mae extends Pessoa {
	public Mae() {}
	
	public Mae(String cpf, String nome, String sobrenome, int idade, String telefone ,Date dataNascimento) {
		super(cpf, nome, sobrenome, idade, dataNascimento);
		setTelefone(telefone);
	}
	
	public Mae (String cpf) {
		super(cpf);
	}
}
