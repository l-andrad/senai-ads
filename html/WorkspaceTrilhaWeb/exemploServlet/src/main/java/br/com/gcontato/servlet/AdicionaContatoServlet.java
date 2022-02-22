package br.com.gcontato.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public AdicionaContatoServlet() {
		super();
	}
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
		throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("end");
		String telefone = request.getParameter("tel");
		out.println("<html><body><h2>Nome: " + nome + "</h2>"
					+ "<h3>Endereço: " + endereco + "</h3>" 
					+ "<h3>Telefone: " + telefone + "</h3></body></html>");
		out.println("Visualizando alterações no repositório");
		
	}
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
		throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	}
}
