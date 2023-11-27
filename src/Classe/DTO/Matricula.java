package Classe.DTO;

import java.sql.Date;
import java.sql.Time;

public class Matricula {
    private int codigo = 0;
    private Date dataMatricula;
    private Time horaMatricula;
    private Aluno aluno;
    
    public Matricula() {}
    
    public Matricula(Aluno aluno) {
    	setAluno(aluno);
    }
    
    public Matricula(int codigo, Aluno aluno) {
    	setCodigo(codigo);
    	setAluno(aluno);
    }
    
    public Matricula(Date dataMatricula,Time horaMatricula, Aluno aluno) {
		setDataMatricula(dataMatricula);
		setHoraMatricula(horaMatricula);
		setAluno(aluno);
	}
    
    public Matricula(int codigo) {
    	setCodigo(codigo);
    }

    public Matricula(int codigo, Date dataMatricula,Time horaMatricula) {
    	setCodigo(codigo);
    	setDataMatricula(dataMatricula);
	}

	public Time getHoraMatricula() {
		return horaMatricula;
	}

	public void setHoraMatricula(Time horaMatricula) {
		this.horaMatricula = horaMatricula;
	}

	public Date getDataMatricula() {
        return dataMatricula;
    }

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
		
    public Aluno getAluno() {
		return aluno;
	}

	public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
	public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int matricula) {
        this.codigo = matricula;
    }
}
