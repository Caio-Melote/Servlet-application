package br.com.treinamento.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		boolean usuarioDeslogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

		if (acaoProtegida && usuarioDeslogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		filterChain.doFilter(request, response);
	}

}
