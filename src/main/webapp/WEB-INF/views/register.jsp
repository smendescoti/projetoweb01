<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Inform�tica - Criar Conta de Usu�rio</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="container mt-5 col-md-4 offset-md-4 card card-body">

		<h5>Criar conta de usu�rio</h5>
		<p>Informe seus dados para cadastrar uma conta de acesso.</p>
		
		<div class="text-danger">
			<strong>${mensagem_erro}</strong>
		</div>
		
		<div class="text-success">
			<strong>${mensagem_sucesso}</strong>
		</div>
	
		<form method="post" action="cadastrar-usuario">
		
			<div class="mb-3">
				<label>Informe seu nome:</label> 
				<input type="text" class="form-control" name="nome"
						placeholder="Digite o nome aqui" required="required" />
			</div>
		
			<div class="mb-3">
				<label>Informe seu email:</label> 
				<input type="email" class="form-control" name="email"
						placeholder="Digite o email aqui" required="required" />
			</div>
			
			<div class="mb-3">
				<label>Informe sua senha:</label> 
				<input type="password" class="form-control" name="senha"
						placeholder="Digite a senha aqui" required="required" />
			</div>
			
			<div class="mb-3">
				<label>Confirme sua senha:</label> 
				<input type="password" class="form-control" name="senhaConfirmacao"
					placeholder="Confirme a senha aqui" required="required" />
			</div>

			<div class="mb-2 d-grid">
				<input type="submit" value="Realizar Cadastro" class="btn btn-success" />						
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