<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	Cookie co = new Cookie("kosa","hong");
	co.setMaxAge(30*24*60*60); //30일
	response.addCookie(co);
%>
</body>
</html>