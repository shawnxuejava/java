var stompClient = null;
var stompClient2 = null;
var url = "/wsApp/chat/";
var url2 = "/wsApp/notification";

function connect() {
    var socket = new SockJS('/ChatMVC/chat');
	stompClient = Stomp.over(socket);
	
	console.log("test");
	
    stompClient.connect({}, function(frame) {
        console.log('Connected for Chat: ' + frame);
        console.log("Chat ID: " +$("#chatId").val());
        
//        stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val(), console.debug);
        
//        stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val() , function(chatResult){
        	stompClient.subscribe("/topic/showMessage/"+ $("#chatId").val() , function(chatResult){
        	
        	console.log("received!!!");
        	//console.log(chatResult.body);
        	
        	//showResult(chatResult.body);
        	showResult(JSON.parse(chatResult.body));
//        	showResult(chatResult.body);
        });
     
        	
    });
}

function send() {
    stompClient.send(url, {}, JSON.stringify({ 'usr': $("#userId").val() ,'message': $("#message").val() }));
}

function showResult(msg) {
	
	
	console.log("in show result")
	//var test = JSON.parse(msg);
	console.log(msg);
	
	//if (msg.sender.profilePic == true)
	//	$("#chatDiv").append("<p><img src='resources/imgs/" + msg.sender.username + ".png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
	//else
	//	$("#chatDiv").append("<p><img src='resources/imgs/nopic.png' width='32' /><strong>" + msg.sender.firstname + " " + msg.sender.lastname + "</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + msg.dateTime.dayOfMonth + "/" + msg.dateTime.monthValue + "/" + msg.dateTime.year + " " + msg.dateTime.hour + ":" + msg.dateTime.minute + "</p><pre>" + msg.message + "</pre><hr/>");
		$("#chatDiv").append("<pre>" + msg.content + "</pre><hr/>");
}

$(document).ready(function(){
	url = "/wsApp/chat/" + $("#chatId").val();
	connect();
	
	$("#sendBtn").click(function(){
		send();
	});
});