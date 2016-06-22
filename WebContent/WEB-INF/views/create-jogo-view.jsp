<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://bootswatch.com/united/bootstrap.min.css" />
<title>Jogo Servlet Jsp Jdbc</title>
</head>

<body marginwidth="10px">
	<h1>Incluir jogo</h1>
	<form method="POST" action="/JogoServletJspJdbc/doCreateJogo">
		<div class="col-sm-4">
			<div class="form-group">
				<label>Nome:</label> <input type="text" id="nome" name="nome"
					class="form-control">
			</div>
			<div class="form-group">
				<label>Gênero:</label> <input type="text" id="genero" name="genero"
					class="form-control">
			</div>
			<button class="btn" type="submit">Incluir</button>
			<a href="jogosList">Cancelar</a>
		</div>

	</form>

</body>
</html>