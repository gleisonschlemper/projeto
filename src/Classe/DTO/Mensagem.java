package Classe.DTO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Mensagem {
    private int codigo; 
    private Pessoa remetente;
    private List <Matricula> destinatarios;
    private String assunto = "";
    private String conteudo = "";
    private Date dataEnvio;
    private Time horaEnvio;
    
    public Mensagem() {}
    
    public Mensagem(String assunto, String conteudo) {
       	setAssunto(assunto);
    	setConteudo(conteudo);
    }
    
    public Mensagem(int codigo,String assunto, String conteudo, Date dataEnvio, Time horaEnvio) {
    	setCodigo(codigo);
    	setAssunto(assunto);
    	setConteudo(conteudo);
    	setDataEnvio(dataEnvio);
    	setHoraEnvio(horaEnvio);
    }

    public Mensagem(String assunto, String conteudo, Date dataEnvio, Time horaEnvio) {
    	setAssunto(assunto);
    	setConteudo(conteudo);
    	setDataEnvio(dataEnvio);
    	setHoraEnvio(horaEnvio);
    }
    
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Time getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Time horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public Pessoa getRemetente() {
        return this.remetente;
    }

    public void addRemetente(Pessoa remetente) {
        this.remetente = remetente;
    }

    public List <Matricula> getDestinatarios() {
        return this.destinatarios;
    }

    public void addDestinatarios(List <Matricula> destinatarios) {
        this.destinatarios = destinatarios;
    }
}
