<%@page import="java.util.HashMap"%>
<%@page import="kr.or.kosa.dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
 
<%
	Emp e = new Emp(2000,"kosauser");

	HashMap<String,String> hp = new HashMap<>();
	hp.put("data","1004");
	
	//해결방법
	request.setAttribute("emp", e); // EL사용가능 담아놓으면 사용 가능 emp명은 내가 키로 정한 것이다. 
	
	//권장
	request.setAttribute("hobj", hp); //담아롸!!!!!!!!!!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>기존방식</h3>
<%=e %>
<%=e.getEmpno() %><br>
<%=e.getEmpno() %><br> 

<h3>EL방식 </h3>
EL() : 자바객체 출력 (자바 객체에 대해서 직접 접근이 불가) : ${e}<br>
EL() : ${e.getEmpno()}<br>

<h3>해결사(JSTL)</h3>
1. 방법 : request객체 또는 session 객체에 담는다. good<br>
EL : ${requsetScope.emp}<br> 
EL : ${requsetScope.emp.empno}<br> 
EL : ${requsetScope.emp.ename}<br> 
--------------------------------------------
2. 방법 (JSTL 사용)<br>
1. JSTL : jar추가 
2. tablib 통해 자원 추가(namespace 명시) >> 사용 >> prefix<br>
-----------------------------------------
<!-- 
JSTL 이란?
JSP Standard Tag Library의 약자로 JSP 표준 라이브러리이다.
: JSP에서 자주 사용하는 기능(반복문과 조건문, 데이터 표현 등)을 미리 구현해 놓은 커스텀 태그 라이브러리 모음이다.
: JSTL은 EL을 사용하여 표현한다.
Apache 재단에서 진행하는 custom tag library 프로젝트
– 스크립트 릿으로 작성해야할 로직을 태그로 대신 처리 가능
– apache에서 다운받아 lib에 추가.

 -->
 <h3>JSTL(core) : 변수, 제어문(자바코드 없이): 서버에서 실행 </h3>
 <c:set var="m" value="<%=e%>"></c:set> 
<br>
JSTL 사용해서 변수 m 생성 (EL 사용해서 접근 가능) : ${m}<br>
getter 함수를 직접 사용 ( 권장하지 않아요) : ${m.getEmpno()}<br>


EL출력 (m.memberfield명 : 자동으로 getter 함수 호출 ) : ${m.empno}<br>
EL출력 (m.memberfield명 : 자동으로 setter 함수 호출 ) : ${m.ename}<br>


<!-- 
EL 출력목적  : 주로 request, session 담긴 값 
JSTL 	  : EL 도와서 변수, 제어구조를 출력 도와주어요
 -->
 
<c:set var="username" value="${m.ename}"/>
변수값 출력 : ${username}<br>

<hr>
<h3>JSTL변수 만들고 scope 정의하기</h3> 
<c:set var="job" value="농구선수" scope="request" />
당신의 직업 : ${job}<br>
만약에 당신이 include, forward를 한다면 그 페이지에서도 job이라는 값을 출력할 수 있다.  
<br>
<c:set var="job2" value="야구선수"/>
값출력 : ${job2}<br>

잘쓰지 않아요 (재미로) <br>
<c:remove var="job2"/>
변수가 없어도 (예외없이 값이 안나와요) : ${job2}


<hr>
JAVA API 활용 객체는 (직접 만든 객체는) 접근 안돼요 : ${hp}<br>
1. 권장방법 : request, session 담는다. <br>
2. JSTP  C:set 사용
<hr>
<c:set var="vhp" value="<%=hp%>"/>
hp객체 : ${vhp}<br>
hp객체 : ${vhp.data}<br>

hp권장 : ${hobj}<br>

<hr>
값을 write 가능(hp.put("color","red")) jstl가능 : 그냥 구경만 . 가능은 한데 jstl은 출력이 목적이다.  <br>
<c:set target="${vhp}" property="color" value="red"/>
hp객체 : ${vhp}<br>


</body>
</html>
 















