<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="main.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=register method=post>
<br>
Name: <input type="text" name="name"required>
<br>
Surname:<input type="text" name="Surname"required>
<br>
UserName: <input type="text" name="Name" required>
<br>
Email: <input type="email" name="Email" required>
<br>
Password: <input type="password" name="password"  id= "password" required>
<br>
Repeat Password: <input type='password' oninput="check(this)" required>

<input type="submit" name="register"/>
</form>
</body>
</html>