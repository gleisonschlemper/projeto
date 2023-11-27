package Classe.DTO;

import java.sql.Date;

public class Pessoa {
	private int codigo = 0;
    private String cpf = "";
    private String nome = "";
    private String sobrenome = "";
    private int idade = 0;
    private String email = "";
    private String senha = "";
    private String telefone = "";
    private java.sql.Date dataNascimento;
    private String cargo;
    
    public Pessoa() {}
    
    public Pessoa(int codigo) {
    	setCodigo(codigo);
    }
    
    public Pessoa(String cpf) {
    	setCpf(cpf);
    }
    
    public Pessoa(String email, String senha) {
    	setEmail(email);
    	setSenha(senha);
    }
    
	public Pessoa(int codigo, String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento, String cargo) {
		setCodigo(codigo);
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setTelefone(telefone);
		setDataNascimento(dataNascimento);
		setCargo(cargo);
	}
	
	// Seta sem codigo da pessoa
	public Pessoa(String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento, String cargo) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setTelefone(telefone);
		setDataNascimento(dataNascimento);
		setCargo(cargo);
	}
	
	// Seta sem codigo da pessoa e cargo
	public Pessoa(String cpf, String nome, String sobrenome, int idade, String email, String senha,String telefone, Date dataNascimento) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setTelefone(telefone);
		setDataNascimento(dataNascimento);
	}
	
	// Seta sem email e senha
	public Pessoa(String cpf, String nome, String sobrenome, int idade, String telefone, Date dataNascimento, String cargo) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
		setTelefone(telefone);
		setDataNascimento(dataNascimento);
		setCargo(cargo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    
    
	
}
