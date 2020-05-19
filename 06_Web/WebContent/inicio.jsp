<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Password correcto!!!</H1>
	<h2 style="color:blue"><%=request.getParameter("nombre") %></h2>
	<h2 style="color:green"><%=request.getAttribute("fecha") %></h2>
	<h2 style="color:red"><%=session.getAttribute("fechaSession") %></h2>
	<a href="inicio.jsp?nombre=<%=request.getParameter("nombre") %>">Recargar</a>
</body>
</html>