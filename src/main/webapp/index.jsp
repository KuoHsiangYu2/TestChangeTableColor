<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<title>index</title>
</head>
<body>
	<div align="center">
		<p>index.jsp</p>
		<p>請登入系統</p>
		<p>
			帳號：admin
			<br />
			密碼：admin
		</p>
		<form method="post" name="formName1" action="${pageContext.request.contextPath}/LoginServlet" enctype="application/x-www-form-urlencoded">
			帳號：
			<input type="text" id="accountId" name="accountName" />
			<br />
			<br />
			密碼：
			<input type="password" id="passwordId" name="passwordName" />
			<br />
			<br />
			<input id="submitButton" type="button" value="登入" />
		</form>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>