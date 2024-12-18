<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.treinamento.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
<style>

body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.button {
	display: inline-block;
	padding: 5px 10px;
	background-color: #202C3A;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	margin-left: 10px;
}

.button-remove {
	display: inline-block;
	padding: 5px 10px;
	background-color: #202C3A;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	margin-left: 10px;
}

.container {
	padding: 20px;
}

.empresa-list {
	list-style-type: none;
	padding: 0;
	margin: 0 auto; /* Centraliza a lista horizontalmente */
	display: table; /* Faz a lista ocupar o espa�o m�nimo necess�rio */
}

.empresa-list li {
	background-color: white;
	margin: 10px 0;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.container h2 {
	text-align: center;
}
</style>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<div class="container">
		<p>Usu�rio Logado: ${usuarioLogado.login}</p>

		<c:if test="${not empty empresa}">
			<p>${empresa}cadastrada!!!</p>
		</c:if>

		<a class="button" href="/gerenciador/entrada?acao=FormEmpresa">Adicionar
			Empresa</a>

		<h2>Lista de empresas:</h2>
		<ul class="empresa-list">
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome}-<fmt:formatDate
						value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> <a
					class="button"
					href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
					<a class="button-remove"
					href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>
