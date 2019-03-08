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
Update girl information
<form method="post">
<table>
<tr>
<td>Code</td>
<td>${code}</td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Year</td>
<td><input type="text" name="year"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Update"></td>
</tr>
</table>
</form>
<a href="view-girl">Cancel</a>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>