package br.com.treinamento.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.treinamento.gerenciador.acao.Acao;

//@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.treinamento.gerenciador.acao."+paramAcao;
		
		String retorno;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			retorno = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}	
		
		String[] tipoEendereco = retorno.split(":");

		if (tipoEendereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEendereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEendereco[1]);
		}
		
		
		
//		String retorno = null;
//		if (paramAcao.equals("ListaEmpresas")) {
//
//			ListaEmpresas listaEmpresa = new ListaEmpresas();
//			retorno = listaEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			retorno = removeEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			retorno = mostraEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			retorno = alteraEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("NovaEmpresa")) {
//
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			retorno = novaEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("FormEmpresa")) {
//
//			FormEmpresa formEmpresa = new FormEmpresa();
//			retorno = formEmpresa.executa(request, response);
//
//		}

		
		

	}

}
