package Classe.Main;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import Classe.BO.AdministradorBO;
import Classe.BO.AlunoBO;
import Classe.DAO.AdministradorDAO;
import Classe.DTO.*;

public class Main {	
    public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException {
    	Scanner input = new Scanner (System.in);	
  
    	boolean sistema = true; 	
        while (sistema) {            
	        System.out.println("##-- Sistema de notificacoes e avisos Escolar --##\n");
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
		            Administrador administrador = new Administrador(0,email,senha);    
		            if(administradorBO.existe(administrador))
		            	 ViewAdministrador.dashboard(administradorBO.visualizar(administrador)); 	   
		            break;
		        case 2: // FAZER Login do Professor
		        
		            break;
		        case 3: // FAZER Login Pais e Alunos
		        	 AlunoBO alunoBO = new AlunoBO();
		        	 
		        	 System.out.println("Email:");
			         email = input.next();
			         System.out.println("Senha:");
			         senha = input.next();
			       
			         Aluno aluno = new Aluno(new Matricula(0),email,senha);    
			         aluno.addEndereco(new Endereco());
			         aluno.addPais(new Pais(0,new Mae(),new Pai()));
			         
			         if(alunoBO.existe(aluno))
			        	 ViewPaisEaluno.dashboard(alunoBO.visualizarCompleto(aluno));
		            break;
		        case 4:
		        	System.out.println("Ate logo!");
		        	sistema = false;
		        default:
		            System.out.print("Opção Inválida!");
		            break;
	        }
        }   
    }
}
