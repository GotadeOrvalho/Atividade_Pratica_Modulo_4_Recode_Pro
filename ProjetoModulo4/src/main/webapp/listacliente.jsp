<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Clientes Cadastrados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet" href="./estilo.css">
</head>
<body class="body">
	<!--Começo do Menu-->
	<header class="row ">
		<nav class="navbar navbar-expand-lg bg-dark px-3 m-auto ">
			<section class="container-fluid col-lg-md-sm-2">
				<a class="navbar-brand text-white fs-1 px-2 letra  menorletra"
					href="#" title="Link para a página inicial."> <img
					src="./img/Imagem1.png" height="50"
					class="d-inline-block align-text-bottom menorletra"
					alt="Um avião entre as nuvens.">Vamos Viajar
				</a>



				<section
					class="collapse navbar-collapse px-0 mx-0 col-md-sm-9 justify-content-end"
					id="navbarSupportedContent">
					<ul class="nav letra">
						<li class="nav-item "><a
							class="nav-link active text-white letracontato"
							aria-current="page" href="passagens"
							title="Link pra página inicial."> Lista de Passagens</a></li>
						<li class="nav-item"><a
							class="nav-link text-white letracontato" href="destinos"
							title="Link para a página de destinos.">Lista de Destino</a></li>
						<li class="nav-item"><a
							class="nav-link text-white letracontato" href="clientes"
							title="Link para a página de destinos.">Lista de Clientes</a></li>
					</ul>
				</section>
				<div class="col-md-sm-1 mt-3 px-0 justify-content-end mx-0 pb-3">
					<div class="dropdown">
						<button class="btn dropdown " type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<img src="img/img001.png" alt="" style="height: 2rem">
						</button>
						<ul class="dropdown-menu  dropdown-menu-end"
							aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="cadastropassagem.html">Cadastrar
									Passagem</a></li>
							<li><a class="dropdown-item" href="cadastrodestino.html">Cadastrar
									Destino</a></li>
							<li><a class="dropdown-item" href="cadastrocliente.html">Cadastrar
									Cliente</a></li>
							<li><a class="dropdown-item" href="index.html">Visualizar
									como usuário</a></li>
						</ul>
						<button class="navbar-toggler px-1 mx-0  " type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon  px-0 mx-0"></span>
						</button>
					</div>
				</div>

			</section>
		</nav>
	</header>
	<!--Fim do Menu-->

	<!--Começo da Main-->
	<main class="mb-0 row  justify-content-center ">
		<section class="row col-10  container bg-main">
		
			<div class="text-center fs-1 letra mb-0 pt-3">Lista dos clientes cadastrados</div>
			
			<a href="cadastrocliente.html"
				class="btn mb-2 botao11 col-2 text-white button fw-bolder mt-5"> Novo
				Usuario </a>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Data de Nascimento</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>Endereço</th>
						<th>Ações</th>
					</tr>
				</thead>

				<tbody>
					<jstl:forEach items="${listaClientes}" var="c">
						<tr class="mb-0 pb-0">
							<td>${c.id_cliente}</td>
							<td>${c.nome}</td>
							<td>${c.cpf}</td>
							<td>${c.data_nascimento}</td>
							<td>${c.email}</td>
							<td>${c.telefone}</td>
							<td>${c.endereco}</td>
							<td>
								<div class="d-flex">
									<div class="d-flex">
										<a href="clientes-edit?id_cliente=${c.id_cliente}" class="mx-1 mb-0 pb-0"
											title="Editar"> <i class="ri-file-edit-line mb-0 pb-0"><img
												src="./img/imagemeditar.png"></i>
										</a> <a href="clientes-delete?id=${c.id_cliente}" class="mx-1 mb-0 pb-0"
											title="Cancelar"
											onclick="return confirm('Deseja excluir o autor ${c.nome}.')">
											<i class="ri-delete-bin-2-line mb-0 pb-0"><img
												src="./img/imagemexcluir.jpg"></i>
										</a>
									</div>

								</div>
							</td>
						</tr>
					</jstl:forEach>

				</tbody>

			</table>

		</section>

	</main>
	<!--Fim da Main-->

	<!--Começo do rodapé-->
	<footer class="row pt-0 mt-0">
    <section class="bg-dark text-white text-center d-flex ">
      <p class="w-50 pt-2 small">Site desenvolvido por @AdrianeFerreira </p>
      <p class="w-50 pt-2 small">Em parceria da Recode Pro</p>
    </section>
  </footer>
	<!--Fim do rodapé-->

</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</html>
