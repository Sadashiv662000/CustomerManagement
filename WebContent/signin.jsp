<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer SignIn</title>
</head>
<body style="background-color:#ccffff">
<form action="logCustomer" method="post" >
<br>
<br>
<br>
<div align="center"><h1>Enter Details</h1></div>

 Email : 
<input type="email" name="tbemail" id="tbemail" value = "<%request.getParameter("tbemail");%>"/>
<br>
Password : 
<input type="password" name="tbpass" id="tbpass" value = "<%request.getParameter("tbpass");%>"/>


<br>

<input type="submit" value="sign in"/>
</form>
</body>
</html>