<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Inform�tica - Recuperar Senha</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="container mt-5 col-md-4 offset-md-4 card card-body">

		<h5>Recupera��o de Senha</h5>
		<p>Informe seu email para recuperar a senha de acesso.</p>
	
		<form>
		
			<div class="mb-3">
				<label>Email:</label> 
				<input type="text" class="form-control"
					placeholder="Digite o email aqui" />
			</div>

			<div class="mb-2 d-grid">
				<input type="submit" value="Recuperar Senha" class="btn btn-success" />						
			</div>
			
			<div class="mb-2 d-grid">
				<a href="/projetoweb01/" class="btn btn-light">
					Voltar para a p�gina de login
				</a>
			</div>
			
		</form>

	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>



