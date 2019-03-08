<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Girl information</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/_header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/view/_menu.jsp"></jsp:include>
<br>
<div style="background: #E0E0E0; height:100px">
<h3>Girl information</h3>
<table border="1">
<tr>
<th>Code</th>
<th>Name</th>
<th>Year</th>
<th>Address</th>
</tr>
<tr>
<td>${code}</td>
<td>${name}</td>
<td>${year}</td>
<td>${address}</td>
</tr>
</table>
</div>
<div>
<h3>Girl pictures</h3>
<img alt="1" src="/BookGirl/picture/1.jpg"> 
<img alt="2" src="picture/5.jpg"> 
<img alt="3" src="picture/3.jpg"> 
<img alt="4" src="picture/4.jpg"> <br>
</div>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>