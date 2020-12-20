<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca</title>
<link rel="stylesheet" href="bootstrap.min.css" />
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Biblioteca</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.html" class="active">Início</a></li>
					<li><a href="#">Administrador</a></li>
					<li><a href="#">Bibliotecário</a></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container-fluid">
		<h1>Biblioteca Municipal de Campo Bonito</h1>

		<div class="row">
			<div class="col-md-6">
				<h3>Administrador</h3>
				<form action="AdminLogin" method="post" style="width: 300px">
					<div class="form-group">
						<label for="email1">Email</label> <input type="email"
							class="form-control" name="email" id="email1" placeholder="Email" />
					</div>
					<div class="form-group">
						<label for="password1">Senha</label> <input type="password"
							class="form-control" name="password" id="password1"
							placeholder="Senha" />
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
			<div class="col-md-6">
				<h3>Bibliotecário</h3>
				<form action="LibrarianLogin" method="post" style="width: 300px">
					<div class="form-group">
						<label for="email1">Email</label> <input type="email"
							class="form-control" id="email1" name="email" placeholder="Email" />
					</div>
					<div class="form-group">
						<label for="password1">Senha</label> <input type="password"
							class="form-control" id="password1" name="password"
							placeholder="Senha" />
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
	<script src="jquery.min.js"></script>
	<script src="bootstrap.min.js"></script>
</body>
</html>