<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
</head>
<body>
	<form method="get" action="employeeServlet">
		<input type="hidden" name="form-name" value="logout">
		<h3>login success.</h3>
		<%
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		%>
		<%
		String username = null;
		if(session.getAttribute("username")==null){
			response.sendRedirect("loginform.jsp");
		}else
			username = (String)session.getAttribute("username");
		%>
		<h3>session id=<%=username %></h3>
		<button>AddEmployee</button>
		<button>UpdateEmployee</button>
		<button>RemoveEmployee</button>
		
		<button>logout</button>
	</form>
</body>
</html>