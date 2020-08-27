<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
${mList }<br>
<hr>
<table border=1>
	<thead>
		<tr>
			<td>회원명</td><td>아이디</td><td>이메일</td>
			<td>비밀번호</td><td>연락처</td><td>관리자</td>
		</tr>
	</thead>
<c:forEach var="m" items="${mList }">
<tr>
	<td><c:out value="${m.name}"></c:out></td>
	<td><c:out value="${m.userId}"></c:out></td>
	<td><c:out value="${m.email}"></c:out></td>
	<td><c:out value="${fn:replace(m.pwd, m.pwd, '****')}"></c:out></td>
	<td><c:out value="${m.phone}"></c:out></td>
	<td>
		<c:if test="${m.admin eq 1}">
			<c:out value="관리자"></c:out>
		</c:if>
		<c:if test="${m.admin ne 1}">
			<c:out value=""></c:out>
		</c:if>
	</td>
</tr>
</c:forEach>
</table>
</body>
</html>





