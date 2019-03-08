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
<form action="" method="post">
<table>
<tr>
<td>New Password: </td>
<td><input type="password" name="newPassword"></td>
</tr>
<tr>
<td>Confirm: </td>
<td><input type="password" name="rePassword"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="OK"></td>
</tr>
</table>

</form>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>