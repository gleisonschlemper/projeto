package Classe.Main;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import Classe.BO.*;
import Classe.DTO.*;

public class Main {	
    private static Scanner input;


	public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException, InterruptedException, IOException {
		//GerarHTML.bodyMatriculados(MatriculaDAO.listarComAluno());
		
		input = new Scanner (System.in);	  
    	boolean sistema = true; 	
        while (sistema) {   
	        System.out.println("##--  Sistema de notificacoes e avisos Escolar --##\n");
	        System.out.println("Faca seu Login!                                   \n");
	        System.out.println("Opção 1 - Administrador	                            ");
	        System.out.println("Opção 2 - Professor	                                ");
	        System.out.println("Opção 3 - Pais e alunos                           	");
	        System.out.println("Opção 4 - Sair                                    \n");
	        System.out.println("Digite uma opcao: ");
	        int opcao = input.nextInt();
	        
	        String email = "";
	        String senha = "";
	        switch (opcao) {
		        case 1: // Login do administrador
		        	AdministradorBO administradorBO = new AdministradorBO();
		        	
		            System.out.println("Email:");
		            email = input.next();
		            System.out.println("Senha:");
		            senha = input.next();
		            
		            Administrador administrador = new Administrador(email,senha);  
		            
		            if(administradorBO.existe(administrador))
		            	ViewAdministrador.dashboard(administradorBO.visualizar(administrador));
		            else
		            	System.out.println("E-mail ou senha inválido");
		            break;
		        case 2: // FAZER Login do Professor
		        	ProfessorBO professorBO = new ProfessorBO();
		        	
		        	 System.out.println("Email: ");
		        	 email = input.next();
		        	 System.out.println("Senha: ");
		        	 senha = input.next();
		        	 Professor professor = new Professor(email,senha);
		        	 
		        	 if(professorBO.existe(professor)) 
			        		ViewProfessor.dashboard(professorBO.visualizar(professor));
			        	else 
			        		System.out.println("E-mail ou senha inválido");
		            break;
		        case 3: // FAZER Login Pais e Alunos
		        	AlunoBO alunoBO = new AlunoBO();
		        	
		        	System.out.println("Email: ");
		            email = input.next();
		            System.out.println("Senha: ");
		            senha = input.next();
		        	
		            Aluno aluno = new Aluno(email,senha);
			    	aluno.setPais(new Pais(new Mae(), new Pai()));
			    	aluno.setEndereco(new Endereco());
			    	
		        	if(alunoBO.existe(aluno)) 
		        		ViewPaisEaluno.dashboard(alunoBO.visualizar(aluno));
		        	else 
		        		System.out.println("E-mail ou senha inválido");
		            break;
		        case 4:
		        	sistema = false;
		        	break;
		        default:
		        	System.out.print("Opção Inválida!");
		            break;
	        }
        }   
        
    	System.out.println("Ate logo!");
    }
}
