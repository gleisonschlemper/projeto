package Classe.Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import Classe.BO.*;
import Classe.DTO.*;

public class ViewAdministrador {	
	static void dashboard(Administrador administrador) throws ParseException, SQLException { 
		Scanner input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- Bem vindo "+administrador.getNome()+" --## ");
			System.out.println("Opção 1 - Mandar Mensagem ");
			System.out.println("Opção 2 - Cadastrar aluno");
			System.out.println("Opção 3 - Alterar endereço do aluno");   	                               
	        System.out.println("Opção 4 - Alterar pais do aluno "); 
	        System.out.println("Opção 5 - Sair");
	        System.out.println("Digite uma opção:");
	        int opcao = input.nextInt();
	        
	        switch (opcao) {
	        case 1: // modificações relacionado aos alunos
	        	ativarFuncionalidade(opcao,administrador);
	            break;
	        case 2: // Modificações relacionado aos professores
	        	ativarFuncionalidade(opcao,administrador);
	            break;
	        case 3:
	        	ativarFuncionalidade(opcao,administrador);
	            break;
	        case 4:
	        	ativarFuncionalidade(opcao,administrador);
	        case 5:
	        	ativo = false;
	        }
		}
	}
	
	public static void ativarFuncionalidade(int opcao,Administrador administrador) throws ParseException, SQLException {
    	SimpleDateFormat dataFormatacao = new SimpleDateFormat("yyyy-MM-dd");
    	
		Scanner input = new Scanner (System.in);
		// Informações pessoal do Aluno
		String cpfAluno = "";
		String nomeAluno = "";
		String sobrenomeAluno = "";
		int idadeAluno = 0;
		
		// Informações de endereço do aluno 
		String ruaAluno = "";
		String cidadeAluno = "";
		int numeroCasaAluno = 0;
		String cepAluno = "";
		
		// Informações da mãe 
		String cpfMae;
		String nomeMae;
		String sobreNomeMae;
		int idadeMae;
		String telefoneMae;
		String dataMae;
		java.util.Date dataNascimentoMae;
		
		//  Informações do pai
		String cpfPai;
		String nomePai; 
		String sobreNomePai;
		int idadePai;
		String telefonePai;
		String dataPai;
		java.util.Date dataNascimentoPai;
		String telefoneAluno;
		
		String bairroAluno;
		
		String emailPais;
		String senhaPais;
		
    	AlunoBO alunoBO = new AlunoBO();
    	MensagemBO mensagemBO = new MensagemBO ();
    	
		Aluno aluno = null;
		Mae mae = null;
        Pai pai = null;
        Pais pais = null;
        Endereco endereco = null;
        
		switch (opcao) {
	        case 1:
	        	System.out.println("Assunto:");
	        	String assunto = input.nextLine();
	        	System.out.println("Conteudo:");
	        	String conteudo = input.nextLine();      	
	        	Mensagem mensagem = new Mensagem(assunto , conteudo);
	        	
	        	mensagem.addRemetente(administrador);
	         	mensagem.addDestinatarios(alunoBO.listar());
	         	System.out.println(mensagemBO.addMensagemRemetente(mensagem));
	            break;
	        case 2: // Cadastrar aluno novo no sistema
	        	System.out.println("------------------------------");
	        	System.out.println("     Informações do Aluno     ");
	        	System.out.println("------------------------------");
	        	System.out.println("Nome:");
	        	nomeAluno = input.next();
	        	System.out.println("Sobrenome:");
	        	sobrenomeAluno = input.next();
	        	System.out.println("CPF:");
	        	cpfAluno = input.next();
	        	System.out.println("Idade:");
	        	idadeAluno = input.nextInt();
	        	System.out.println("Telefone:");
	        	telefoneAluno = input.next();
	        	System.out.println("Data de nacimento:");
	        	System.out.println("Ano:");
	        	int ano = input.nextInt();
	        	System.out.println("Mes:");
	        	int mes = input.nextInt();
	        	System.out.println("Dia:");
	        	int dia = input.nextInt();
	        	String dataAluno = ano+"-"+mes+"-"+dia;
	            java.util.Date dataNascimento = dataFormatacao.parse(dataAluno);
	        	System.out.println("Email:");
	        	String email = input.next();
	        	System.out.println("Senha:");
	        	String senha = input.next();
	            java.util.Date dataMatricula = dataFormatacao.parse(dataAluno);
	        	
	            // Criação do aluno
	            aluno = new Aluno(
	            		cpfAluno, 
	            		nomeAluno, 
	            		sobrenomeAluno, 
	            		idadeAluno, 
	            		telefoneAluno,
	            		email, 
	            		senha, 
	            		new java.sql.Date(dataNascimento.getTime()),
	            		new Matricula(
	            			0,
	            			new java.sql.Date(dataNascimento.getTime())
	            		)
	            	); 
	            
	            System.out.println("------------------------------");
	            System.out.println("      Endereço do aluno       ");
	            System.out.println("------------------------------");
	            System.out.println("Rua: ");
	            String rua = input.next();
	            System.out.println("Bairro:");
	            bairroAluno  = input.next();
	            System.out.println("Cidade:");
	            String cidade = input.next();
	            System.out.println("Número da casa:");
	            int numerocasa = input.nextInt();
	            System.out.println("CEP:");
	            String cep = input.next();
	            endereco = new Endereco(rua,bairroAluno,cidade,numerocasa,cep);
	            aluno.addEndereco(endereco);
	            
	            System.out.println("------------------------------");
	            System.out.println("        Pais do aluno         ");
	            System.out.println("------------------------------");
	        	System.out.println("CPF da mãe:");
	        	cpfMae = input.next();
	        	System.out.println("Nome da mãe:");
	        	nomeMae = input.next();
	        	System.out.println("Sobrenome da mãe:");
	        	sobreNomeMae = input.next();
	        	System.out.println("Idade da mãe:");
	        	idadeMae = input.nextInt();
	        	System.out.println("Telefone da mãe:");
	        	telefoneMae = input.next();
	        	System.out.println("Data de nascimento da mãe:");
	        	dataMae = input.next();
	            dataNascimentoMae = dataFormatacao.parse(dataMae);
	            
	            System.out.println("----------------------------------------------------");
	            
	            System.out.println("CPF do pai:");
	            cpfPai = input.next();
	            System.out.println("Nome do pai:");
	            nomePai = input.next();
	            System.out.println("Sobrenome do pai:");
	            sobreNomePai = input.next();
	            System.out.println("Idade do pai:");
	            idadePai = input.nextInt();
	            System.out.println("Telefone do pai:");
	        	telefonePai = input.next();
	            System.out.println("Data de nascimento do pai:");
	            dataPai = input.next();
	            dataNascimentoPai = dataFormatacao.parse(dataPai);
	            
	            System.out.println("Email dos pais:");
	            emailPais = input.next();
	            System.out.println("Uma senha de acesso:");
	            senhaPais = input.next();
	            
	            mae = new Mae(cpfMae,nomeMae,sobreNomeMae,idadeMae,telefoneMae, new java.sql.Date(dataNascimentoMae.getTime()));
	            pai = new Pai(cpfPai,nomePai,sobreNomePai,idadePai,telefonePai, new java.sql.Date(dataNascimentoPai.getTime()));
	            pais = new Pais(0,emailPais,senhaPais,mae,pai);
	        	aluno.addPais(pais);
	        	System.out.println(alunoBO.cadastrar(aluno)); 
	        	
	            break;
	        case 3:  // Alteração do endereço do aluno 
	    		System.out.println("CPF do aluno: "); // CPF valido: 1234567896945
	    		cpfAluno = input.next();

	    		aluno = new Aluno(new Matricula(0),cpfAluno);
	    		
	        	System.out.println("Digite as novas informações");
	        	System.out.println("Rua:");
	        	ruaAluno = input.next();	
	        	System.out.println("Bairro:");
	        	bairroAluno = input.next();
	        	System.out.println("Cidade:");
	        	cidadeAluno = input.next();
	        	System.out.println("Número da casa:");
	        	numeroCasaAluno = input.nextInt();
	        	System.out.println("CEP:");
	        	cepAluno = input.next();
	        	aluno.addEndereco(new Endereco(ruaAluno, bairroAluno, cidadeAluno, numeroCasaAluno, cepAluno));
	        	aluno.addPais(new Pais(0,new Mae(),new Pai()));
	        	System.out.println(alunoBO.alterarEndereco(aluno));
	        	
	            break;
	        case 4:   // Alteração das informações dos pais
	        	System.out.println("CPF do aluno: "); // CPF valido: 1234567896945
	    		cpfAluno = input.next();

	    		aluno = new Aluno(new Matricula(0),cpfAluno);
	    		
	        	System.out.println("Digite as novas informações!");
	        	System.out.println("CPF da mãe:");
	        	cpfMae = input.next();
	        	System.out.println("Nome da mãe:");
	        	nomeMae = input.next();
	        	System.out.println("Sobrenome da mãe:");
	        	sobreNomeMae = input.next();
	        	System.out.println("Idade da mãe:");
	        	idadeMae = input.nextInt();
	        	System.out.println("Telefone da mãe:");
	        	telefoneMae = input.next();
	        	System.out.println("Data de nascimento da mãe:");
	        	dataMae = input.next();
	            dataNascimentoMae = dataFormatacao.parse(dataMae);
	            
	            System.out.println("----------------------------------------------------");
	            
	            System.out.println("CPF do pai:");
	            cpfPai = input.next();
	            System.out.println("Nome do pai:");
	            nomePai = input.next();
	            System.out.println("Sobrenome do pai:");
	            sobreNomePai = input.next();
	            System.out.println("Idade do pai:");
	            idadePai = input.nextInt();
	            System.out.println("Telefone do pai:");
	        	telefonePai = input.next();
	            System.out.println("Data de nascimento do pai:");
	            dataPai = input.next();
	            dataNascimentoPai = dataFormatacao.parse(dataPai);
	            
	            mae = new Mae(cpfMae,nomeMae,sobreNomeMae,idadeMae, telefoneMae ,new java.sql.Date(dataNascimentoMae.getTime()));
	            pai = new Pai(cpfPai,nomePai,sobreNomePai,idadePai, telefonePai ,new java.sql.Date(dataNascimentoPai.getTime()));
	            pais = new Pais(0,mae,pai);
	            
	        	aluno.addEndereco(new Endereco());
	        	aluno.addPais(pais);
	        	System.out.println(alunoBO.alterarPais(aluno));
	        	break;
	        default:
	            break;
		}	
	}
}