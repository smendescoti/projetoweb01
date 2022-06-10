<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Inform�tica - Login de Usu�rios</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="container mt-5 col-md-4 offset-md-4 card card-body">

		<div class="text-center">
		
			<img src="https://www.cotiinformatica.com.br/imagens/logo-coti-informatica.png"/>
			<br/>
		
			<h5>Acesso ao Sistema</h5>
			<p>Informe suas credenciais para acessar o sistema.</p>
		</div>
		
		<div class="text-danger">
			<strong>${mensagem_erro}</strong>
		</div>
	
		<form method="post" action="autenticar-usuario">
		
			<div class="mb-3">
				<label>Email de acesso:</label> 
				<input type="email" class="form-control"
					name="email" required="required"
					placeholder="Digite o email aqui" />
			</div>

			<div class="mb-3">
				<label>Senha de acesso:</label> 
				<input type="password" class="form-control"
					name="senha" required="required"
					placeholder="Digite sua senha aqui" />
				
				<a href="/projetoweb01/password-recover">
					Esqueci minha senha?
				</a>
				
			</div>

			<div class="mb-2 d-grid">
				<input type="submit" value="Acessar Sistema" class="btn btn-success" />						
			</div>
			
			<div class="mb-2 d-grid">
				<a href="/projetoweb01/register-user" class="btn btn-light">
					N�o possui conta? <strong>Cadastre-se aqui!</strong>
				</a>
			</div>
			
		</form>

	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>



