package Classe.BO;

import java.util.List;
import Classe.DAO.MatriculaDAO;
import Classe.DTO.Endereco;
import Classe.DTO.Matricula;
import Classe.DTO.Pais;

public class MatriculaBO {
	public boolean existe(Matricula matricula) {
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		return matriculaDAO.verificar(matricula);
	}
	
	public String cadastrar(Matricula matricula) {
		if(existe(matricula)) return "Aluno já cadastrado!";
			
		EnderecoBO enderecoBO = new EnderecoBO();
		PaisBO paisBO = new PaisBO();
		
		enderecoBO.cadastrar(matricula.getAluno().getEndereco());
		paisBO.cadastrar(matricula.getAluno().getPais());
		
		Endereco endereco = enderecoBO.visualizar(matricula.getAluno().getEndereco());
		Pais pais = paisBO.visualizar(matricula.getAluno().getPais());

		matricula.getAluno().setEndereco(endereco);
		matricula.getAluno().setPais(pais);
		
		MatriculaDAO.cadastrar(matricula);
		
		return "Cadastro realizado com sucesso!";
    }
	
	public List <Matricula> listarComAluno () {
		return MatriculaDAO.listarComAluno();
	}

	public Matricula visualizarAlunoCompletoPorMatricula(Matricula matricula) {
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		return matriculaDAO.visulizarAlunoCompletoPorMatricula(matricula);
	}
	
	public List <Matricula> consultarAlunosPorMatricula(Matricula matricula){
		return MatriculaDAO.consultarAlunosPorMatricula(matricula);
	}
	
	
	
	
	
}
