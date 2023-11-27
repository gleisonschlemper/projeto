package Classe.DTO;

public class Endereco {
	private int codigo = 0;
	private String rua = "";
	private String bairro = "";
	private String cidade = "";
	private int casanumero = 0;
	private String cep = "";
	
	public Endereco() {}
	
	public Endereco (int codigo) {
		setCodigo(codigo);
	}
	
	public Endereco (int codigo,String rua,String bairro, String cidade, int casanumero, String cep) {
		setCodigo(codigo);
		setRua(rua);
		setCidade(cidade);
		setCasanumero(casanumero);
		setCep(cep);
		setBairro(bairro);
	}
	
	public Endereco(String rua, String bairro, String cidade,  int casanumero, String cep) {
		setRua(rua);
		setCidade(cidade);
		setCasanumero(casanumero);
		setCep(cep);
		setBairro(bairro);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getCasanumero() {
		return casanumero;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCasanumero(int casanumero) {
		this.casanumero = casanumero;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}	
}
