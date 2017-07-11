<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	    <script src="<c:url value="/resources/js/sockjs-0.3.4.js" />"></script>
	    <script src="<c:url value="/resources/js/stomp.js" />"></script>
	    <script src="<c:url value="/resources/js/chat.js" />"></script>


</head>
<body>

	<h1>Welcome ${user.username}</h1>
	<h2>Room : ${room.id}</h2>
	
	<h3>Chat: ${room.chat.id}</h3>
	
	<p id="notificationPara"></p>
	
	
</body>
</html>