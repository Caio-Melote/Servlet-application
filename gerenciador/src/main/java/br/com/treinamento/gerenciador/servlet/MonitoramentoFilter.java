package br.com.treinamento.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		
		long antes = System.currentTimeMillis();
		
		String acaoNome = request.getParameter("acao");
		
		//Executar ação
		filterChain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de excecução da "+ acaoNome+": " + (depois - antes));
		
	}

}
