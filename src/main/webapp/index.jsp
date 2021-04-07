<%@page import="web_gradle_erp.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>데이터베이스 연동 테스트</title>
</head>
<body>
데이터데이터데이터 연동 테스트테스트
<%=JndiDS.getConnection() %>
</body>
</html>