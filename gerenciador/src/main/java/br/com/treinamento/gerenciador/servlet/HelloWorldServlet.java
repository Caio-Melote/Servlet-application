package br.com.treinamento.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter saida = resp.getWriter();
		saida.println("<html> <body> Hello World servlet </body> </html>");
		
		//System.out.println("Servlet 'HelloWorldServlet' foi chamado!");
	}
	
}
