package Classe.Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classe.BO.AlunoBO;
import Classe.BO.MensagemBO;
import Classe.DTO.*;

public class ViewPaisEaluno {
	
	static void dashboard(Aluno aluno) throws ParseException, SQLException { 
		Scanner input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- 	      Bem vindos(a)        --##");
			System.out.println("Opcão 1 - ver informação de perfil     ");
			System.out.println("Opção 2 - Ver informações da Escola    ");
			System.out.println("Opção 5 - Ver mensagem enviado         ");
	        System.out.println("Opção 6 - Sair");
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
	

	public static void ativarFuncionalidade(int opcao,Aluno aluno) throws ParseException, SQLException {
		Scanner input = new Scanner (System.in);
		switch (opcao) {
        case 1: 	
        	 System.out.println("------------------------------");
	         System.out.println("      Informações do aluno    ");
	         System.out.println("------------------------------");
	         System.out.println("Matricula: "+aluno.getMatricula().getMatricula());
	         System.out.println("Data da matricula: "+aluno.getMatricula().getDataMatricula());
	         System.out.println("Nome: "+aluno.getNome());
	         System.out.println("SobreNome: "+aluno.getSobrenome());
	         System.out.println("Idade: "+aluno.getIdade());
	         System.out.println("Telefone: "+aluno.getTelefone());
	         System.out.println("Data de nascimento: "+aluno.getDataNascimento());
	         System.out.println("CPF: "+aluno.getCpf());
	         System.out.println("E-mail: "+aluno.getEmail());
	         System.out.println("------------------------------");
	         System.out.println("     Informações do endereco  ");
	         System.out.println("------------------------------");
	         System.out.println("Numero da casa: "+aluno.getEndereco().getCasanumero());
	         System.out.println("Rua: "+aluno.getEndereco().getRua());
	         System.out.println("Bairro: "+aluno.getEndereco().getBairro());
	         System.out.println("Cidade: "+aluno.getEndereco().getCidade());
	         System.out.println("CEP: "+aluno.getEndereco().getCep());
	         System.out.println("------------------------------");
	         System.out.println("     Informações dos pais     ");
	         System.out.println("------------------------------");
	         System.out.println("Nome da mae: "+aluno.getPais().getMae().getNome());
	         System.out.println("Sobrenome da mae: "+aluno.getPais().getMae().getSobrenome());
	         System.out.println("Idade da mae: "+aluno.getPais().getMae().getIdade());
	         System.out.println("Telefone da mae: "+aluno.getPais().getMae().getTelefone());
	         System.out.println("Data de nacimento da mae: "+aluno.getPais().getMae().getDataNascimento());
	         System.out.println("Nome do pai: "+aluno.getPais().getPai().getNome());
	         System.out.println("Sobrenome do pai: "+aluno.getPais().getPai().getSobrenome());
	         System.out.println("Idade do pai: "+aluno.getPais().getPai().getIdade());
	         System.out.println("Telefone do pai: "+aluno.getPais().getPai().getTelefone());
	         System.out.println("Data de nacimento do pai: "+aluno.getPais().getPai().getDataNascimento());
	         System.out.println("Email dos pais: "+aluno.getPais().getEmail());
            break;
        case 2: 
        	
        	AlunoBO alunoBO = new AlunoBO();
        	
        	List <Mensagem> mensagens = alunoBO.visualizarMensagens(aluno);
        	System.out.println(mensagens);
        	
            break;
        case 3:
        	
            break;
        case 4:
        	
        	break;
        case 5:
        	
        	break;
    }
		
		
	}
	
	
	
}
