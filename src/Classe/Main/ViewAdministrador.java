package Classe.Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Classe.BO.*;
import Classe.DTO.*;

public class ViewAdministrador {	
	private static Scanner input;
	
	static void dashboard(Administrador administrador) throws ParseException, SQLException { 		
		input = new Scanner (System.in);
		boolean ativo = true;
		while(ativo) {
			System.out.println("");
			System.out.println("##-- Bem vindo "+administrador.getNome()+" --## ");
			System.out.println("Opção 1 - Mandar Mensagem ");
			System.out.println("Opção 2 - Cadastrar aluno");
			System.out.println("Opção 3 - Alterar endereço do aluno");   	                               
	        System.out.println("Opção 4 - Alterar pais do aluno "); 
	        System.out.println("Opção 5 - Cadastrar professor");
	        System.out.println("Opção 6 - Sair");
	        System.out.println("Digite uma opção:");
	        int opcao = input.nextInt();
	        
	        switch (opcao) {
	        case 1: // modificações relacionado aos alunos
	        	ativarFuncionalidade(opcao,administrador,input);
	            break;
	        case 2: // Modificações relacionado aos professores
	        	ativarFuncionalidade(opcao,administrador,input);
	            break;
	        case 3:
	        	ativarFuncionalidade(opcao,administrador,input);
	            break;
	        case 4:
	        	ativarFuncionalidade(opcao,administrador,input);
	        case 5:
	        	ativarFuncionalidade(opcao,administrador,input);
	        	break;
	        case 6:
	        	ativo = false;
	        	break;
	        }
		}
	}
	
	public static void ativarFuncionalidade(int opcao,Administrador administrador, Scanner input) throws ParseException, SQLException {
	
  	
    	MatriculaBO matriculaBO = new MatriculaBO();
    	MensagemBO mensagemBO = new MensagemBO();
    	AlunoBO alunoBO = new AlunoBO();
    	EscolaBO escolaBO = new EscolaBO();
    	SimpleDateFormat dataFormatacao = new SimpleDateFormat("yyyy-MM-dd");
    	Date data = new Date();
    	
		Aluno aluno = null;
		Mae mae = null;
        Pai pai = null;
        Pais pais = null;
        Endereco endereco = null;
        
        // VARIAVEIS UTILIZADAS
		// Informações pessoal do Aluno
		String cpfAluno = "";
		String nomeAluno = "";
		String sobrenomeAluno = "";
		int idadeAluno = 0;
		String telefoneAluno = "";
		String bairroAluno = "";

		Date dataNascimento;
		// Informações de endereço do aluno 
		String ruaAluno = "";
		String cidadeAluno = "";
		int numeroCasaAluno = 0;
		String cepAluno = "";	
		// Informações da mãe 
		String cpfMae = "";
		String nomeMae = "";
		String sobreNomeMae = "";
		int idadeMae = 0;
		String telefoneMae = "";
		String cargoMae = "";
		String dataMae = "";
		int anoMae = 0;
		int mesMae = 0;
		int diaMae = 0;
		Date dataNascimentoMae;	
		//  Informações do pai
		String cpfPai = "";
		String nomePai = ""; 
		String sobreNomePai = "";
		int idadePai = 0;
		String telefonePai = "";
		String cargoPai = "";
		String dataPai = "";
		int anoPai = 0;
		int mesPai = 0;
		int diaPai = 0;
		Date dataNascimentoPai;
		// Informações dos pais em cojunto
		String emailPais;
		String senhaPais;
    	
        
		switch (opcao) {
	        case 1:
	        	input.nextLine();
        		System.out.print("Assunto:");
        		String assunto = input.nextLine();
        		System.out.println("----------------------------");
        		System.out.print("Conteudo:");
        		String conteudo = input.nextLine();	
	        	Mensagem mensagem = new Mensagem(assunto , conteudo);
	        	
	        	mensagem.addRemetente(administrador);
	         	mensagem.addDestinatarios(matriculaBO.listarComAluno());
	         	System.out.println(mensagemBO.addMensagemDestinatario(mensagem));
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
	            dataNascimento = dataFormatacao.parse(dataAluno);
	        	System.out.println("Email:");
	        	String email = input.next();
	        	System.out.println("Senha:");
	        	String senha = input.next();
	            
	            System.out.println("------------------------------");
	            System.out.println("      Endereço do aluno       ");
	            System.out.println("------------------------------");
	            
	            System.out.println("Rua: ");
	            ruaAluno = input.next();      
	            System.out.println("Bairro:");
	            bairroAluno  = input.next();
	            System.out.println("CEP:");
	            cepAluno = input.next(); 
	            System.out.println("Cidade:");
	            cidadeAluno = input.next();
	            
	            endereco = new Endereco(
	            		ruaAluno,
	            		bairroAluno,
	            		cidadeAluno,
	            		numeroCasaAluno,
	            		cepAluno
	            	);
	            
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
	        	System.out.println("Cargo da mae: ");
	        	cargoMae = input.next();
	        	System.out.println("Data de nascimento da mãe:");
	        	System.out.println("Ano: ");
	        	anoMae = input.nextInt();
	        	System.out.println("Mes: ");
	        	mesMae = input.nextInt();
	        	System.out.println("Dia: ");
	        	diaMae = input.nextInt();
	        	dataMae = anoMae+"-"+mesMae+"-"+diaMae;
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
	        	System.out.println("Cargo do pai:");
	        	cargoPai = input.next();
	            System.out.println("Data de nascimento do pai:");
	            System.out.println("Ano: ");
	        	anoPai = input.nextInt();
	        	System.out.println("Mes: ");
	        	mesPai = input.nextInt();
	        	System.out.println("Dia: ");    
	        	diaPai = input.nextInt();
	            dataPai = anoPai+"-"+mesPai+"-"+diaPai;
	            dataNascimentoPai = dataFormatacao.parse(dataPai);
	        	
	            System.out.println("Email dos pais:");
	            emailPais = input.next();
	            System.out.println("senha: ");
	            senhaPais = input.next();
	            
	            mae = new Mae(cpfMae,nomeMae,sobreNomeMae,idadeMae,telefoneMae,new java.sql.Date(dataNascimentoMae.getTime()),cargoMae);
	            pai = new Pai(cpfPai,nomePai,sobreNomePai,idadePai,telefonePai,new java.sql.Date(dataNascimentoPai.getTime()),cargoPai);
	            pais = new Pais(emailPais,senhaPais,mae,pai);

	            Escola escola = escolaBO.visualizar(new Escola());
	            
	            aluno = new Aluno(
	            		cpfAluno,
	            		nomeAluno,
	            		sobrenomeAluno, 
	            		idadeAluno,
	            		email,
	            		senha,
	            		telefoneAluno,
	            		new java.sql.Date(dataNascimento.getTime()),
	            		pais,
	            		endereco,
	            		escola
	            	); 
	            
	        	Matricula matricula = new Matricula(new java.sql.Date(data.getTime()),new java.sql.Time(data.getTime()),  aluno);
	        	System.out.println(matriculaBO.cadastrar(matricula));
	            break;
	        case 3:  
	        	System.out.println("CPF do aluno: "); 
	    		cpfAluno = input.next();

	    		aluno = new Aluno(cpfAluno);
	    		
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
	        	aluno.setEndereco(new Endereco(ruaAluno, bairroAluno, cidadeAluno, numeroCasaAluno, cepAluno));
	        	aluno.setPais(new Pais(new Mae(), new Pai()));
	        	System.out.println(alunoBO.alterarEndereco(aluno));
	            break;
	        case 4:   
	        	
	        	System.out.println("CPF do aluno: "); 
	    		cpfAluno = input.next();

	    		aluno = new Aluno(cpfAluno);
	    		
	        	System.out.println("------------------------------");
	            System.out.println("        Pais do aluno         ");
	            System.out.println("------------------------------");
	        	System.out.println("Nome da mãe:");
	        	nomeMae = input.next();
	        	System.out.println("Sobrenome da mãe:");
	        	sobreNomeMae = input.next();
	        	System.out.println("CPF do pai:");
	            cpfMae = input.next(); 
	        	System.out.println("Idade da mãe:");
	        	idadeMae = input.nextInt();
	        	System.out.println("Telefone da mãe:");
	        	telefoneMae = input.next();
	        	System.out.println("Cargo da mae: ");
	        	cargoMae = input.next();
	        	System.out.println("Data de nascimento da mãe:");
	        	System.out.println("Ano: ");
	        	anoMae = input.nextInt();
	        	System.out.println("Mes: ");
	        	mesMae = input.nextInt();
	        	System.out.println("Dia: ");
	        	diaMae = input.nextInt();
	        	dataMae = anoMae+"-"+mesMae+"-"+diaMae;
	            dataNascimentoMae = dataFormatacao.parse(dataMae);
	        	
	            System.out.println("----------------------------------------------------");
	             
	            System.out.println("Nome do pai:");
	            nomePai = input.next();         
	            System.out.println("Sobrenome do pai:");
	            sobreNomePai = input.next();
	            System.out.println("CPF do pai:");
	            cpfPai = input.next(); 
	            System.out.println("Idade do pai:");
	            idadePai = input.nextInt();
	            System.out.println("Telefone do pai:");
	        	telefonePai = input.next();
	        	System.out.println("Cargo do pai:");
	        	cargoPai = input.next();
	            System.out.println("Data de nascimento do pai:");
	            System.out.println("Ano: ");
	        	anoPai = input.nextInt();
	        	System.out.println("Mes: ");
	        	mesPai = input.nextInt();
	        	System.out.println("Dia: ");    
	        	diaPai = input.nextInt();
	            dataPai = anoPai+"-"+mesPai+"-"+diaPai;
	            dataNascimentoPai = dataFormatacao.parse(dataPai); 
	            
	            mae = new Mae(cpfMae,nomeMae,sobreNomeMae,idadeMae,telefoneMae,new java.sql.Date(dataNascimentoMae.getTime()),cargoMae);
	            pai = new Pai(cpfPai,nomePai,sobreNomePai,idadePai,telefonePai,new java.sql.Date(dataNascimentoPai.getTime()),cargoPai);
	            pais = new Pais(mae,pai);
	        	aluno.setPais(pais);
	        	aluno.setEndereco(new Endereco());
	        	System.out.println(alunoBO.alterarPais(aluno));   
	        	break;
	        default:
	            break;
		}	
	}
	
}