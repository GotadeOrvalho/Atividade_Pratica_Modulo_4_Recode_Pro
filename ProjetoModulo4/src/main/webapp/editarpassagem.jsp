<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Passagens</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="./estilo.css">
</head>
<body class="body">
  <!--Come�o do Menu-->
  <header class="row ">
		<nav class="navbar navbar-expand-lg bg-dark px-3 m-auto ">
			<section class="container-fluid col-lg-md-sm-2">
				<a class="navbar-brand text-white fs-1 px-2 letra  menorletra" href="#"
					title="Link para a p�gina inicial."> <img src="./img/Imagem1.png" height="50"
						class="d-inline-block align-text-bottom menorletra" alt="Um avi�o entre as nuvens.">Vamos Viajar
				</a>



				<section class="collapse navbar-collapse px-0 mx-0 col-md-sm-9 justify-content-end"
					id="navbarSupportedContent">
					<ul class="nav letra">
						<li class="nav-item "><a class="nav-link active text-white letracontato" aria-current="page"
								href="passagens" title="Link pra p�gina inicial."> Lista de Passagens</a></li>
						<li class="nav-item"><a class="nav-link text-white letracontato" href="destinos"
								title="Link para a p�gina de destinos.">Lista de Destino</a></li>
						<li class="nav-item"><a class="nav-link text-white letracontato" href="clientes"
								title="Link para a p�gina de destinos.">Lista de Clientes</a></li>
					</ul>
				</section>
				<div class="col-md-sm-1 mt-3 px-0 justify-content-end mx-0 pb-3">
					<div class="dropdown">
						<button class="btn dropdown " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">
							<img src="img/img001.png" alt="" style="height: 2rem">
						</button>
						<ul class="dropdown-menu  dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="cadastropassagem.html">Cadastrar
									Passagem</a></li>
							<li><a class="dropdown-item" href="cadastrodestino.html">Cadastrar
									Destino</a></li>
							<li><a class="dropdown-item" href="cadastrocliente.html">Cadastrar
									Cliente</a></li>
							<li><a class="dropdown-item" href="index.html">Visualizar como usu�rio</a></li>
						</ul>
						<button class="navbar-toggler px-1 mx-0  " type="button" data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
							aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon  px-0 mx-0"></span>
						</button>
					</div>
				</div>

			</section>
		</nav>
	</header>
  <!--Fim do Menu-->

  <!--Come�o da Main-->
  <main class="row justify-content-center ">

      <div class="container">

        <div class="bg-white d-flex justify-content-center align-items-center vh-100 pb-5">
          <div>
            <div class="d-flex justify-content-center pt-5 cadastro1" style="width: 30rem">
              <img src="img/22646cad-5577-46be-8243-e690ed23ef75.jpeg" alt="login-icon" style="height: 4rem"
                class="pt-1">
            </div>

            <div class="text-center fs-1 letra mb-5">Edite uma Passagem:</div>

            <form action="passagens-update" class="form-control border-0">

            <div class="input-group pt-4 ">
              <div class="input-group-text">
                <i class="bi bi-person-circle"></i>
              </div>
              <input class="form-control bg-light" type=text name="id_cliente" value="${passagens.fk_cliente_id_cliente.id_cliente}" placeholder="Id do cliente" required>
            </div>

            <div class="input-group pt-4">
              <div class="input-group-text">
                <i class="bi bi-person-circle"></i>
              </div>
              <input class="form-control bg-light" type="text" name="id_destino" value="${passagens.fk_id_destino.id_destino}" placeholder="Id do destino" required>
            </div>


            <div class="input-group pt-4">
              <div class="input-group-text">
                <i class="bi bi-person-circle"></i>
              </div>
              <input class="form-control bg-light" type="text" name="num_voo" value="${passagens.num_voo}" placeholder="N�mero do v�o" required>
            </div>

            <div class="input-group pt-4">
              <div class="input-group-text">
                <i class="bi bi-person-circle"></i>
              </div>
              <input class="form-control bg-light" type="text" name="assento" value="${passagens.assento}" placeholder="Assento" required>
            </div>

            <div class="input-group pt-4">
              <div class="input-group-text">
                <i class="bi bi-person-circle"></i>
              </div>
              <input class="form-control bg-light" type=text name="data_hora" value="${passagens.data_hora}" placeholder="Embarque (aaaa/mm/dd - XX:YYh)" required>
            </div>

            <div class="input-group pt-4">
                <div class="input-group-text">
                  <i class="bi bi-person-circle"></i>
                </div>
                <input class="form-control bg-light" type="text" name="valor" value="${passagens.valor}"  placeholder="Valor" required>
            </div>

            <div class="d-flex">
							<input type="submit" value="Editar a Passagem"
								class="btn button text-white w-100  mt-4 fw-semibold shadow-sm fs-5 mx-2">
							<a href="passagens"><input type="button" value="Cancelar"
								class="btn  btn-danger text-white w-100  mt-4 fw-semibold shadow-sm fs-5 mx-2"></a>
						</div>

          </form>
          </div>
        </div>
      </div>
  </main>
  <!--Fim da Main-->

  <!--Come�o do rodap�-->
  <footer class="row">
    <section class="bg-dark">
      <section class=" text-white">
        <div class="row row-cols-1 row-cols-md-3 g-4">
          <div class="col">
            <div class="card bg-transparent text-white border-0 h-100" style="max-width: 18rem;">
              <div class="card-body pt-1">
                <h5 class="card-title">E-mail</h5>
                <p class="card-text">vamosviajar@email.com</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card bg-transparent text-white border-0 h-100" style="max-width: 18rem;">
              <div class="card-body pt-1">
                <h5 class="card-title">Endere�o</h5>
                <p class="card-text">Rua Onde fico, 333 - Centro, Capital - CE</p>
              </div>
            </div>
          </div>
          <div class="col">
            <div class="card bg-transparent text-white border-0 h-100" style="max-width: 18rem;">
              <div class="card-body pt-1">
                <h5 class="card-title">Contato</h5>
                <p class="card-text mb-0">(99) 99999-9999</p>
                <p>Hor�rio de atendimento: seg-sex, das 09h as 18h.)</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <hr class="text-white m-4">
      <section class="text-white text-center d-flex ">
        <p class="w-50 pt-2 small">Site desenvolvido por @AdrianeFerreira </p>
        <p class="w-50 pt-2 small">Em parceria da Recode Pro</p>

      </section>
    </section>
  </footer>
  <!--Fim do rodap�-->


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
</body>
</html>