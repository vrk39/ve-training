<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employeeServlet" method="post">
<input type="hidden" name="form-name" value="login">
	<header class="login_header">
	<h2 class="login_heading">Welcome to Login</h2>
	
	<button>Register</button>
	</form>
	</header>
	<div class="login_form">
		<div class="login_body">

			<div class="login_container_row">
				<div class="login_container_label">
					<label>User Name:</label>
				</div>
				<div class="login_container_picker">
					<input name="username" class="username"></input>
				</div>
			</div>
			<div class="login_container_row">
				<div class="login_container_label">
					<label>password:</label>
				</div>
				<div class="login_container_picker">
					<input name="password" class="password"></input>
				</div>
			</div>
			<div class="login_container_row">
				<div class="login_container_picker">
					<button class="login_button">Login</button>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>