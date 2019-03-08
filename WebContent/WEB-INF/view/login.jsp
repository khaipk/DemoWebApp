<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/_header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/_menu.jsp"></jsp:include>
<br>
<form method="post">
<table>
<tr>
<td>Username: </td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>Remember me?</td>
<td><input type="checkbox" name="remember"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>
</table>
</form>
<br>
<form action="register" method="get">
No Account? <input type="submit" value="Register">
</form>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>