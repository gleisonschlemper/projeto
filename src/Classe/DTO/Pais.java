package  Classe.DTO;

public class Pais {
	private int codigo = 0;
	private String email = "";
	private String senha = "";
	private Pai pai;
	private Mae mae;
	
	public Pais(Mae mae,Pai pai) {
		setMae(mae);
		setPai(pai);
	}
	
	public Pais(int codigo, Mae mae, Pai pai) {
		setCodigo(codigo);
		setMae(mae);
		setPai(pai);
	}
	
	public Pais(String email, String senha) {
		setEmail(email);
		setSenha(senha);
	}
	
	public Pais(String email,String senha,Mae mae,Pai pai){
		setEmail(email);
		setSenha(senha);
		setMae(mae);
		setPai(pai);
	}
	
	
	public Pais(int codigo,String email,String senha,Mae mae,Pai pai) {
		setEmail(email);
		setSenha(senha);
		setMae(mae);
		setPai(pai);
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

	public Pai getPai() {
		return pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public Mae getMae() {
		return mae;
	}

	public void setMae(Mae mae) {
		this.mae = mae;
	}
	
}
