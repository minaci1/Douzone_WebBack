<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	//EL은 대체 <%= write 대체목적
	
	//자바가 가지는 자원들 ... EL과 JSTL 못해요
	
	Date today = new Date();
	request.setAttribute("day", today); // 그 페이지만 
	session.setAttribute("day2", today); // 모든페이지
	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>EL 화면 출력 ( 서버쪽 자원을 ..)</h3>
	EL : ${requestScope.day}<br>
	EL : ${day}<br><!-- day 어떤 객체에 담겨있는 거야 (session, request 판단안됨 앞에 객체 명시하자) -->
	EL : data2:${day2}<br>
	EL : ${sessionScope.day2}<br>
</body>
</html>