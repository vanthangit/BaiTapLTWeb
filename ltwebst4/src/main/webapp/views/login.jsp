<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrapper">
		<div class="container">
			<div class="row justify-content-around">
				<form action="" method="post" class="col-md-6 bg-light p-3">
					<h1 class="text-center">LOGIN</h1>
					<div class="form-group">
						<label for="username">User name</label> 
						<input type="text" name="username" id="username" class="form-control">
					</div>

					<div class="form-group">
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" id="password" name="password">
					</div>

					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="rememberme">
						<label class="form-check-label" for="rememberme">Remember me</label>
					</div>
					<input type="submit" value = "Login" class="btn-primary btn btn-block">
				</form>
			</div>
		</div>
	</div>
</body>
</html>

