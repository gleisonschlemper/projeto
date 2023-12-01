package HTML;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Classe.DAO.*;
import Classe.DTO.*;

public class GerarHTML {
	
	public static void bodyMatriculados(List<Matricula> matriculas) throws IOException {
	    FileWriter arq = new FileWriter("index.html");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    
	    gravarArq.printf("%s\n", cabecalho());
	    StringBuilder html = new StringBuilder();
		gravarArq.printf("%s\n", html);
	    html.append("<tr>");
	    html.append("<td>");
		html.append("Matricula");
		html.append("</td>");
	    html.append("<td>");
		html.append("Nome");
		html.append("</td>");
		html.append("<td>");
		html.append("Sobrenome");
		html.append("</td>");
		html.append("<td>");
		html.append("Idade");
		html.append("</td>");
		html.append("<td>");
		html.append("Telefone");
		html.append("</td>");
		html.append("<td>");
		html.append("Data de nascimento");
		html.append("</td>");
		html.append("<td>");
		html.append("E-mail");
		html.append("</td>");
		html.append("</tr>\n");
		for (Matricula matricula : matriculas) {
		    gravarArq.println("<tr>");
		    gravarArq.printf("<td>"+matricula.getCodigo()+"</td>\n");
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getNome());
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getSobrenome());
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getIdade());
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getTelefone());
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getDataNascimento());
		    gravarArq.printf("<td>%s</td>\n", matricula.getAluno().getEmail());
		    gravarArq.println("</tr>");
		}
	   
	    gravarArq.printf("%s\n", rodape());

	    // Fechar os recursos após a conclusão
	    gravarArq.close();
	    arq.close();
	}
	
	
	public static void bodyMensagemAdministrador(List <Mensagem> mensagens) throws IOException {
	    FileWriter arq = new FileWriter("mensagens.html");
	    PrintWriter gravarArq = new PrintWriter(arq);

	    gravarArq.printf("%s\n", cabecalho());

	    StringBuilder html = new StringBuilder();
	    gravarArq.printf("%s\n", html);

	    gravarArq.println("<caption> MENSAGEM DA ESCOLA </caption>");
	    gravarArq.println("<tr>");
	    gravarArq.printf("<td>Assunto</td>");
	    gravarArq.printf("<td>Conteúdo</td>");
	    gravarArq.printf("<td>Hora</td>");
	    gravarArq.printf("<td>Data</td>");
	    gravarArq.printf("<td>Comunicado por</td>");
	    gravarArq.println("</tr>\n");

	    for (Mensagem mensagemAdministrador : mensagens) {
	    	if((int) mensagemAdministrador.getRemetente().getCodigo() == 1) { // Seleciona somente as mensagem enviado pelo Professor

			    Administrador administrador = AdministradorDAO.visualizar( // Crio um objeto Professor visualizando suas informações
						new Administrador(mensagemAdministrador.getRemetente().getCodigo()) // O objeto somente com o código do remetente da mensagem
					);
	            gravarArq.println("<tr>");	    
		        gravarArq.printf("<td>%s</td>\n", mensagemAdministrador.getAssunto());
		        gravarArq.printf("<td>%s</td>\n", mensagemAdministrador.getConteudo());
		        gravarArq.printf("<td>%s</td>\n", mensagemAdministrador.getHoraEnvio());
		        gravarArq.printf("<td>%s</td>\n", mensagemAdministrador.getDataEnvio());
		        gravarArq.printf("<td>%s</td>\n", administrador.getNome() + " " + administrador.getSobrenome());
		        gravarArq.println("</tr>");    		
	    	}
	    }

	    gravarArq.printf("%s\n", rodape());

	    // Fechar os recursos após a conclusão
	    gravarArq.close();
	    arq.close();
	}
	
	public static void bodyMensagemProfessor(List <Mensagem> mensagens) throws IOException {
		 	FileWriter arq = new FileWriter("mensagens.html");
		    PrintWriter gravarArq = new PrintWriter(arq);

		    gravarArq.printf("%s\n", cabecalho());

		    StringBuilder html = new StringBuilder();
		    gravarArq.printf("%s\n", html);

		    gravarArq.println("<caption> MENSAGEM DOS PROFESSORES </caption>");
		    gravarArq.println("<tr>");
		    gravarArq.printf("<td>Assunto</td>");
		    gravarArq.printf("<td>Conteúdo</td>");
		    gravarArq.printf("<td>Hora</td>");
		    gravarArq.printf("<td>Data</td>");
		    gravarArq.printf("<td>Comunicado por</td>");
		    gravarArq.println("</tr>\n");

		    for (Mensagem mensagem : mensagens) {
		    	if((int) mensagem.getRemetente().getCodigo() > 1) { // Seleciona somente as mensagem enviado pelo Professor

		    		Professor professor = ProfessorDAO.visualizar( // Crio um objeto Professor visualizando suas informações
							new Professor(mensagem.getRemetente().getCodigo()) // O objeto somente com o código do remetente da mensagem
						);
				    
		            gravarArq.println("<tr>");	    
			        gravarArq.printf("<td>%s</td>\n", mensagem.getAssunto());
			        gravarArq.printf("<td>%s</td>\n", mensagem.getConteudo());
			        gravarArq.printf("<td>%s</td>\n", mensagem.getHoraEnvio());
			        gravarArq.printf("<td>%s</td>\n", mensagem.getDataEnvio());
			        gravarArq.printf("<td>%s</td>\n", professor.getNome() + " " + professor.getSobrenome());
			        gravarArq.println("</tr>");    		
		    	}
		    }

		    gravarArq.printf("%s\n", rodape());

		    // Fechar os recursos após a conclusão
		    gravarArq.close();
		    arq.close();
	}

	
    // Modifique a função cabeçalho para receber a ArrayList como parâmetro
    public static String cabecalho() {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head><link rel=\"stylesheet\" href=\"./src/HTML/Style.css\"> <title>Listas</title></head>\n");
        html.append("<meta charset=\"UTF-8\">\n");
        html.append("<body>\n");
        html.append("<table border=\"1\">\n");


        return html.toString();
    }

    public static String rodape() {
        StringBuilder html = new StringBuilder();
        html.append("</table>\n");
        html.append("</body>\n");
        html.append("</html>\n");
        return html.toString();
    }

}
