<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹서비스 클라이언트</title>
</head>
<body>
부서번호, 부서명, 위치<br>
<c:forEach var="dept" items="${deptList }">
	${dept.deptNo}, ${dept.deptName}, ${dept.location}<br>
</c:forEach>		
</body>
</html>