<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
<link rel="stylesheet" href="styles/addemployeedetails.css">
</head>
<body>

	<form action="employeeServlet" method="post">
<input type="hidden" name="form-name" value="addemployee">
		<div class="addemp">


			<div class="addemp_container">

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>firstName:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="firstname" class="first_name"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>lastName:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="lastname" class="last_name"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>company:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="company" class="company"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>age:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="age" class="age"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>PhoneNo:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="phoneno" class="phoneNo"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>Address:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="address" class="address"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>zipCode:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="zipcode" class="zipcode"></input>
					</div>
				</div>

				<div class="addemp_container_rows">
					<div class="addemp_container_label">
						<label>salary:</label>
					</div>
					<div class="addemp_input_picker">
						<input name="salary" class="salary"></input>
					</div>
				</div>


				<div class="addemp_container_picker">
					<button class="add-button">ADD</button>
				</div>
			</div>
		</div>
	</form>
<script type="text/javascript" src="./scripts/addemployeedetails.js"></script>
</body>
</html>