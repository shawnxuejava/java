<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>Chat Application Using Spring MVC and WebSocket</title>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	    <script src="<c:url value="/resources/js/sockjs-0.3.4.js" />"></script>
	    <script src="<c:url value="/resources/js/stomp.js" />"></script>
	    <script src="<c:url value="/resources/js/fabric.js" />"></script>
	    <script src="<c:url value="/resources/js/chat.js" />"></script>
	</head>
	<body>
		<noscript><h2>Enable Java script and reload this page to run WebSocket chat demo.</h2></noscript>
		<h1>Chat Application Using Spring MVC and WebSocket</h1>
		<h2>Welcome ${user}!!</h2>
		<h1>Welcome ${user.username}</h1>
		<h2>Room : ${room.id}</h2>
		<h3>Chat: ${room.chat.id}</h3>
		<br/>
		<br/>
		<br/>
		
		<p id="notificationPara"></p>
		
		<div>
			  <div id="wrapperCanvas">
                  <canvas id="c" width="500" height="500" style="border:solid;"></canvas>
              </div>
			<div id="chatDiv" style="border: solid 1px;" contenteditable="true"></div>
		    <input type="hidden" value="${user.id}" id="userId">
		    <input type="hidden" value="${room.chat.id}" id="chatId">
	        <textarea id="message" name="message" placeholder="Message..."></textarea>
	        <button id="sendBtn">Send</button>
		</div>
		
		<a href="logout">Logout</a>
	</body>
</html>











