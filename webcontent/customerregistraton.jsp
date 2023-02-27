<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer registration</title>
</head>
<body>
<h1>Welcome To Customer Registration</h1>
<h3>Please Fill Details For Registration</h3>
<form action="RegCustomer" method="post">
<label for="tbname">Enter Your Name:</label>
<input type="text" name="tbname" id="tbname" required="required" >
<br>
<label for="tbtel">Enter Your Mobile number:</label>
<input type="tel" name="tbtel" id="tbtel" required="required">
<br>
<label for="tbemail">Enter Your Email:</label>
<input type="email" name="tbemail" id="tbemail" required="required">
<br>
<label for="tbpass">Enter Password:</label>
<input type="password" name="tbpass" id="tbpass" required="required">
<br>
<label>select State:</label>
<select name="ddlstates" required="required">
<option>..select..</option>
<option value="Karnataka">KA</option>
<option value="Tamilnadu">TN</option>
<option value="Andhra Pradesh">Ap</option>
<option value="Kerala">KL</option>

</select>
<input type="submit" value="register">
</form>
</body>
</html>