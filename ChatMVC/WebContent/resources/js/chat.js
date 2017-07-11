var stompClient = null;
var url = "/wsApp/chat/";


function connect() {
    var socket = new SockJS('chat');
	stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected for Chat: ' + frame);
        stompClient.subscribe("/topic/showMessage/" + $("#chatId").val(), function(chatResult){
        	showResult(JSON.parse(chatResult.body));
        });
    });
}



function send() {
    stompClient.send(url, {}, JSON.stringify({ 'usr': $("#userId").val() ,'message': $("#message").val() }));
}


//Make the function wait until the connection is made...
function waitForSocketConnection(socket, callback){
    setTimeout(
        function () {
            if (socket.readyState === 1) {
                console.log("Connection is made.")
                if(callback != null){
                    callback();
                }
                return;

            } else {
                console.log("wait for connection...")
                waitForSocketConnection(socket, callback);
            }

        }, 5); // wait 5 milisecond for the connection...
}



function showResult(msg) {
	if (msg.sender.profilePic == true)
		$("#chatDiv").append("<p><img src='resources/imgs/" + msg.sender.username + ".png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
	else
		$("#chatDiv").append("<p><img src='resources/imgs/nopic.png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
}

$(document).ready(function(){
	url = "/wsApp/chat/" + $("#chatId").val();
	connect();

	
	$("#sendBtn").click(function(){
		send();
	});
});