package Classe.Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import Classe.DTO.Professor;

public class ViewProfessor {
	static void dashboard(Professor professor) throws ParseException, SQLException { 
		Scanner input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- 	      Bem vindos(a)        --##");
			System.out.println("Opcão 1 - Mandar mensagem              ");
			System.out.println("Opcão 1 - ver mensagem enviado         ");
			System.out.println("Opcão 2 - Consultar aluno              ");
	        System.out.println("Opção 6 - Sair");
	        System.out.println("Digite uma opção:");
	        
	        int opcao = input.nextInt();
			System.out.println(professor);
		}
	}
}
