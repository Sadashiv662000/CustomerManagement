<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import = "com.techpalle.util.SuccessPage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<%
SuccessPage spjsp = (SuccessPage) request.getAttribute("successdetails");
%>
<header>
<h1><%=spjsp.h1 %></h1>
</header>
<p><%=spjsp.p %></p>
<footer>
<h3><%= spjsp.h3 %></h3>
</footer>



</body>
</html>