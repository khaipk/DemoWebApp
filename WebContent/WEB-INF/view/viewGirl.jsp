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
Girl pictures here
<table border="1" >
<tr>
<th>Code</th>
<th>Name</th>
<th>Year</th>
<th>Address</th>
</tr>
<c:forEach items="${list}" var="girl">
<tr>
<td>${girl.code}</td>
<td>${girl.name}</td>
<td>${girl.year}</td>
<td>${girl.address}</td>
<td><a href="edit-girl?code=${girl.code}">Edit</a></td>
<td><a href="delete-girl?code=${girl.code}">Delete</a></td>
<td><a href="girl-info?code=${girl.code}">Infomation</a></td>
</tr>
</c:forEach>
<tr>
<td></td>
<td><a href="add-girl">Add Girl</a></td>
</tr>
</table>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>