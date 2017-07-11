<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="resources/js/bootstrap.min.js" />

<title>Login</title>
</head>
<body>

	<label class="text-danger"> ${errorMsg} </label>
	<sf:form action="processLogin" method="post" modelAttribute="user">

		<sf:errors path="username" cssClass="error" element="div" />
		<sf:label path="username">Username: </sf:label>
		<sf:input path="username" />
		<br />

		<sf:errors path="password" cssClass="error" element="div" />
		<sf:label path="password">Password: </sf:label>
		<sf:password path="password" />
		<br />
		<input type="submit" value="Login">

	</sf:form>

	



</body>
</html>