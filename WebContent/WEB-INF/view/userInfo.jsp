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

Welcome ${username} <br>
Contact detail: ${contact}
<br>
<form method="get" action="change-password">
<input type="submit" value="Change Password">
</form>

<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</body>
</html>