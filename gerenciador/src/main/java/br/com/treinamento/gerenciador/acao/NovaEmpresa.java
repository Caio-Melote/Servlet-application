package br.com.treinamento.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.treinamento.gerenciador.modelo.Banco;
import br.com.treinamento.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao  {

	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = dateFormat.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		//response.sendRedirect("entrada?acao=ListaEmpresas");
		
		return"redirect:entrada?acao=ListaEmpresas";
	}
}
