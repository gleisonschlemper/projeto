package Classe.Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classe.BO.MensagemBO;
import Classe.DAO.MatriculaDAO;
import Classe.DTO.Aluno;
import Classe.DTO.Matricula;
import Classe.DTO.Mensagem;
import Classe.DTO.Professor;

public class ViewProfessor {
	private static Scanner input;
	
	static void dashboard(Professor professor) throws ParseException, SQLException { 
		input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- 	      Bem vindos(a)        --##");
			System.out.println("Opcão 1 - Mandar mensagem              ");
			System.out.println("Opcão 2 - Consultar aluno              ");
	        System.out.println("Opção 3 - Sair");
	        System.out.println("Digite uma opção:");
	        int opcao = input.nextInt();
			
	        switch (opcao) {
		        case 1: // modificações relacionado aos alunos
		        	ativarFuncionalidade(opcao,professor);
		            break;
		        case 2: // Modificações relacionado aos professores
		        	ativarFuncionalidade(opcao,professor);
		            break;
		        case 3:
		        	ativo = false;
		        }  
			}
	}

	private static void ativarFuncionalidade(int opcao, Professor professor) throws SQLException {
		input = new Scanner (System.in);	
	
		MatriculaDAO matriculaBO = new MatriculaDAO();
		MensagemBO mensagemBO = new MensagemBO();
		List <Matricula> destinatario = new ArrayList <Matricula>();
		Matricula matricula;
		
		int codigo;
		switch (opcao) {
	        case 1: // Enviar Mensagem somente um aluno
	        	System.out.println("Matricula do aluno:");
	        	codigo = input.nextInt();
        		matricula = new Matricula(codigo,new Aluno());
	        	if(matriculaBO.verificar(matricula)) {
	        		input.nextLine();
	        		System.out.print("Assunto:");
	        		String assunto = input.nextLine();
	        		System.out.println("----------------------------");
	        		System.out.print("Conteudo:");
	        		String conteudo = input.nextLine();
		        	destinatario.add(matriculaBO.visulizarAlunoCompletoPorMatricula(matricula)); // visualiza o aluno completo pela matricula e adicona na lista de matriculas
		        	Mensagem mensagem = new Mensagem(assunto, conteudo);
		        	mensagem.addRemetente(professor);
		         	mensagem.addDestinatarios(destinatario);
		         	System.out.println(mensagemBO.addMensagemDestinatario(mensagem));
	        	}
	        	else {
	        		System.out.println("Matricula inválido!");
	        	}        	
	            break;
	        case 2: // 
	        	System.out.println("Matricula do aluno:");
	        	codigo = input.nextInt();
        		matricula = new Matricula(codigo,new Aluno());
	        	if(matriculaBO.verificar(matricula)) {
	        		matricula = matriculaBO.visulizarAlunoCompletoPorMatricula(matricula); // visualiza o aluno completo pela matricula 
	        		System.out.println("Informação do aluno!");
	        		System.out.println("Nome: "+matricula.getAluno().getNome());
	        		System.out.println("Sobrenome: "+matricula.getAluno().getSobrenome());
	        		System.out.println("Idade: "+matricula.getAluno().getIdade());
	        		System.out.println("Telefone: "+matricula.getAluno().getTelefone());
	        		System.out.println("Data de nascimento: "+matricula.getAluno().getDataNascimento());
	        		System.out.println("E-mail: "+matricula.getAluno().getEmail());
	        	}
	        	else {
	        		System.out.println("Matricula inválido!");
	        	} 
	         break;
        }  
	}
}
