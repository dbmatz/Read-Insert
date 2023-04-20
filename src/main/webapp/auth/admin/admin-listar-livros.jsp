<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Livros</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<a href="${pageContext.request.contextPath}/"><input class="btn btn-primary" type="button" value="Novo" /></a>

	<div class="container">
		<div class="row">
			
			<div class="col">
				<h2>
					Livros
				</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Titulo</th>
							<th>Autor</th>
							<th>Genero</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="livros" items="${listaLivros}">
							<tr>
								<td><c:out value="${livros.id}" /></td>
								<td><c:out value="${livros.titulo}" /></td>
								<td><c:out value="${livros.autor}" /></td>
								<td><c:out value="${livros.genero}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>