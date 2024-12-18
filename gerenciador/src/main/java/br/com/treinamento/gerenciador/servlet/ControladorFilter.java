package br.com.treinamento.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import br.com.treinamento.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.treinamento.gerenciador.acao." + paramAcao;

		String retorno;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			retorno = acao.executa(request, response);
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
	}

}
