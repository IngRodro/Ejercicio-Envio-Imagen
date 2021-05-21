<%@page import="com.Rodrigo.DAO.ClsArchivos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ClsArchivos archivos = new ClsArchivos();
  String nombreimg = archivos.seleccionararchivos(); %>
	<img alt="" src="Files/<%=nombreimg%>">
</body>
</html>