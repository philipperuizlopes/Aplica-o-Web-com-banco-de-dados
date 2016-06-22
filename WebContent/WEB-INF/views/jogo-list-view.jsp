<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://bootswatch.com/united/bootstrap.min.css" />
<title>Jogo Servlet Jsp Jdbc</title>
</head>

<body marginwidth="10px" style="align:center">
	<h1>Incluir jogo</h1>
	<form action="/JogoServletJspJdbc/jogosList">
		<div class="col-sm-4" >
			<div class="form-group">
				<table border="2" cellpadding="5" cellspacing="5">
					<tr>
						<th width="50">Id</th>
						<th width="150">Nome</th>
						<th width="70">Gênero</th>
						<th width="50">Editar</th>
						<th width="50">Excluir</th>
					</tr>
					<c:forEach items="${jogosList}" var="jogo">
						<tr>
							<td>${jogo.id}</td>
							<td>${jogo.nome}</td>
							<td>${jogo.genero}</td>
							<td><a href="editJogo?id=${jogo.id}">Editar</a></td>
							<td><a href="deleteJogo?id=${jogo.id}">Excluir</a></td>
						</tr>
					</c:forEach>
				</table>
				<a href="createJogo">Incluir novo jogo</a>
			</div>
		</div>
	</form>
</body>
</html>