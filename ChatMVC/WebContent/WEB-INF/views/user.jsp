<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Rooms</title>
	</head>

	<body>

	 <h1>${user.username}</h1>
	 
	 <br/>
	 <br/>

	 <h1>rooms owned</h1>
	 
	 
	 
	 <table>
	 <c:forEach items="${user.roomsOwned}" var="roomOwned">
					<tr>
						<td>${roomOwned.id}</td>
						<td>${roomOwned.title}</td>
						<td>${roomOwned.status}</td>	
						<td>
						<a href="room/${roomOwned.id}"><button>Join Room</button></a>
						</td>
	
					</tr>
	</c:forEach>

	</table>
	<h1>rooms invited</h1>
	 <table>
	 <c:forEach items="${user.roomsInvited}" var="roomInvited">
					<tr>
						<td>${roomInvited.id}</td>
						<td>${roomInvited.title}</td>
						<td>${roomInvited.status}</td>	
						
	
					</tr>
	</c:forEach>

	</table>
	</body>
</html>