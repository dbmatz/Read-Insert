<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prova</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<a href="auth/admin?acao=listar"><input class="btn btn-primary" type="button" value="Listar" /></a>

 <div class="container">
		<div class="row">
			<div class="col">
				<h2>Cadastro de livro</h2>
				<form
					action="${pageContext.request.contextPath}/com.prova.controle/IndexControle?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Titulo</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="titulo">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Autor</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="autor">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Genero</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="genero">
						</div>
					</div>

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>