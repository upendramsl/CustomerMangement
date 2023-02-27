<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer login</title>
</head>
<body>
<h1>Welcome to Customer Login Page</h1>
<form action="login" method="post" >
<label for="tbemail">Enter Your Email:</label>
<input type="email" name="tbemaillog" required="required" id="tbemail"
value="<%=request.getParameter("tbemail")%>">
<br>
<label for="tbpass">Enter Your Password:</label>
<input type="password" name="tbpasslog" required="required" id="tbpass"
value="<%=request.getParameter("tbpass")%>">
<br>
<input type="submit" value="Login">
</form>
</body>
</html>