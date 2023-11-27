package Classe.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import Classe.BO.MatriculaBO;
import Classe.BO.MensagemBO;
import Classe.DAO.AdministradorDAO;
import Classe.DAO.MatriculaDAO;
import Classe.DAO.ProfessorDAO;
import Classe.DTO.*;
import HTML.GerarHTML;

public class ViewPaisEaluno {
	
	private static Scanner input;
	
	static void dashboard(Aluno aluno) throws ParseException, SQLException, IOException{ 
		input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- 	      Bem vindos(a)        --##");
			System.out.println("Opcão 1 - Informacao do aluno     	   ");
			System.out.println("Opção 2 - Informacao da Escola         ");
			System.out.println("Opção 3 - Mensagens da escola          ");
			System.out.println("Opção 4 - Mensagens dos professores    ");
	        System.out.println("Opção 5 - Sair");
	        System.out.println("Digite uma opção:");
	        int opcao = input.nextInt();
	        switch (opcao) {
		        case 1: // modificações relacionado aos alunos
		        	ativarFuncionalidade(opcao,aluno);
		            break;
		        case 2: // Modificações relacionado aos professores
		        	ativarFuncionalidade(opcao,aluno);
		            break;
		        case 3:
		        	ativarFuncionalidade(opcao,aluno);
		            break;
		        case 4:
		        	ativarFuncionalidade(opcao,aluno);
		        	break;
		        case 5:
		        	ativarFuncionalidade(opcao,aluno);
		        	break;
		        case 6:
		        	ativo = false;
		        	break;
	        }
		}
	}
	

	public static void ativarFuncionalidade(int opcao,Aluno aluno) throws ParseException, SQLException, IOException {
		input = new Scanner (System.in);
		MatriculaBO matriculaBO = new MatriculaBO();
		Matricula matricula = new Matricula(aluno);
      	Mensagem mensagem = new Mensagem();
    	MensagemBO mensagemBO = new MensagemBO();
    	
		// Pega todas as informações do aluno da matricula 
		matricula =  matriculaBO.visualizarAlunoCompletoPorMatricula(matricula); 
		
    	int index = 1; // Contador de mensagem
		List <Matricula> destinatario;
		switch (opcao) {
        case 1: // LSITA DE INFORMAÇÕES COMPLETO SOBRE O ALUNO
        	 System.out.println("------------------------------");
	         System.out.println("      Informações do aluno    ");
	         System.out.println("------------------------------");
	         System.out.println("Matricula: "+matricula.getCodigo());
	         System.out.println("Data da matricula: "+matricula.getDataMatricula());
	         System.out.println("Hora da matricula: "+matricula.getHoraMatricula());
	         System.out.println("Nome: "+matricula.getAluno().getNome());
	         System.out.println("SobreNome: "+matricula.getAluno().getSobrenome());
	         System.out.println("Idade: "+matricula.getAluno().getIdade());
	         System.out.println("Telefone: "+matricula.getAluno().getTelefone());
	         System.out.println("Data de nascimento: "+matricula.getAluno().getDataNascimento());
	         System.out.println("CPF: "+matricula.getAluno().getCpf());
	         System.out.println("E-mail: "+matricula.getAluno().getEmail());
	         System.out.println("------------------------------");
	         System.out.println("     Informações do endereco  ");
	         System.out.println("------------------------------");
	         System.out.println("Numero da casa: "+matricula.getAluno().getEndereco().getCasanumero());
	         System.out.println("Rua: "+matricula.getAluno().getEndereco().getRua());
	         System.out.println("Bairro: "+matricula.getAluno().getEndereco().getBairro());
	         System.out.println("Cidade: "+matricula.getAluno().getEndereco().getCidade());
	         System.out.println("CEP: "+matricula.getAluno().getEndereco().getCep());
	         System.out.println("------------------------------");
	         System.out.println("     Informações dos pais     ");
	         System.out.println("------------------------------");
	         System.out.println("Nome da mae: "+matricula.getAluno().getPais().getMae().getNome());
	         System.out.println("Sobrenome da mae: "+matricula.getAluno().getPais().getMae().getSobrenome());
	         System.out.println("Idade da mae: "+matricula.getAluno().getPais().getMae().getIdade());
	         System.out.println("Telefone da mae: "+matricula.getAluno().getPais().getMae().getTelefone());
	         System.out.println("Data de nacimento da mae: "+matricula.getAluno().getPais().getMae().getDataNascimento());
	         System.out.println("Cargo da mae: "+matricula.getAluno().getPais().getMae().getCargo());
	         System.out.println("------------------------------");
	         System.out.println("Nome do pai: "+matricula.getAluno().getPais().getPai().getNome());
	         System.out.println("Sobrenome do pai: "+matricula.getAluno().getPais().getPai().getSobrenome());
	         System.out.println("Idade do pai: "+matricula.getAluno().getPais().getPai().getIdade());
	         System.out.println("Telefone do pai: "+matricula.getAluno().getPais().getPai().getTelefone());
	         System.out.println("Data de nacimento do pai: "+matricula.getAluno().getPais().getPai().getDataNascimento());
	         System.out.println("Cargo do pai: "+matricula.getAluno().getPais().getPai().getCargo());
	         System.out.println("-------------------------------");
	         System.out.println("Email dos pais: "+matricula.getAluno().getPais().getEmail());     
            break;
        case 2: 
       	 	 System.out.println("------------------------------");
	         System.out.println("      Informações da escola   ");
	         System.out.println("------------------------------");
	         System.out.println("Nome: "+matricula.getAluno().getEscola().getNome());
	         System.out.println("Rua: "+matricula.getAluno().getEscola().getRua());
	         System.out.println("Bairro: "+matricula.getAluno().getEscola().getCidade());
	         System.out.println("Telefone: "+matricula.getAluno().getEscola().getTelefone());
	         System.out.println("E-mail: "+matricula.getAluno().getEscola().getEmail());
            break;
        case 3: // MENSAGENS DA ESCOLA
        	destinatario = MatriculaDAO.consultarAlunosPorMatricula(matricula); // Cria uma lista de matriculas com o mesmo código 
        	mensagem.addDestinatarios(destinatario); // seta os destinatario da mensagem 
        	mensagem.addRemetente(new Administrador());  // Seta um refentente
        	System.out.println("Avisos da escola"); // Titulo inical 
        	GerarHTML. bodyMensagemAdministrador(mensagemBO.consultarMensagensPorDestinatario(mensagem));
        	
        	for(Mensagem mensagemAdministrador : mensagemBO.consultarMensagensPorDestinatario(mensagem)) {
        		if((int) mensagemAdministrador.getRemetente().getCodigo() == 1) { // Seleciona somente as mensagem enviado pelo administrador
            		Administrador Administrador = AdministradorDAO.visualizar( // Crio um objeto Administrador visualizando suas informações
            				new Administrador(mensagemAdministrador.getRemetente().getCodigo()) // O objeto somente com o código do remetente da mensagem
            			);
            		System.out.println("Mensagem "+index); // Número da mensagem
            		System.out.println("Assunto: "+mensagemAdministrador.getAssunto()); // Assunto
            		System.out.println("Conteudo: "+mensagemAdministrador.getConteudo());// Conteúdo
            		System.out.println("Horario: "+mensagemAdministrador.getHoraEnvio());// Horário de envio 
            		System.out.println("Data: "+mensagemAdministrador.getDataEnvio());// Data do envio
            		System.out.println("Comunicado por: "+Administrador.getNome()+" "+Administrador.getSobrenome()); // Remente da escola
            		System.out.println("-------------------------------------------");
            		index++; // acrescentar mais um no contador
            	}
        	}
        	index = 0;
            break;
        case 4:
        	destinatario = matriculaBO.consultarAlunosPorMatricula(matricula); // Cria uma lista de matriculas com o mesmo código 
        	mensagem.addDestinatarios(destinatario); // seta os destinatario da mensagem 
        	mensagem.addRemetente(new Professor());  // Seta um refentente
        	System.out.println("Comunicados dos professores"); // Titulo inical 
        	GerarHTML.bodyMensagemProfessor(mensagemBO.consultarMensagensPorDestinatario(mensagem));
        	
        	for(Mensagem mensagemProfessor : mensagemBO.consultarMensagensPorDestinatario(mensagem)) { // Lista professores que enviaram mensagem ao aluno
            	if((int) mensagemProfessor.getRemetente().getCodigo() > 1) { // Seleciona somente as mensagem enviado pelo Professor
            		 Professor professor = ProfessorDAO.visualizar( // Crio um objeto Professor visualizando suas informações
            				new Professor(mensagemProfessor.getRemetente().getCodigo()) // O objeto somente com o código do remetente da mensagem
            			);
            		 
            	
            		 
            		System.out.println("Mensagem "+index); // Número da mensagem
            		System.out.println("Assunto: "+mensagemProfessor.getAssunto()); // Assunto
            		System.out.println("Conteudo: "+mensagemProfessor.getConteudo());// Conteúdo
            		System.out.println("Horario: "+mensagemProfessor.getHoraEnvio());// Horário de envio 
            		System.out.println("Data: "+mensagemProfessor.getDataEnvio());// Data do envio
            		System.out.println("Comunicado por: "+professor.getNome()+" "+professor.getSobrenome()); // Remente da escola
            		System.out.println("-------------------------------------------");
            		index++; // acrescentar mais um no contador
            	}
        	}
        	index = 0;
        	break;
    }
		
		
	}
	
	
	
}
