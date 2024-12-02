package br.com.treinamento.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresaList = new ArrayList<>();
	private static List<Usuario> usuarioList = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresaList.add(empresa);
		empresaList.add(empresa2);
		
		Usuario user1 = new Usuario();
		user1.setLogin("Gian");
		user1.setSenha("123");
		
		Usuario user2 = new Usuario();
		user2.setLogin("Ciroc");
		user2.setSenha("321");
	
		usuarioList.add(user1);
		usuarioList.add(user2);
	}
	
	

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresaList.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresaList;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = empresaList.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaId(Integer id) {
		
		for (Empresa empresa : empresaList) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;	
	}

	public Usuario verificaUsuario(String login, String senha) {
		
		for (Usuario user : usuarioList) {
			if(user.igual(login, senha)) {
				return user;
			}
		}
		
		return null;
	}
}
