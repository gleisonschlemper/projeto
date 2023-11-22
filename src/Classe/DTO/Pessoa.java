package Classe.DTO;

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
    
    public Pessoa(String cpf, String nome, String sobrenome,int idade,String email,String senha,String telefone,String cargo, java.sql.Date dataNascimento) {
		setCpf(cpf);
		setIdade(idade);
		setDataNascimento(dataNascimento);
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setTelefone(telefone);
		setSenha(senha);
		setCargo(cargo);
	}

	public Pessoa(String cpf, String nome, String sobrenome, int idade, java.sql.Date dataNascimento) {
		setCpf(cpf);
		setIdade(idade);
		setDataNascimento(dataNascimento);
		setNome(nome);
		setSobrenome(sobrenome);
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
}
